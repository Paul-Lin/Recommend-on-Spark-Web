package com.moon.action.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.moon.action.Action;
import com.moon.common.AppConstant;
import com.moon.entity.dto.ShopMenuDto;
import com.moon.entity.impl.PageResult;
import com.moon.entity.impl.Shop;
import com.moon.entity.impl.ShopMenuImage;
import com.moon.enums.ShopMenu;
import com.moon.service.impl.ShopMenuService;
import com.moon.service.impl.ShopService;

/**
 * Created by Administrator on 2015/12/9.
 */
@Controller
@RequestMapping(value = "/shop")
public class ShopAction extends Action {
	private static final long serialVersionUID = 326285203412367955L;
	private static final Logger log = LoggerFactory.getLogger(ShopAction.class);
	@Autowired
	private ShopService shopService;
	@Autowired
	private ShopMenuService shopMenuService;

	@RequestMapping(value = "url")
	public ModelAndView view(@RequestParam(value = "path") String path) {
		ModelAndView view = new ModelAndView(path);
		return view;
	}

	@RequestMapping(value = "index")
	public ModelAndView index(@RequestParam(value = "menu", defaultValue = "5") Integer menu) {
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("menu", ShopMenu.of(menu));
		ModelAndView view = new ModelAndView("shop/index", map);
		return view;
	}

	@RequestMapping(value = "saleSum")
	@ResponseBody
	public PageResult saleSum(@RequestParam(value = "start") String start, @RequestParam(value = "end") String end) {
		PageResult result = new PageResult();
		// LocalDate startDate=LocalDate.parse(start);
		// LocalDate endDate=LocalDate.parse(end);

		return result;
	}

	@RequestMapping("menu-manage")
	public ModelAndView menuManager(HttpServletRequest request,
			@RequestParam(value = "nickname", required = false) String nickname,
			@RequestParam(value = "password", required = false) String password) {
		ModelAndView view = null;
		try {
			if (request.getSession().getAttribute(AppConstant.SHOP) != null) {
				Shop shop = (Shop) request.getSession().getAttribute(AppConstant.SHOP);
				view = new ModelAndView("shop/menu-manage");
				addMenuView(request, shop, view);
			} else if (StringUtils.isNotBlank(nickname) && StringUtils.isNotBlank(password)) {
				if (shopService.login(nickname, password)) {
					view = new ModelAndView("shop/menu-manage");
					Shop shop = shopService.queryByName(nickname).get();
					addMenuView(request, shop, view);

				}
			} else
				view = new ModelAndView("shop/login");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			view = new ModelAndView("shop/login");
			return view;

		}
		return view;
	}

	private void addMenuView(HttpServletRequest request, Shop shop, ModelAndView view) {
		Objects.requireNonNull(request);
		Objects.requireNonNull(shop);
		Objects.requireNonNull(view);

		view.addObject("menu", ShopMenu.MENU_MANAGE);
		view.addObject("title", shop.getName() + "的菜单管理--Moon Plan 不知美好");
		request.getSession().setAttribute(AppConstant.SHOP, shop);
		List<ShopMenuDto> dtos = shopMenuService.queryByShopId(shop.getId(), 0L, AppConstant.PAGE);
		view.addObject(AppConstant.SHOP_MENU_DTO, dtos);
	}

	@RequestMapping("menu-insert")
	public ModelAndView insertMenu(MultipartHttpServletRequest request, HttpServletResponse response,
			@RequestParam("file") MultipartFile file, @RequestParam("inputMenuName") String name,
			@RequestParam("inputMenuIntro") String intro) {
		ModelAndView view = null;
		try {
			Shop shop = (Shop) request.getSession().getAttribute(AppConstant.SHOP);
			ShopMenuDto dto = new ShopMenuDto();
			dto.setIntro(intro);
			dto.setName(name);
			dto.setShopId(shop.getId());
			List<ShopMenuImage> images = new ArrayList<ShopMenuImage>();
			ShopMenuImage image = new ShopMenuImage();
			String imagePath=UUID.randomUUID().toString();
			String path = new StringBuilder().append(request.getSession().getServletContext().getRealPath("img/"))
					.append(image).toString();
			File targetFile = new File(path);
			if (!targetFile.exists())
				targetFile.mkdirs();

			file.transferTo(targetFile);

			image.setPath(imagePath);
			images.add(image);
			dto.setImages(images);
			shopMenuService.insert(dto);
			request.getRequestDispatcher("/shop/menu-manage.action").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getCause());
			view = new ModelAndView("/common/error");
			return view;
		}
		return view;
	}

	@RequestMapping("menu-query")
	@ResponseBody
	public PageResult queryMenu(HttpServletRequest request, @RequestParam("id") long id) {
		PageResult result = new PageResult();
		try {
			ShopMenuDto dto = shopMenuService.queryByShopMenuId(id);
			result.setIsSuccess(true);
			result.setObject(dto);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			result.setIsSuccess(false);
			return result;
		}
		return result;
	}

	@RequestMapping("menu-update")
	@ResponseBody
	public PageResult updateMenu(@RequestParam("id") long id, @RequestParam("name") String name,
			@RequestParam("intro") String intro, @RequestParam("shopId") long shopId) {
		PageResult result = new PageResult();
		try {
			ShopMenuDto dto = new ShopMenuDto();
			dto.setId(id);
			dto.setShopId(shopId);
			dto.setName(name);
			dto.setIntro(intro);
			result.setIsSuccess(shopMenuService.updateByShopMenuId(dto));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			result.setIsSuccess(false);
			return result;
		}
		return result;
	}

	@RequestMapping("menu-delete")
	@ResponseBody
	public PageResult deleteMenu(@RequestParam("id") long id) {
		PageResult result = new PageResult();
		try {
			result.setIsSuccess(shopMenuService.delete(id));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			result.setIsSuccess(false);
			return result;
		}
		return result;
	}
}
