package com.data.handle;

import java.util.HashMap;

/**
 * Class: Bank
 * Description: 存储公司信息（包括公司名和股票） 
 * Company: HUST
 * @author Sonly
 * Date: 2017年6月13日
 */
public class Bank {
	private String name;	//公司名
	private HashMap<String, String> stock;	//股票
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, String> getStock() {
		return stock;
	}
	public void setStock(HashMap<String, String> stock) {
		this.stock = stock;
	}
	
}
