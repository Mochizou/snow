package com.weknow.util.rabbit;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.weknow.wh.model.TargetWeb;
import com.weknow.wh.service.TargetWebServicesI;

public class wkUnit {
	
private TargetWebServicesI userService;
    
    /**
     * ���before���������еĲ��Է���֮ǰִ�У�����ִֻ��һ��
     * ������Junit��Ԫ����ʱһЩ��ʼ��������������������������
     * ������before���������ʼ��ApplicationContext��userService
     */
    @Before
    public void before(){
        //ʹ��"spring.xml"��"spring-mybatis.xml"�����������ļ�����Spring������
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring-mybatis.xml"});
        //��Spring�����и���bean��idȡ������Ҫʹ�õ�userService����
        userService = (TargetWebServicesI) ac.getBean("targetWebServices");
    }
    
    @Test
    public void testAddUser(){
        //ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
        //UserServiceI userService = (UserServiceI) ac.getBean("userService");
    	TargetWeb user = new TargetWeb();
        user.setTarid(UUID.randomUUID().toString().replaceAll("-", ""));
        user.setTarname("xxxxxx");
       // user.setUserBirthday(new Date());
        //user.setUserSalary(10000D);
        userService.insert(user);
    }

}
