package com.data.handle;

import java.util.HashMap;

/**
 * Class: Bank
 * Description: �洢��˾��Ϣ��������˾���͹�Ʊ�� 
 * Company: HUST
 * @author Sonly
 * Date: 2017��6��13��
 */
public class Bank {
	private String name;	//��˾��
	private HashMap<String, String> stock;	//��Ʊ
	
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
