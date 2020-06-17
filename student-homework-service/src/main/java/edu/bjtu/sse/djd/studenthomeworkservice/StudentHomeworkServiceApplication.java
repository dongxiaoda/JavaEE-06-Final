package edu.bjtu.sse.djd.studenthomeworkservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 董金达
 */

@EnableDiscoveryClient
@SpringBootApplication
public class StudentHomeworkServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentHomeworkServiceApplication.class, args);
    }

}
