package com.qsj.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qsj.pojo.Address;
import com.qsj.pojo.CartVo;
import com.qsj.pojo.OrderItemVo;
import com.qsj.service.IAddressService;
import com.qsj.service.ICartService;
import com.qsj.service.IOrderService;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController{
	@Resource
	private ICartService cartService;
	@Resource
	private IAddressService addressService;
	@Resource
	private IOrderService orderService;
	
	@RequestMapping("/showOrder.do")
	public String showOrder(
				HttpSession session,
				Integer[] ids,
				Map<String,Object> map){
		//获取商品信息的集合
		List<CartVo> listCartVo = 
				cartService.getOrderByUserid(
				this.getUid(session), ids);
		//获取地址信息的集合
		List<Address> listAddress =
				addressService.getAllAddessByUid(
						this.getUid(session));
		
		session.setAttribute("listCartVo",listCartVo);
		
		map.put("listCartVo",listCartVo);
		map.put("listAddress",listAddress);
		return "orderConfirm";
	}
	@RequestMapping("/showOrderItem.do")
	public String showOrderItem(
			HttpSession session,
			Map<String,List<OrderItemVo>> map){
		List<OrderItemVo> listItems = 
				orderService.getOrderItems(
				this.getUid(session));
		map.put("listItems",listItems);
		
		return "orders";
	}
	
	
	@RequestMapping("/payment.do")
	public String payment(HttpSession session){
		Integer userid = this.getUid(session);
		List<CartVo> listCartVo=
				(List<CartVo>)session.getAttribute("listCartVo");
		//返回Orderid
		Integer orderid = orderService.addOrder(userid, 
				listCartVo);
		
		session.setAttribute("orderid",orderid);
		return "payment";
	}
	@RequestMapping("/pay.do")
	public String pay(HttpSession session){
		Integer orderid = (Integer)session.getAttribute("orderid");
		orderService.updateStatus(orderid);
		//从session中移除Orderid和listCartVo
		session.removeAttribute("orderid");
		session.removeAttribute("listCartVo");
		return "pay_success";
	}
	
}







