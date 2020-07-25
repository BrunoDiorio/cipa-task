package br.com.cipa.task;

import br.com.cipa.task.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class TaskApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }
    
    @Bean
    public CommandLineRunner demo(UserService updateUsers) {
      return (args) -> updateUsers.updateUsers();
    }

}
