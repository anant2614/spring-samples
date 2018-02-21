package com.springaop.demo.processor;

import org.springframework.stereotype.Component;

@Component
public class PrintLoop implements PrintInterface {

    public void printLoop() {
        for (int i = 0; i < 10; i++) {
            System.out.println("times:: " + i);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
