package com.javatpoint.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "sample.queue")
    public void consume(String message) {
        System.out.println(" Some Error occured: " + message);
    }
}
