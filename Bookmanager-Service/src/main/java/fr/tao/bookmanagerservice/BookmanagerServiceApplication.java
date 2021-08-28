package fr.tao.bookmanagerservice;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import fr.tao.bookmanagerservice.entities.Bookmanager;
import fr.tao.bookmanagerservice.repositories.BookmanagerRepository;

@SpringBootApplication
public class BookmanagerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmanagerServiceApplication.class, args);
	}
	
	@Bean
    CommandLineRunner lineRunner(BookmanagerRepository bookmanagerRepository, 
    		RepositoryRestConfiguration repositoryRestConfiguration){		
		repositoryRestConfiguration.exposeIdsFor(Bookmanager.class);		
		return args -> 
			Stream.of("Ali Malak", "François Lecompte", "Flora Nadal").forEach(bm ->
				bookmanagerRepository.save(new Bookmanager(null, bm, bm.replace(' ', '.') + "@bookmanager.com"))
			);
    }

}
