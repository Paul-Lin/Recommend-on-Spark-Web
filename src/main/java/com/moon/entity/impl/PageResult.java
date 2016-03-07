package com.moon.entity.impl;

import com.google.gson.GsonBuilder;
import com.moon.entity.Entity;

/**
 * Created by Administrator on 2015/12/10.
 */
public class PageResult extends Entity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7375062775174903184L;
	private int pageSize;
    private Object object;
    private boolean isSuccess;
    private int code;
    private String desc;
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }

}
