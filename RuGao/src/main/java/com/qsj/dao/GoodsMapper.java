package com.qsj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qsj.pojo.Goods;



public interface GoodsMapper {
	/**
	 * 通过分类的id获取商品
	 * @param categoryId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getGoodsByCategoryId(
			@Param("categoryId") Integer categoryId,
			@Param("offset") Integer offset,
			@Param("count") Integer count);

	/**
	 * 获取该分类的所有记录的个数
	 * @param categoryId
	 * @return
	 */
	Integer getCount(Integer categoryId);
	/**
	 * 通过title查询商品
	 * @param title  
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getGoodsByTitle(
			@Param("title") String title,
			@Param("offset") Integer offset,
			@Param("count") Integer count);
	/**
	 * 获取title的记录数
	 * @param title
	 * @return
	 */
	Integer getCountByTitle(String title);
	/**
	 * 通过id获取商品信息
	 * @param id
	 * @return
	 */
	Goods getGoodsById(String id);
}






