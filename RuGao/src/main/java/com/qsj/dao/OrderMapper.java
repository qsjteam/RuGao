package com.qsj.dao;

import java.util.List;

import com.qsj.pojo.Order;
import com.qsj.pojo.OrderItem;
import com.qsj.pojo.OrderItemVo;

public interface OrderMapper {
	/**
	 * 在订单表中插入数据
	 * @param order
	 */
	void insetOrder(Order order);
	/**
	 * 在订单详情表中插入数据
	 * @param orderItem
	 */
	void insertOrderItem(OrderItem orderItem);
	/**
	 * 修改付款状态
	 * @param orderid
	 */
	void updateStatus(Integer orderid);
	/**
	 * 查询该用户的所有订单
	 * @param userid
	 * @return
	 */
	List<OrderItemVo> getOrderItems(
			Integer userid);
}






