package com.moon.common;

import com.moon.entity.MoonEntity;
import com.moon.entity.impl.Shop;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2015/12/11.
 */
public class MoonContext {
    private static MoonContext context=null;
    private static ConcurrentHashMap<String,Shop> map=new ConcurrentHashMap<String,Shop>();
    private MoonContext() {

    }
    public static MoonContext getInstance(){
        if(Objects.isNull(context))
            context=new MoonContext();
        return context;
    }

    public static Shop getShop(String name)
    {
        return map.get(name);
    }

    public static void putShop(String name,Shop entity)
    {
        Objects.requireNonNull(name,"shop name shoud not be null in the MoonContext.putShop()");
        Objects.requireNonNull(entity,"Shop shoud be not be null int the MoonContext.putShop()");
        map.put(name,entity);
    }
}
