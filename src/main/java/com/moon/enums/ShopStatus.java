package com.moon.enums;

/**
 * Created by Administrator on 2015/12/13.
 */
public enum ShopStatus {
    ENABLED(1),
    DISABLED(0),
    NOT_EXIST(2),
    EXIST(3),
    ERROR(-1);
    private Integer status;
    private ShopStatus(Integer status) {
        this.status=status;
    }

    public  Integer of() {
        return this.status;
    }

}
