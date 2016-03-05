package com.moon.dao;

import com.moon.entity.MoonEntity;
public interface Dao<T extends MoonEntity> extends Deletable<T>,Insertable<T>,Updatable<T>{

}
