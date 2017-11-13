package com.knight.impl;

import com.knight.entity.Person;
import com.knight.entity.User;
import com.knight.service.ConService;
import com.knight.service.ProService;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Service
@Path("con")
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML,MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML,MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_XML})
public class ConApply implements ConService {

    @Resource
    private ProService proService;

    @POST
    @Path("user")
    @Override
    public Person getPerson(User user) {
        Person p = new Person();
        p.setName("haha");
        p.setSex("boy");
        p.setHomeAdd("test");
        User u = proService.getUser(p);
        System.out.println("接收到的User是：" + u);
        System.out.println("传出去的Person是：" + p);

        return p;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" });
        context.start();

        ProService proService = (ProService) context.getBean("demoService");
        Person p = new Person();
        p.setName("haha");
        p.setSex("boy");
        p.setHomeAdd("test");
        User u = proService.getUser(p);
        System.out.println(u);


    }
}
