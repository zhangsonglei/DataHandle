package com.data.handle;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Class: HandleData
 * Description: ִ�г��������� 
 * Company: HUST
 * @author Sonly
 * Date: 2017��6��13��
 */
public class HandleData {
	
	/**
	 * Method: main
	 * Description: �������
	 * @param args
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws IOException, ParseException{
		String filePath = "File\\banks\\";//���ݴ��·��
		String reString = "File\\res.txt";//�������ļ�
		List<String> dates = CalcUtil.getDates("2005-01-04", "2017-06-09");//��ȡĳʱ�������
		List<Bank> banks = FileOperater.readFile(filePath);//��ȡ���й�˾����
		
		CalcUtil.compute(dates, banks, reString);//��������
	}
}
