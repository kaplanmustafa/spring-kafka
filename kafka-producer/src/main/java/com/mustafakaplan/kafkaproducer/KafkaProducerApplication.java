package com.mustafakaplan.kafkaproducer;

import com.mustafakaplan.kafkaproducer.service.ProducerService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApplication implements ApplicationRunner {

    private final ProducerService producerService;

    public KafkaProducerApplication(ProducerService producerService) {
        this.producerService = producerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("Kafka log send starting...");

        for (int i = 0; i < 10; i++) {
            producerService.sendMessage(String.format("[%d] -- Hello World", i));
        }

        System.out.println("Kafka log sent...");
    }
}
