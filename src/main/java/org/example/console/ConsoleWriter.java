package org.example.console;

import org.springframework.stereotype.Component;

@Component
public class ConsoleWriter {

    public void write(String text){
        System.out.println(text);
    }
}
