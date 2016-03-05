package com.moon.entity;

import com.google.gson.GsonBuilder;

/**
 * Created by Administrator on 2015/12/9.
 */
public abstract class Entity implements MoonEntity,RetrievedCondition{
    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
