package com.qsj.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qsj.pojo.Goods;
import com.qsj.pojo.GoodsCategory;
import com.qsj.service.IGoodsCategoryService;
import com.qsj.service.IGoodsService;

@Controller
@RequestMapping("/main")
public class MainController {
	@Resource
	IGoodsCategoryService goodsCategoryService;
	@Resource
	private IGoodsService goodsService;
	
	@RequestMapping("/showIndex.do")
	public String showIndex(Map<String,Object> map){
		
		List<GoodsCategory> list1=
				goodsCategoryService.
					getGoodsCategoryByParentId(161,0, 3);
		
		List<List<GoodsCategory>> list2 =  
				new ArrayList<List<GoodsCategory>>();
		
		for(GoodsCategory c: list1){
			list2.add(goodsCategoryService.
			getGoodsCategoryByParentId(
					c.getId(),null,null));
		}
		
		List<Goods> listGoods = goodsService.getGoodsByCategoryId(163,0,3);
		//把页面需要的数据集合,设置到map对象中
		map.put("list1",list1);
		map.put("list2",list2);
		map.put("listGoods",listGoods);
		return "index";
		
		
	}

}





