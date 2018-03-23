package com.weknow.util.rabbit;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.weknow.wh.model.TargetWeb;
import com.weknow.wh.service.TargetWebServicesI;
import com.weknow.wh.service.Impl.TargetWebServicesImpl;

public class ScheTime {
	
	 private static TargetWebServicesI targetWebServicesI;
	
	public static void main(String[] args) {
		//使用"spring.xml"和"spring-mybatis.xml"这两个配置文件创建Spring上下文
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring-mybatis.xml"});
        //从Spring容器中根据bean的id取出我们要使用的userService对象
        targetWebServicesI = (TargetWebServicesI) ac.getBean("targetWebServices");
		//TargetWebServicesI dao = new TargetWebServicesImpl();
        for (int i = 0; i < 10; ++i) {
            new Timer("timer - " + i).schedule(new TimerTask() {
                public void run() {
                    //println(Thread.currentThread().getName() + " run ");
                	TargetWeb record = new TargetWeb();
                	RabbitUtil  ru = new RabbitUtil();
                	String url = "https://www.huxiu.com";
					String fileUrl="/weknow/html/huxiu.html";
					try {
						ru.creatHtml(url, fileUrl);
						record.setTarurl(url);
						record.setTarname(fileUrl);
						targetWebServicesI.insert(record );
						System.out.println("http://36kr.com/newsflashes");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
                }
            }, new Date(System.currentTimeMillis() + 5000));
        }
    }

}
