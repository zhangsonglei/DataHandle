package com.data.handle;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Class: HandleData
 * Description: 执行程序处理数据 
 * Company: HUST
 * @author Sonly
 * Date: 2017年6月13日
 */
public class HandleData {
	
	/**
	 * Method: main
	 * Description: 程序入口
	 * @param args
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws IOException, ParseException{
		String filePath = "File\\banks\\";//数据存放路径
		String reString = "File\\res.txt";//处理结果文件
		List<String> dates = CalcUtil.getDates("2005-01-04", "2017-06-09");//获取某时间段日期
		List<Bank> banks = FileOperater.readFile(filePath);//获取所有公司数据
		
		CalcUtil.compute(dates, banks, reString);//处理数据
	}
}
