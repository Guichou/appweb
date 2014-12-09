package fr.ensisa.guicharrousse;

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

					
						
						taskRepository.save(new Task(
								"tache 1", false));
						taskRepository.save(new Task(
								"tache 2", false));
					
				}
			};
	
		return c;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
