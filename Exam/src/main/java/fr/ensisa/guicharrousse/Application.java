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
	CommandLineRunner init(final AccountRepository accountRepository,
			final TaskRepository taskRepository) {
		CommandLineRunner c = new CommandLineRunner() {
			
			@Override
			public void run(String... string) throws Exception {

					String[] strings = {"jhoeller","dsyer","pwebb","ogierke","rwinch","mfisher","mpollack","jlong"};
					for(String a : strings)
					{
						Account account = accountRepository.save(new Account(a,
								"password"));
						taskRepository.save(new Task(account,
								"tache 1", false));
						taskRepository.save(new Task(account,
								"tache 2", false));
					}
				}
			};
	
		return c;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
