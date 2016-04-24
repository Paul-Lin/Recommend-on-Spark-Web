package com.moon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.common.AppConstant;
import com.moon.dao.impl.ShopMenuDao;
import com.moon.dao.impl.ShopMenuImageDao;
import com.moon.entity.dto.RecommendMenuDto;
import com.moon.entity.impl.RecommendMenu;
import com.moon.entity.impl.ShopMenu;
import com.moon.entity.impl.ShopMenuImage;
import com.moon.service.MoonService;
@Service("shopImageService")
public class ShopMenuImageService implements MoonService{
	private static final long serialVersionUID = -8150320943616333807L;
	private static final Logger log=LoggerFactory.getLogger(ShopMenuImageService.class);
	@Autowired
	private RecommendService recommendService;
	@Autowired
	private ShopMenuImageDao shopMenuImageDao;
	@Autowired
	private ShopMenuDao shopMenuDao;
	@SuppressWarnings("unchecked")
	public List<RecommendMenuDto> recommendShopMenu(long customerId){
		final List<RecommendMenuDto> list=new ArrayList<RecommendMenuDto>();
		try{
			List<RecommendMenu> recommendMenu=recommendService.query(customerId);
			recommendMenu.stream().forEach(x->{
				final RecommendMenuDto dto=new RecommendMenuDto();
				dto.setId(x.getShopMenuId());
				final ShopMenu t=new ShopMenu();
				t.setId(x.getShopMenuId());
				final ShopMenu menu=(ShopMenu) shopMenuDao.retrieved(t);
				dto.setIntro(menu.getIntro());
				dto.setName(menu.getName());
				dto.setShopId(menu.getShopId());
				final ShopMenuImage image=new ShopMenuImage();
				image.setShopMenuId(x.getShopMenuId());
				dto.setImages((List<ShopMenuImage>) shopMenuImageDao.retrievedByShopMenuId(image, 0L, AppConstant.PAGE));
				dto.setCustomerId(x.getUserId());
				dto.setIllustration(dto.getImages().get(0).getPath());
				list.add(dto);
			});
			return list;
		}catch(Exception e){
			e.printStackTrace();
			log.error("exception detail: {}",e.getMessage());
			throw new RuntimeException("It can not recommend shop menu in ShopMenuImageService");
		}
	}
}
