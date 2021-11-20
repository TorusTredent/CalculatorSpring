package org.example.config;

import org.example.entity.Operation;
import org.example.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

@Configuration
@ComponentScan("org.example")
public class RootConfiguration {

    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }

    @Bean
    public ArrayList<User> userList() {
        return new ArrayList<>();
    }

    @Bean
    public LinkedList<Operation> operationList() {
        return new LinkedList<>();
    }

}
