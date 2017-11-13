package com.knight;

import com.knight.service.ProService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;


@ImportResource(locations = {"classpath:dubbo-con.xml"})
@SpringBootApplication
public class ConApp {
    private static volatile boolean running = true;
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(ConApp.class, args);
        System.out.println("启动成功");
        synchronized (ConApp.class) {
            while (running) {
                try {
                    ConApp.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    SpringApplication.exit(context);
                }
            }
        }
    }

}
