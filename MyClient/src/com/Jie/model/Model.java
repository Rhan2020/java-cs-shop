package com.Jie.model;

import com.Jie.Entity.Entity;
import com.Jie.net.Net;

public class Model {
	public static int doLogin(String username,String password){
		int flag=0;//    1��ʾ��¼����Ա״̬��0��ʾδ��¼
		/*
		 * ����û���Ϣ
		 */
		Entity e =new Entity();
		e.setFlag(flag);
		e.setUsername(username);
		e.setPassword(password);
		//ִ�е�¼
		e=Net.conn(e);
		//�����û�״̬  1��������Ա 2�����ֹ� 3������������Ա  0����������
		return e.getFlag();
	}

	public static String goodsFindById(String goodsid) {
		// TODO Auto-generated method stub
		int flag=4;//4表示根据ID查询商品
		Entity e =new Entity();
		e.setGoodsid(goodsid);

		e.setFlag(flag);
		e=Net.conn(e);
		
		// 检查商品是否找到
		if (e.getGoodsid() == null || e.getGoodsname() == null) {
			return null; // 商品不存在
		}
		
		return e.getGoodsid()+","+e.getGoodsname()+","+e.getGoodsprice()+","+e.getGoodscount();
	}
	
	public static boolean addGoods(Entity e){
		int flag=5;//5����������Ʒ
		e.setFlag(flag);
		e=Net.conn(e);
		return e.isResult();
	}

	public static boolean delGoods(Entity e1) {
		// TODO Auto-generated method stub
		int flag=6;//6����ɾ����Ʒ
		e1.setFlag(flag);
		e1=Net.conn(e1);
		return e1.isResult();
	}

	public static boolean updateGoods(Entity e1) {
		// TODO Auto-generated method stub
		int flag=7;//7�����޸���Ʒ
		e1.setFlag(flag);
		e1=Net.conn(e1);
		return e1.isResult();
	}

	public static boolean addUser(Entity e1) {
		int flag=10;//5����������Ʒ
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
		int flag=12;//7�����޸���Ʒ
		e1.setFlag(flag);
		e1=Net.conn(e1);
		return e1.isResult();
	}

	public static String findUser(String username) {
		// TODO Auto-generated method stub
		int flag=13;//13表示查询用户
		Entity e1 =new Entity();
		e1.setFlag(flag);
		e1.setUsername(username);
		e1=Net.conn(e1);
		
		// 检查用户是否找到
		if (e1 == null || e1.getUsername() == null) {
			return null; // 用户不存在
		}
		
		return e1.getUsername()+","+e1.getPassword()+","+e1.getRole();
	}
}
