package com.javahelps.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javahelps.persistance.PersistanceSingleton;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	PersistanceSingleton singleton = PersistanceSingleton.getInstance();
		singleton.setPersistance(args[0]);
        SpringApplication.run(Application.class, args);
    }
}