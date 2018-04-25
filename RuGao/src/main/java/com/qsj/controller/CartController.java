package com.qsj.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qsj.pojo.Cart;
import com.qsj.pojo.CartVo;
import com.qsj.pojo.ResponseResult;
import com.qsj.service.ICartService;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController{
	@Resource
	private ICartService cartService;
	/**
	 * 显示cart.jsp页面
	 * @return
	 */
	@RequestMapping("/showCart.do")
	public String showCart(HttpSession session,
			Map<String,Object> map){
		List<CartVo> list = cartService.getAll(
				this.getUid(session));
		map.put("listCartVo",list);
		return "cart";
	}
	
	@RequestMapping("/addCart.do")
	@ResponseBody
	public ResponseResult<Void> addCart(
			String goodsid,HttpSession session,
			int count){
		System.out.println("goodsid"+goodsid);
		Cart cart =  new Cart();
		cart.setGoodsid(goodsid);
		cart.setUserid(this.getUid(session));
		cart.setCount(count);
		
		cartService.addCart(cart);
		ResponseResult<Void> rr = 
				new ResponseResult<Void>(1,"添加成功");
		return rr;
	}
	@RequestMapping("/deleteById.do")
	public String deleteById(Integer id){
		
		cartService.deleteByCartId(id);
		
		return "redirect:../cart/showCart.do";
	}
	@RequestMapping("/deleteByBatch.do")
	public String deleteByBatch(Integer[] ids){
		
		cartService.deleteByBatch(ids);
		return "redirect:../cart/showCart.do";
	}
	@RequestMapping("/updateCountById.do")
	@ResponseBody
	public ResponseResult<Void> updateCountById(
			Integer id,Integer count){
		ResponseResult<Void> rr =
				new ResponseResult<Void>(1,"修改成功");
		cartService.updateById(id, count);
		
		return rr;
	}
}







