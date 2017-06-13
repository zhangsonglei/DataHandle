package com.data.handle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Class: CalcUtil
 * Description: 提供数据处理方法 
 * Company: HUST
 * @author Sonly
 * Date: 2017年6月13日
 */
public class CalcUtil {
	
	/**
	 * Method: getDates
	 * Description: 获取指定时间段所有日期
	 * @param begin 开始日期
	 * @param end	结束日期
	 * @return list	存储所有日期
	 * @throws ParseException
	 */
	public static List<String> getDates(String begin, String end) throws ParseException  
	{  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		Date dBegin = sdf.parse(begin);  
		Date dEnd = sdf.parse(end);  
		
		List<String> lDate = new ArrayList<>();  
		lDate.add(begin);  
		Calendar calBegin = Calendar.getInstance();  
		// 使用给定的 Date 设置此 Calendar 的时间  
		calBegin.setTime(dBegin);  
		Calendar calEnd = Calendar.getInstance();  
		// 使用给定的 Date 设置此 Calendar 的时间  
		calEnd.setTime(dEnd);  
		// 测试此日期是否在指定日期之后  
		while (dEnd.after(calBegin.getTime()))  
		{  
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量  
			calBegin.add(Calendar.DAY_OF_MONTH, 1);  
			lDate.add(sdf.format(calBegin.getTime()).toString());  
		} 
		return lDate;  
	}
	
	/**
	 * Method: compute
	 * Description: 根据所列日期匹配所有银行中的数据
	 * 				有数据就填充已有数据，没有填充***
	 * 				同时将数据保存到txt文件中
	 * @param dates
	 * @param banks
	 * @param path
	 * @throws IOException
	 */
	public static void compute(List<String> dates, List<Bank> banks, String path) throws IOException {
		File file = new File(path);
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
		BufferedWriter writer = new BufferedWriter(outputStreamWriter);
		
		String title = "日期"+"\t"; //表头
		for(Bank b : banks){
			title += b.getName()+"\t";
		}
		writer.write(title);
		writer.newLine();
		
		for(String date : dates) {//遍历所有日期
			String line = date+"\t";
		
			for(Bank bank : banks) {//遍历所有公司
				HashMap<String, String> hashMap = bank.getStock();
				if(hashMap.containsKey(date))//如果当前日期有数据就添加已有数据
					line += hashMap.get(date) + "\t";
				else//如果当前日期没有数据就添加***
					line += "***" + "\t";
			}
			writer.write(line);
			writer.newLine();
		}
		writer.close();
	}
}
