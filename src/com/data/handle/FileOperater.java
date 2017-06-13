package com.data.handle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileOperater {
	/**
	 * Method: readFile
	 * Description: ��ȡ�ļ����������ļ����洢��List��
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static List<Bank> readFile(String path) throws IOException {
		List<Bank> banks = new ArrayList<>();
		
		File file = new File(path);
		String[] files = file.list();//��ȡ�����ļ���
		System.out.println(files.length);
		
		for(String filename : files) {//�����ļ�
			String filePath = path + filename;
			String bankName = filename.substring(0, filename.indexOf("."));
			File file2 = new File(filePath);
			if(file2.isFile() && file2.exists()) {
				InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file2));
				BufferedReader reader = new BufferedReader(inputStreamReader);
				
				Bank bank = new Bank();
				bank.setName(bankName);
				
				HashMap<String, String> hashMap = new HashMap<>();
				String line = new String();
				while((line = reader.readLine()) != null) {//���ж�ȡ�ļ�
					line = line.trim();
					String[] lines = line.split("\t");
					if(lines.length !=2)
						System.err.println("���ݴ���"+filePath+line);
					if(hashMap.containsKey(lines[0]))
						System.err.println("�ظ����ݣ�"+filePath+line);
					
					hashMap.put(lines[0], lines[1]);//�洢��ÿ����˾�е�����
				}
				reader.close();
				bank.setStock(hashMap);
				banks.add(bank);
				
			}else {
				System.err.println("File:\""+path+"\" read failed!");
			}
		}
		return banks;	
	}

}
