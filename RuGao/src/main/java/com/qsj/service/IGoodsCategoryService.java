package com.qsj.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.qsj.pojo.GoodsCategory;
@Transactional
public interface IGoodsCategoryService {
	/**
	 * 查询商品分类
	 * @param parentId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<GoodsCategory> 
	getGoodsCategoryByParentId(Integer parentId,
			Integer offset,Integer count);

}





