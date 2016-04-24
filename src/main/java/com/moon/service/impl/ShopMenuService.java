package com.moon.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.common.AppConstant;
import com.moon.dao.impl.ShopMenuDao;
import com.moon.dao.impl.ShopMenuImageDao;
import com.moon.entity.dto.ShopMenuDto;
import com.moon.entity.impl.ShopMenu;
import com.moon.entity.impl.ShopMenuImage;
import com.moon.entity.impl.ShopMenuImage.BuildShopMenuImage;
import com.moon.service.MoonService;

@Service("shopMenuService")
public class ShopMenuService implements MoonService {
	private static final long serialVersionUID = -1814515413979286475L;
	@Autowired
	private ShopMenuDao shopMenuDao;
	@Autowired
	private ShopMenuImageDao shopMenuImageDao;
	private static final Logger log = LoggerFactory.getLogger(ShopMenuService.class);

	@SuppressWarnings("unchecked")
	public ShopMenuDto queryByShopMenuId(long shopMenuId) {
		Objects.requireNonNull(shopMenuId, "shopMenuId should be assigned but not found");
		ShopMenuDto dto = null;
		ShopMenu t = new ShopMenu();
		t.setId(shopMenuId);
		try {
			ShopMenu menu = (ShopMenu) shopMenuDao.retrieved(t);
			if (Objects.nonNull(menu)) {
				dto = new ShopMenuDto();
				dto.setId(menu.getId());
				dto.setShopId(menu.getShopId());
				dto.setName(menu.getName());
				dto.setIntro(menu.getIntro());
				ShopMenuImage image = new ShopMenuImage();
				image.setShopMenuId(dto.getId());
				List<ShopMenuImage> images = (List<ShopMenuImage>) shopMenuImageDao.retrievedByShopMenuId(image, 0L,
						AppConstant.PAGE);
				dto.setIllustration(images.get(0).getPath());
				dto.setImages(images);
			}
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not query by shopmenu id in ShopMenuService");
		}
	}

	@SuppressWarnings({ "unchecked"})
	public List<ShopMenuDto> queryByShopId(long shopId, long offset, int pageSize) {
		Objects.requireNonNull(shopId, "shopId should be assigned but not found.");
		ShopMenu t = new ShopMenu();
		t.setShopId(shopId);
		try {
			return queryShopMenuImage((List<ShopMenu>) shopMenuDao.retrievedByShopId(t, offset, pageSize),offset,pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not query in ShopMenuService");
		}
	}
	@SuppressWarnings({ "unchecked"})
	private List<ShopMenuDto> queryShopMenuImage(List<ShopMenu> menus,long offset,int pageSize){
		Objects.requireNonNull(menus);
		List<ShopMenuDto> list = new ArrayList<ShopMenuDto>();
		menus.stream().forEach(x -> {
			ShopMenuDto dto = new ShopMenuDto();
			dto.setId(x.getId());
			dto.setIntro(x.getIntro());
			dto.setName(x.getName());
			dto.setShopId(x.getShopId());
			dto.setImages((List<ShopMenuImage>) shopMenuImageDao
					.retrievedByShopMenuId(BuildShopMenuImage.build(x.getId()), offset, pageSize));
			
			if (!dto.getImages().isEmpty()){
				dto.setIllustration(dto.getImages().get(0).getPath());
			}
			list.add(dto);
		});
		return list;
	}
	public boolean insert(ShopMenuDto dto) {
		Objects.requireNonNull(dto.getName(), "the name should be assignment but not found.");
		Objects.requireNonNull(dto.getIntro(), "the intro should be assignment but not found.");
		Objects.requireNonNull(dto.getShopId(), "the shopId should be assignment but not found.");
		ShopMenu t = new ShopMenu();
		t.setName(dto.getName());
		t.setIntro(dto.getIntro());
		t.setShopId(dto.getShopId());
		try {
			ShopMenu menu=new ShopMenu();
			menu.setIntro(dto.getIntro());
			menu.setName(dto.getName());
			menu.setShopId(dto.getShopId());
			shopMenuDao.insert(menu);
			
			final ShopMenu xmenu=(ShopMenu) shopMenuDao.retrievedByShopId(t, 0, AppConstant.PAGE).parallelStream().findFirst().get();
			dto.getImages().parallelStream().forEach(x->{
				ShopMenuImage image=new ShopMenuImage();
				image.setPath(x.getPath());
				image.setShopMenuId(xmenu.getId());
				shopMenuImageDao.insert(image);
			});
			
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not insert in shopMenuService");
		}
	}

	public boolean delete(long shopMenuId) {
		ShopMenu t = new ShopMenu();
		t.setId(shopMenuId);
		try {
			ShopMenuImage image = new ShopMenuImage();
			image.setShopMenuId(shopMenuId);
			return shopMenuDao.delete(t);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not delete in shopMenuService.");
		}
	}
	public boolean updateByShopMenuId(ShopMenuDto dto){
		Objects.requireNonNull(dto);
		try{
			ShopMenu t=new ShopMenu();
			t.setId(dto.getId());
			t.setIntro(dto.getIntro());
			t.setName(dto.getName());
			t.setShopId(dto.getShopId());
			return shopMenuDao.update(t);
		}catch(Exception e){
			e.printStackTrace();
			log.error("exception detail: {}",e.getMessage());
			throw new RuntimeException("Can not update by ShopMenuId in ShopMenuService");
		}
	}
	public boolean update(String name, String intro, long shopId, long id) {
		Objects.requireNonNull(name, "The argument of name should be assignment but not found.");
		Objects.requireNonNull(intro, "The argument of intro should be assignment but not found.");
		ShopMenu t = new ShopMenu();
		t.setId(id);
		t.setIntro(intro);
		t.setName(name);
		t.setShopId(shopId);
		try {
			return shopMenuDao.update(t);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not update in shopMenuService.");
		}
	}
	
	public List<ShopMenuDto> queryByNameOrIntro(String content,long offset,int pageSize){
		Objects.requireNonNull(content,"content should be assignment but found null");
		return queryShopMenuImage(null,offset,pageSize);
	}
}
