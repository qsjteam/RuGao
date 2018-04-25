package com.qsj.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.qsj.pojo.CartVo;
import com.qsj.pojo.OrderItemVo;
@Transactional
public interface IOrderService {
	/**
	 * 完成订单和订单详情的插入
	 * @param userid
	 * @param listCartVo
	 */
	Integer addOrder(
			Integer userid,
			List<CartVo> listCartVo);
	/**
	 * 修改付款状态
	 * @param orderid
	 */
	void  updateStatus(Integer orderid);
	/**
	 * 查询该用户的所有订单信息
	 * @param userid
	 * @return
	 */
	List<OrderItemVo> getOrderItems(Integer userid);

}







