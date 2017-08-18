package com.Jie.model;

import com.Jie.Dao.Goods;
import com.Jie.Dao.GoodsDao;
import com.Jie.Dao.User;
import com.Jie.Dao.UserDao;
import com.Jie.Entity.Entity;

public class Model {

	public Entity service(Entity e) {
		// TODO Auto-generated method stub
		if(e.getFlag()==0){
			//执行登录方法
			e.setFlag(dologin(e.getUsername(), e.getPassword()));
		}
		if(e.getFlag()==4){
			//执行查询商品方法
			Goods g =new Goods();
			g= findGoodsById(e.getGoodsid());
			e.setGoodsid(g.getGoodsId());
			e.setGoodsname(g.getGoodsName());
			e.setGoodsprice(g.getGoodsPrice());
			e.setGoodscount(g.getGoodsCount());
		}
		if(e.getFlag()==5){
			//执行新增商品方法
			GoodsDao gd=new GoodsDao();
			e.setResult(gd.add(e));
		}
		if(e.getFlag()==6){
			//执行新增商品方法
			GoodsDao gd=new GoodsDao();
			e.setResult(gd.del(e));
		}
		if(e.getFlag()==7){
			//执行新增商品方法
			GoodsDao gd=new GoodsDao();
			e.setResult(gd.update(e));
		}
		if(e.getFlag()==10){
			//执行新增商品方法
			UserDao ud=new UserDao();
			
			e.setResult(ud.add(e));
		}
		if(e.getFlag()==11){
			//执行新增商品方法
			UserDao ud=new UserDao();
			
			e.setResult(ud.del(e));
		}
		if(e.getFlag()==12){
			//执行新增商品方法
			UserDao ud=new UserDao();
			
			e.setResult(ud.updateUser(e));
		}
		if(e.getFlag()==13){
			//执行新增商品方法
			UserDao ud=new UserDao();
			e=ud.findUser(e.getUsername());
		}
		

		return e;
	}

	// 处理登录方法
	private int dologin(String username, String password) {
		// TODO Auto-generated method stub
		User u = new User();
		u.setPassword(username);
		u.setUsername(username);
		UserDao ud =new UserDao();
		return ud.doLogin(u);
	}
	
	//查询商品方法
	private Goods findGoodsById(String goodsid){
		Goods g =new Goods();
		GoodsDao gd =new GoodsDao();
		g=gd.FindById(goodsid);
		return g;
	}
	
	
	
	
	
}
