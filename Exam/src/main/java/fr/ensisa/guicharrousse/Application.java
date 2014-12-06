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
			final BookmarkRepository bookmarkRepository) {
		CommandLineRunner c = new CommandLineRunner() {
			
			@Override
			public void run(String... string) throws Exception {

					String[] strings = {"jhoeller","dsyer","pwebb","ogierke","rwinch","mfisher","mpollack","jlong"};
					for(String a : strings)
					{
						Account account = accountRepository.save(new Account(a,
								"password"));
						bookmarkRepository.save(new Bookmark(account,
								"http://bookmark.com/1/" + a, "A description"));
						bookmarkRepository.save(new Bookmark(account,
								"http://bookmark.com/2/" + a, "A description"));
					}
				}
			};
	
		return c;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
