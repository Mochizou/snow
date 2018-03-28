package com.weknow.util.rabbit;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.Random;

public class WhUtil {
	
	/**
	 * 获取资源文件
	 * 
	 * @param name
	 * @return
	 */
	public String getProperty(String name) {
		
		String path = "KeyValue.properties";
		String value = null;
		Properties properties = new Properties();
		// 加载webservice.properties文件
		InputStream in = null;
		try {
			//读取当前文件路径
			in = new FileInputStream(this.getClass().getClassLoader()
					.getResource(path).getPath());
			//资源文件载入方法
			properties.load(in);
			URL xxd = this.getClass().getClassLoader().getResource(path);
			
			//java.util健值对取值
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
	 * 生成验证码
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
