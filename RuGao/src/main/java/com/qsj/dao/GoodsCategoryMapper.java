package com.qsj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qsj.pojo.GoodsCategory;



public interface GoodsCategoryMapper {

	/**
	 * 通过parentId查询子分类
	 * @param parentId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<GoodsCategory> 
	getGoodsCategoryByParentId(
		@Param("parentId") Integer parentId,
		@Param("offset") Integer offset,
		@Param("count") Integer count);
}








