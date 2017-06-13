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
 * Description: �ṩ���ݴ����� 
 * Company: HUST
 * @author Sonly
 * Date: 2017��6��13��
 */
public class CalcUtil {
	
	/**
	 * Method: getDates
	 * Description: ��ȡָ��ʱ�����������
	 * @param begin ��ʼ����
	 * @param end	��������
	 * @return list	�洢��������
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
		// ʹ�ø����� Date ���ô� Calendar ��ʱ��  
		calBegin.setTime(dBegin);  
		Calendar calEnd = Calendar.getInstance();  
		// ʹ�ø����� Date ���ô� Calendar ��ʱ��  
		calEnd.setTime(dEnd);  
		// ���Դ������Ƿ���ָ������֮��  
		while (dEnd.after(calBegin.getTime()))  
		{  
			// ���������Ĺ���Ϊ�����������ֶ���ӻ��ȥָ����ʱ����  
			calBegin.add(Calendar.DAY_OF_MONTH, 1);  
			lDate.add(sdf.format(calBegin.getTime()).toString());  
		} 
		return lDate;  
	}
	
	/**
	 * Method: compute
	 * Description: ������������ƥ�����������е�����
	 * 				�����ݾ�����������ݣ�û�����***
	 * 				ͬʱ�����ݱ��浽txt�ļ���
	 * @param dates
	 * @param banks
	 * @param path
	 * @throws IOException
	 */
	public static void compute(List<String> dates, List<Bank> banks, String path) throws IOException {
		File file = new File(path);
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
		BufferedWriter writer = new BufferedWriter(outputStreamWriter);
		
		String title = "����"+"\t"; //��ͷ
		for(Bank b : banks){
			title += b.getName()+"\t";
		}
		writer.write(title);
		writer.newLine();
		
		for(String date : dates) {//������������
			String line = date+"\t";
		
			for(Bank bank : banks) {//�������й�˾
				HashMap<String, String> hashMap = bank.getStock();
				if(hashMap.containsKey(date))//�����ǰ���������ݾ������������
					line += hashMap.get(date) + "\t";
				else//�����ǰ����û�����ݾ����***
					line += "***" + "\t";
			}
			writer.write(line);
			writer.newLine();
		}
		writer.close();
	}
}
