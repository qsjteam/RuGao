package com.qsj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qsj.dao.OrderMapper;
import com.qsj.pojo.CartVo;
import com.qsj.pojo.Order;
import com.qsj.pojo.OrderItem;
import com.qsj.pojo.OrderItemVo;
@Service
public class OrderService implements 
	IOrderService{
	@Resource
	private OrderMapper orderMapper;
	
	/**
	 * 插入订单和订单详情的数据
	 */
	public Integer addOrder(Integer userid, 
			List<CartVo> listCartVo) {
		Order order = new Order();
		order.setUserid(userid);
		orderMapper.insetOrder(order);
		
		for(CartVo cartVo:listCartVo){
			OrderItem orderItem = new OrderItem();
			orderItem.setGoodsid(cartVo.getGoodsid());
			orderItem.setUserid(userid);
			orderItem.setImage(cartVo.getImage());
			orderItem.setTitle(cartVo.getTitle());
			orderItem.setCount(cartVo.getCount());
			orderItem.setPrice(cartVo.getPrice());
			orderItem.setOrderid(order.getId());
			orderMapper.insertOrderItem(orderItem);
		}
		return order.getId();
		
	}

	/**
	 * 修改付款状态
	 */
	public void updateStatus(Integer orderid) {
		orderMapper.updateStatus(orderid);
		
	}
	
	public List<OrderItemVo> getOrderItems(Integer userid) {
		//返回该用户的所有订单信息
		return orderMapper.getOrderItems(userid);
	}

}




