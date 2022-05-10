package com.sports.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SportsMain {
    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext("com.sports.autowiring");
        PlayerDetails playerDetails =context.getBean(PlayerDetails.class);
        System.out.println(playerDetails.printDetails("cricket"));

        System.out.println(playerDetails.printDetails("football"));

        System.out.println(playerDetails.printDetails("kabadi"));

    }
}
