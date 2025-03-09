package edu.seu.todo_list_service_springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("edu.seu.todo_list_service_springboot.mapper")
public class TodoListServiceSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoListServiceSpringbootApplication.class, args);
    }

}
