package com.example.simulatedeviceproducer.ignore;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class TestSchedule {

    //@Scheduled(fixedDelay = 5000)
    public void print(){
        System.out.println("Current time: " + new Timestamp(System.currentTimeMillis()).getTime());
    }

}
