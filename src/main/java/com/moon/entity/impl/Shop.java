package com.moon.entity.impl;

import java.util.Date;
import java.util.Objects;

import com.moon.entity.Entity;

public class Shop extends Entity{
	private static final long serialVersionUID = -6459205732435410183L;
	private long id;
	private String name;
	private String address;
	private String tel;
	private String boss;
	private String intro;
	private Date establishTime;
	private transient String password;
	private Integer shopStatus;

    public Integer getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(Integer shopStatus) {
        this.shopStatus = shopStatus;
    }

    public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getBoss() {
		return boss;
	}
	public void setBoss(String boss) {
		this.boss = boss;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Date getEstablishTime() {
		return establishTime;
	}
	public void setEstablishTime(Date establishTime) {
		this.establishTime = establishTime;
	}

    @Override
    public boolean equals(Object obj) {
        Shop shop= (Shop) obj;
        Objects.requireNonNull(shop,"shop should not be null");
        Objects.requireNonNull(shop.getName(),"shop name should not be null");
        Objects.requireNonNull(shop.getPassword(),"shop password should not be null");
        return this.name.equals(shop.getName())&&this.password.equals(shop.getPassword());
    }
}
