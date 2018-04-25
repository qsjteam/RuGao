package com.qsj.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qsj.pojo.Goods;
import com.qsj.pojo.ProductCount;
import com.qsj.service.IGoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Resource
	IGoodsService goodsService;
	
	@RequestMapping("/showGoods.do")
	public String showGoods(
			Integer categoryId,Integer page,
			Map<String,Object> map){
		
		if(page==null){
			page = 1;
		}
		
		//通过page计算偏移量
		int offset = (page-1)*ProductCount.COUNT;
		List<Goods> listGoods = goodsService.
				getGoodsByCategoryId(
				categoryId, offset, ProductCount.COUNT);
		
		Integer count = goodsService.getCount(categoryId);
		
		Integer pageSize = 
				count%ProductCount.COUNT==0?
						count/ProductCount.COUNT:
						count/ProductCount.COUNT+1;
		//设置页面的记录数
		map.put("currentPage",page);
		map.put("count",count);
		map.put("listGoods",listGoods);
		map.put("pageSize",pageSize);
		map.put("categoryId",categoryId);
		return "search";
	}

	@RequestMapping("/showGoodsByTitle.do")
	public String showGoodsByTitle(
			String title,
			Integer page,
			Map<String,Object> map){
		if(page==null){
			page = 1;
		}
		
		Integer offset = (page-1)*ProductCount.COUNT;
		List<Goods> listGoods=
				goodsService.getGoodsByTitle(
				title, offset, ProductCount.COUNT);
		Integer count = goodsService.getCountByTitle(title);
		Integer pageSize = 
				count%ProductCount.COUNT==0?
						count/ProductCount.COUNT:
						count/ProductCount.COUNT+1;
		map.put("listGoods",listGoods);
		map.put("title",title);
		map.put("pageSize",pageSize);
		map.put("count",count);
		
		return "search";
	}
	
	@RequestMapping("/showGoodsInfo.do")
	public String showGoodsInfo(String id,
			Integer categoryId,
			Map<String,Object> map){
		Goods goods = goodsService.getGoodsById(id);
		
		List<Goods> listGoods=
		goodsService.getGoodsByCategoryId(categoryId, 0, 4);
		
		map.put("goods",goods);
		map.put("listGoods", listGoods);
		
		return "product_details";
	}
	
}










