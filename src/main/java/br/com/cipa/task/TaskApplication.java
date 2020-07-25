package br.com.cipa.task;

import br.com.cipa.task.entity.Users;
import br.com.cipa.task.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class TaskApplication {

	
	private static final Logger log = LoggerFactory.getLogger(TaskApplication.class);
	
    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }
    
    @Bean
    public CommandLineRunner demo(UserRepository repository) {
      return (args) -> {
      

        // fetch all customers
        log.info("Customers found with findAll():");
        log.info("-------------------------------");
        for (Users userList : repository.findAll()) {
          log.info(userList.toString());
        }
        log.info("");

      };
    }

}
