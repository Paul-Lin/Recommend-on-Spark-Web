package com.moon.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.moon.entity.impl.ShopMenu;

public interface ShopMenuMapper {
	@Update("update shop_menu set shop_menu_name=#{name} ,shop_menu_intro=#{intro} ,shop_menu_fk_shop_id=#{shopId} where shop_menu_pk_id=#{id}")
	public int update(@Param("name") String name, @Param("intro") String intro,@Param("shopId")long shopId, @Param("id") long id);

	@Delete("delete from shop_menu where shop_menu_pk_id=#{id}")
	public int delete(@Param("id") long id);

	@Insert("insert into shop_menu (shop_menu_fk_shop_id,shop_menu_name,shop_menu_intro) values(#{id},#{name},#{intro})")
	public int insert(@Param("name") String name, @Param("intro") String intro, @Param("id") long shopId);

	@Select("select * from shop_menu where shop_menu_fk_shop_id=#{id} order by shop_menu_pk_id desc limit #{offset},#{pageSize} ")
	@ResultMap("shopMenu")
	public List<ShopMenu> queryByShopId(@Param("id") long shopId,@Param("offset")long offset,@Param("pageSize")int pageSize);
	
	@Select("select * from shop_menu where shop_menu_pk_id=#{id}")
	@ResultMap("shopMenu")
	public ShopMenu query(@Param("id")long id);
	
	@Select("select * from shop_menu where shop_menu_name like #{name} or shop_menu_intro like #{intro} limit #{offset},#{pageSize}")
	@ResultMap("shopMenu")
	public List<ShopMenu> queryNameOrIntro(@Param("name")String name,@Param("intro")String intro,@Param("offset")long offset,@Param("pageSize")int pageSize);

}
