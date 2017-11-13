package com.knight.impl;

import com.knight.entity.Person;
import com.knight.entity.User;
import com.knight.service.ProService;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Service
@Path("pro")
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML,MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML,MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_XML})

public class ProApply implements ProService {
    @POST
    @Path("person")
    @Override
    public User getUser(Person person) {
        User user=new User();
        user.setId("1001");
        user.setName("xbz");
        user.setAge("10");
        System.out.println("接收到的person是：" + person);
        System.out.println("传出去的User是：" + user);
        return user;
    }
}
