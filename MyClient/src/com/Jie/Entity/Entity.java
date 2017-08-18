package com.Jie.Entity;

import java.io.Serializable;

public class Entity implements Serializable {
	private String username = "";
	private String password = "";
	private int flag = 0;
	private int role = 0;
	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	private String goodsid = "";
	private String goodsname = "";
	private String goodsprice = "";
	private String goodscount = "";
	private boolean result=false;

	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getGoodsprice() {
		return goodsprice;
	}

	public void setGoodsprice(String goodsprice) {
		this.goodsprice = goodsprice;
	}

	public String getGoodscount() {
		return goodscount;
	}

	public void setGoodscount(String goodscount) {
		this.goodscount = goodscount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

}
