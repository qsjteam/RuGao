package com.qsj.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qsj.dao.CartMapper;
import com.qsj.pojo.Cart;
import com.qsj.pojo.CartVo;
@Service
public class CartService implements ICartService{
	@Resource
	private CartMapper cartMapper;
	public void addCart(Cart cart) {
		List<Cart> listCart = 
				cartMapper.getCartByUserid(
				cart.getUserid());
		for(Cart c : listCart){
			if(c.getGoodsid().equals(
					cart.getGoodsid())){
				Integer quantity = cart.getCount()+
						c.getCount();
				cart.setCount(quantity);
				cartMapper.update(cart);
				return ;
			}
		}
		cartMapper.insert(cart);
		
	}
	/**
	 * 获取商品信息
	 */
	public List<CartVo> getAll(Integer id){
		return cartMapper.selectAll(id);
	}
	/**
	 * 删除购物车中的商品信息
	 */
	public void deleteByCartId(Integer id) {
		cartMapper.deleteByCartId(id);
		
	}
	/**
	 * 批量删除数据
	 */
	public void deleteByBatch(Integer[] ids){
		cartMapper.deleteByBatch(ids);
	}
	/**
	 * 通过id修改商品的数量
	 */
	public void updateById(Integer id, Integer count) {
		cartMapper.updateById(id, count);
		
	}
	/**
	 * 返回购买商品的集合
	 */
	public List<CartVo> getOrderByUserid(
			Integer userid,Integer[] ids){
		//选中的商品的集合
		List<CartVo> newList = 
				new ArrayList<CartVo>();
		//返回购物车的所有商品信息
		List<CartVo> list = 
				cartMapper.selectAll(userid);
		for(CartVo cartVo:list){
			for(Integer id:ids){
				if(cartVo.getId()==id){
					newList.add(cartVo);
					break;
				}
			}
		}
		return newList;
	}

}






