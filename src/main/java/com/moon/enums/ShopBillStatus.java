package com.moon.enums;

/**
 * Created by Administrator on 2016/1/10.
 */
public enum ShopBillStatus {
    //修改
    MODIFY(0),
    //取消
    CANCEL(1),
    //完成
    COMPLETED(2),
    //进行中
    COMPLETING(3);
    private int status;
    private ShopBillStatus(int status){
        this.status=status;
    }
    public  ShopBillStatus of(int status){
        switch(status){
            case 0:
                return MODIFY;
            case 1:
                return CANCEL;
            case 2:
                return COMPLETED;
            case 3:
                return COMPLETING;
        }
        return null;
    }
    public int valueOf(){
        return this.status; 
    }
}
