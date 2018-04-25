package com.qsj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qsj.dao.GoodsMapper;
import com.qsj.pojo.Goods;
@Service
public class GoodsService implements IGoodsService {

	@Resource
	private GoodsMapper goodsMapper;
	
	public List<Goods> getGoodsByCategoryId(Integer categoryId, Integer offset, Integer count) {
		
		return goodsMapper.getGoodsByCategoryId(categoryId, offset, count);
	}
	/**
	 * 获取指定分类的记录数
	 */
	public Integer getCount(Integer categoryId){
		return goodsMapper.getCount(categoryId);
	}
	public List<Goods> getGoodsByTitle(
			String title,
			Integer offset,
			Integer count){
		return goodsMapper.getGoodsByTitle(title, offset, count);
	}
	/**
	 * 获取记录数
	 */
	public Integer getCountByTitle(String title){
		return goodsMapper.getCountByTitle(title);
	}
	/**
	 * 通过获取商品信息
	 */
	public Goods getGoodsById(String id){
		return goodsMapper.getGoodsById(id);
	}
}








