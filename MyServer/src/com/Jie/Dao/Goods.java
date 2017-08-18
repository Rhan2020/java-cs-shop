package com.Jie.Dao;

public class Goods {
	private String GoodsId;
	private String GoodsName;
	private String GoodsPrice;
	private String GoodsCount;
	private boolean result=false;
	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getGoodsId() {
		return GoodsId;
	}

	public void setGoodsId(String goodsId) {
		GoodsId = goodsId;
	}

	public String getGoodsName() {
		return GoodsName;
	}

	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}

	public String getGoodsPrice() {
		return GoodsPrice;
	}

	public void setGoodsPrice(String goodsPrice) {
		GoodsPrice = goodsPrice;
	}

	public String getGoodsCount() {
		return GoodsCount;
	}

	public void setGoodsCount(String goodsCount) {
		GoodsCount = goodsCount;
	}

}
