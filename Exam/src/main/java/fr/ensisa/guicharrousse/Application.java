package fr.ensisa.guicharrousse;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

	@Bean
	CommandLineRunner init(final TaskRepository taskRepository) {
		CommandLineRunner c = new CommandLineRunner() {
			
			@Override
			public void run(String... string) throws Exception {

				Task t1 = 
						taskRepository.save(new Task("tache 1", false));
				Task t2 =
						taskRepository.save(new Task("tache 2", false));
				System.out.println(t1.getTitle() +" : "+ t1.getId());
				System.out.println(t2.getTitle() +" : "+ t2.getId());
					
				}
			};
	
		return c;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
