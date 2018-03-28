package com.weknow.util.rabbit;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.Random;

public class WhUtil {
	
	/**
	 * ��ȡ��Դ�ļ�
	 * 
	 * @param name
	 * @return
	 */
	public String getProperty(String name) {
		
		String path = "KeyValue.properties";
		String value = null;
		Properties properties = new Properties();
		// ����webservice.properties�ļ�
		InputStream in = null;
		try {
			//��ȡ��ǰ�ļ�·��
			in = new FileInputStream(this.getClass().getClassLoader()
					.getResource(path).getPath());
			//��Դ�ļ����뷽��
			properties.load(in);
			URL xxd = this.getClass().getClassLoader().getResource(path);
			
			//java.util��ֵ��ȡֵ
			value = properties.getProperty(name);
			
		} catch (IOException e) {
			e.printStackTrace();
			return value;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return value;
	}
	
	/**
	 * ������֤��
	 * @return
	 */
	public String makeVerify(){
		String ve = "";
		Random random = new Random();
		//abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890
		//String verAll = getProperty("mailverify");
		String verAll = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for(int i = 0 ;i < 5 ;i++){
		ve =ve +String.valueOf(verAll.charAt(random.nextInt(62)));
		}
		return ve;
	}

}
