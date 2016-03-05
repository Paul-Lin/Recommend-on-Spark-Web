package com.moon.entity.impl;

import java.util.Date;

import com.google.gson.GsonBuilder;
import com.moon.entity.MoonEntity;
import com.moon.entity.RetrievedCondition;

/**
 * Created by Administrator on 2016/1/10.
 */
public class ShopBill implements MoonEntity,RetrievedCondition{
	private static final long serialVersionUID = 4319771333995879254L;
	private long id;
    private long shopMenu;
    private double payNum;
    private long from;
    private long to;
    private Date createAt;
    private int status;

   

    public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public long getShopMenu() {
		return shopMenu;
	}



	public void setShopMenu(long shopMenu) {
		this.shopMenu = shopMenu;
	}



	


	public double getPayNum() {
		return payNum;
	}



	public void setPayNum(double payNum) {
		this.payNum = payNum;
	}



	public long getFrom() {
		return from;
	}



	public void setFrom(long from) {
		this.from = from;
	}



	public long getTo() {
		return to;
	}



	public void setTo(long to) {
		this.to = to;
	}



	public Date getCreateAt() {
		return createAt;
	}



	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int i) {
		this.status = i;
	}



	@Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
