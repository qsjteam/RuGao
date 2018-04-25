package com.qsj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qsj.dao.GoodsCategoryMapper;
import com.qsj.pojo.GoodsCategory;
@Service
public class GoodsCategoryService
		implements IGoodsCategoryService{

	@Resource
	private GoodsCategoryMapper goodsCategoryMapper ;
	/**
	 * 查询商品分类
	 */
	public List<GoodsCategory> getGoodsCategoryByParentId(Integer parentId, Integer offset, Integer count) {
		
		return goodsCategoryMapper.
				getGoodsCategoryByParentId
				(parentId, offset, count);
	}

}



