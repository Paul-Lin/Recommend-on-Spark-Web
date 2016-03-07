package com.moon.entity;

import com.google.gson.GsonBuilder;

/**
 * Created by Administrator on 2015/12/9.
 */
public abstract class Entity implements MoonEntity,RetrievedCondition{
    private static final long serialVersionUID = -3683922519725441542L;

	@Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
