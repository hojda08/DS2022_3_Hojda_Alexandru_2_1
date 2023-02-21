package com.example.simulatedeviceproducer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;

@Component
public class EnergyDataPublisher {

    @Autowired
    private RabbitTemplate template;

    @PostConstruct
    public void publishEnergyData(){

        EnergyData energyData = new EnergyData();

        System.out.println(System.getProperty("server.port") + "serverport");

        try{

            //File file = new File("C:\\Users\\XGA\\Desktop\\simulatedeviceproducer\\deviceID.txt");
            File file = new File("deviceID.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            energyData.setDeviceId(bufferedReader.readLine());

            //file = new File("C:\\Users\\XGA\\Desktop\\simulatedeviceproducer\\sensor.csv");
            file = new File("sensor.csv");
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String value = "";

            while((value = bufferedReader.readLine()) != null){

                energyData.setMeasurementValue(value);
                energyData.setTimestamp(new Timestamp(System.currentTimeMillis()).getTime());

                template.convertAndSend(MQConfig.EXCHANGE,MQConfig.ROUTING_KEY,energyData);

                Thread.sleep(5000);
            }

        }
        catch (IOException | InterruptedException e){
            e.printStackTrace();
        }

    }

}
