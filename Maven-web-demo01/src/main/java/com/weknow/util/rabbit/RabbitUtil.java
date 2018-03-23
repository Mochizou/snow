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

public class RabbitUtil {
	
	public void creatHtml(String url,String fileUrl) throws IOException{
		
		URL webUrl = new URL(url);
		URLConnection connUrl = webUrl.openConnection();
		PrintWriter pw = new PrintWriter(new FileWriter(fileUrl));
		BufferedReader br = new BufferedReader(new InputStreamReader(connUrl.getInputStream()));
		String buf = null;
		while((buf = br.readLine()) != null){
			pw.println(buf);
		}
	}
	
	public void getUrl(String url,String fileUrl) throws IOException{
		String regex = "https://[\\w+\\.?/?]+\\.[A-Za-z]+";
		String regexHref = "<a href=\"/article/236179.html\">";
		URL webUrl = new URL(url);
		URLConnection connUrl = webUrl.openConnection();
		PrintWriter pw = new PrintWriter(new FileWriter(fileUrl));
		BufferedReader br = new BufferedReader(new InputStreamReader(connUrl.getInputStream()));
		String buf = null;
		 Pattern p = Pattern.compile(regex);
		 Pattern ph = Pattern.compile(regexHref);
		while((buf = br.readLine()) != null){
			Matcher buf_m = p.matcher(buf);
			while (buf_m.find()) {
                pw.println(buf_m.group());
            }
		}
	}
	
	

}
