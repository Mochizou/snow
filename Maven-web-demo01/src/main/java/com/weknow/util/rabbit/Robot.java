package com.weknow.util.rabbit;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.weknow.wh.service.TargetWebServicesI;

/**
 * javaʵ������
 */
public class Robot {
	
	 private static TargetWebServicesI targetWebServicesI;
	 
    public static void main(String[] args) {
    	
		//ʹ��"spring.xml"��"spring-mybatis.xml"�����������ļ�����Spring������
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring-mybatis.xml"});
        //��Spring�����и���bean��idȡ������Ҫʹ�õ�userService����
        targetWebServicesI = (TargetWebServicesI) ac.getBean("targetWebServices");
        URL url = null;
        URLConnection urlconn = null;
        BufferedReader br = null;
        PrintWriter pw = null;
//        String regex = "http://[\\w+\\.?/?]+\\.[A-Za-z]+";
        String regex = "https://[\\w+\\.?/?]+\\.[A-Za-z]+";//urlƥ�����
        Pattern p = Pattern.compile(regex);
        try {
            url = new URL("http://36kr.com/");//��ȡ����ַ��������ȡ����һ��������վ
            urlconn = url.openConnection();
            pw = new PrintWriter(new FileWriter("D:/huxiu.txt"), true);//����ȡ�������ӷŵ�D�̵�SiteURL�ļ���
            br = new BufferedReader(new InputStreamReader(
                    urlconn.getInputStream()));
            String buf = null;
            StringBuffer sb = new StringBuffer();
            while ((buf = br.readLine()) != null) {
            	System.out.println(buf);
            	sb.append(buf);
                Matcher buf_m = p.matcher(buf);
                while (buf_m.find()) {
                    pw.println(buf_m.group());
                }
            }
            String sbs = sb.toString();
            String[] sp = sbs.split("mod-b mod-art clearfix");
            System.out.println(sp.length);
            for(int i=0 ; i <sp.length ; i++){
            	String regexp = "[\\S\\s]*<a href=\"(.*)\" class=\"transition msubstr-row2\" target=\"_blank\">(.*)</a>[\\S\\s]*";//urlƥ�����
                Pattern ps = Pattern.compile(regexp);
                Matcher buf_mp = ps.matcher(sp[i]);
                while (buf_mp.find()) {
                   // pw.println(buf_mp.group());
                	
                url = new URL("http://36kr.com/"+buf_mp.group(0));
                urlconn = url.openConnection();
                pw = new PrintWriter(new FileWriter("D:/"+buf_mp.group(2)), true);//����ȡ�������ӷŵ�D�̵�SiteURL�ļ���
                br = new BufferedReader(new InputStreamReader(
                        urlconn.getInputStream()));
                }
                while ((buf = br.readLine()) != null) {
                	pw.println(buf);
                }
            }
            System.out.println("��ȡ�ɹ�^_^");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            pw.close();
        }
    }
}
