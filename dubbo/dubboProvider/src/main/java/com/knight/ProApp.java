package com.knight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:dubbo-pro.xml"})
public class ProApp {
    private static volatile boolean running = true;
    public static void main(String[] args) {

        //SpringApplication.run(TestApplication.class,args);

        ApplicationContext context = SpringApplication.run(ProApp.class, args);
        System.out.println("启动成功");
        synchronized (ProApp.class) {
            while (running) {
                try {
                    ProApp.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    SpringApplication.exit(context);
                }
            }
        }
    }
}
