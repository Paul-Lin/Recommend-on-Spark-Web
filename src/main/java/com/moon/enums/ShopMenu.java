package com.moon.enums;

/**
 * Created by Administrator on 2016/1/9.
 */
public enum ShopMenu {
    COMMENT_WALL(2),
    PHOTO_WALL(3),
    NOTICE(4),
    BILL_MANAGE(5),
    MENU_MANAGE(6),
    SHOP_SETTING(7);
    private int id;
    private ShopMenu(int id){
        this.id=id;
    }
    public static ShopMenu of(int id){
        switch(id){
            case 2:
                return COMMENT_WALL;
            case 3:
                return PHOTO_WALL;
            case 4:
                return NOTICE;
            case 5:
                return BILL_MANAGE;
            case 6:
                return MENU_MANAGE;
            case 7:
                return SHOP_SETTING;
            default:
                return BILL_MANAGE;
        }
    }
    public int valueOf(){
    	return this.id;
    }
}
