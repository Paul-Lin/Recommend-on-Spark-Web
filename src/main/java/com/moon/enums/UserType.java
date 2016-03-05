package com.moon.enums;

/**
 * Created by Administrator on 2016/1/3.
 */
public enum UserType {
    SHOP(0),
    USER(1);
    private Integer type;
    private UserType(Integer type)
    {
        this.type=type;
    }
    public Integer of(){
        return this.type;
    }
}
