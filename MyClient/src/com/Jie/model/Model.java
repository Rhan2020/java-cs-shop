package com.Jie.model;

import com.Jie.Entity.Entity;
import com.Jie.net.Net;

public class Model {
	public static int doLogin(String username,String password){
		int flag=0;//    1表示登录收银员状态，0表示未登录
		/*
		 * 打包用户信息
		 */
		Entity e =new Entity();
		e.setFlag(flag);
		e.setUsername(username);
		e.setPassword(password);
		//执行登录
		e=Net.conn(e);
		//返回用户状态  1代表收银员 2代表仓管 3代表超级管理员  0代表不存在
		return e.getFlag();
	}

	public static String goodsFindById(String goodsid) {
		// TODO Auto-generated method stub
		int flag=4;//4表示根据ID查询商品
		Entity e =new Entity();
		e.setGoodsid(goodsid);

		e.setFlag(flag);
		e=Net.conn(e);
		return e.getGoodsid()+","+e.getGoodsname()+","+e.getGoodsprice()+","+e.getGoodscount();
	}
	
	public static boolean addGoods(Entity e){
		int flag=5;//5代表新增商品
		e.setFlag(flag);
		e=Net.conn(e);
		return e.isResult();
	}

	public static boolean delGoods(Entity e1) {
		// TODO Auto-generated method stub
		int flag=6;//6代表删除商品
		e1.setFlag(flag);
		e1=Net.conn(e1);
		return e1.isResult();
	}

	public static boolean updateGoods(Entity e1) {
		// TODO Auto-generated method stub
		int flag=7;//7代表修改商品
		e1.setFlag(flag);
		e1=Net.conn(e1);
		return e1.isResult();
	}

	public static boolean addUser(Entity e1) {
		int flag=10;//5代表新增商品
		e1.setFlag(flag);
		e1=Net.conn(e1);
		return e1.isResult();
	}

	public static boolean delUser(String username) {
		// TODO Auto-generated method stub
		Entity e1 =new Entity();
		e1.setFlag(11);
		e1.setUsername(username);
		e1=Net.conn(e1);
		return e1.isResult();
	}

	public static boolean updateUser(Entity e1) {
		// TODO Auto-generated method stub
		int flag=12;//7代表修改商品
		e1.setFlag(flag);
		e1=Net.conn(e1);
		return e1.isResult();
	}

	public static String findUser(String username) {
		// TODO Auto-generated method stub
		int flag=13;//7代表修改商品
		Entity e1 =new Entity();
		e1.setFlag(flag);
		e1.setUsername(username);
		e1=Net.conn(e1);
		return e1.getUsername()+","+e1.getPassword()+","+e1.getRole();
	}
}
