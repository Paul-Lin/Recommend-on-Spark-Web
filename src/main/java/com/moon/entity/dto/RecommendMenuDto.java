package com.moon.entity.dto;

import java.util.List;

import com.google.gson.GsonBuilder;
import com.moon.entity.MoonEntity;
import com.moon.entity.impl.ShopMenuImage;

public class RecommendMenuDto implements MoonEntity {
	private static final long serialVersionUID = -4390801660282698903L;
	private long id;
	private String name;
	private String intro;
	private long shopId;
	private List<ShopMenuImage> images;
	private long customerId;
	private String illustration;

	public String getIllustration() {
		return illustration;
	}

	public void setIllustration(String illustration) {
		this.illustration = illustration;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public long getShopId() {
		return shopId;
	}

	public void setShopId(long shopId) {
		this.shopId = shopId;
	}

	public List<ShopMenuImage> getImages() {
		return images;
	}

	public void setImages(List<ShopMenuImage> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}

}
