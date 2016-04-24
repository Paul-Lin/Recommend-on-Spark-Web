package com.moon.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.moon.entity.impl.ShopMenuImage;

public interface ShopMenuImageMapper {
	@Select("select * from shop_menu_image where shop_menu_image_fk_shop_menu_id=#{shopMenuId}")
	@ResultMap("shopMenuImage")
	public List<ShopMenuImage> retrieved(@Param("shopMenuId")long shopMenuId,long offset,int pageSize);
	
	@Update("update shop_menu_image set shop_menu_image_path=#{path},shop_menu_image_fk_shop_menu_id=#{shopMenuId} where shop_menu_image_pk_id=#{id}")
	public int update(@Param("path")String path,@Param("shopMenuId")long shopMenuId,@Param("id")long id);
	
	@Delete("delete from shop_menu_image where shop_menu_image_pk_id=#{id}")
	public int delete(@Param("id")long id);
	
	@Delete("delete from shop_menu_image where shop_menu_image_fk_shop_menu_id=#{shopMenuId}")
	public int deleteByShopImageMenuId(@Param("shopMenuId")long shopMenuId);
	
	@Insert("insert into shop_menu_image(shop_menu_image_path,shop_menu_image_fk_shop_menu_id) values(#{path},#{shopMenuId})")
	public int insert(@Param("path")String path,@Param("shopMenuId")long id);
}
