package fr.tao.bookservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import fr.tao.bookservice.entities.Author;
import fr.tao.bookservice.entities.Book;
import fr.tao.bookservice.repositories.AuthorRepository;
import fr.tao.bookservice.repositories.BookRepository;

@SpringBootApplication
public class BookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(BookRepository bookRepository, 
			AuthorRepository authorRepository, 
			RepositoryRestConfiguration repositoryRestConfiguration) {
		
		repositoryRestConfiguration.exposeIdsFor(Book.class);
		repositoryRestConfiguration.exposeIdsFor(Author.class);
		
		return arg -> {
			
			Author author = new Author(null, "Nigel Poulton", null);
			List<Book> books = Arrays.asList(
					new Book(null, "The Kubernetes Book", author), 
					new Book(null, "Quick Start Kubernetes", author), 
					new Book(null, "Docker Deep Dive", author)
					);
			authorRepository.save(author);
			bookRepository.saveAll(books);

			Author author2 = new Author();
			author2.setName("Mark Heckler");
			author2.addBook(new Book(null, "Spring Boot: Up and Running", null));
			author2.addBook(new Book(null, "JavaFX 9 by Example", null));
			authorRepository.save(author2);
			
			Author author3 = new Author();
			author3.setName("Kishori Sharan");
			author3.addBook(new Book(null, "Beginning Java 8 Language Features", null));
			author3.addBook(new Book(null, "Java 13 Revealed", null));
			author3.addBook(new Book(null, "Java APIs, Extensions and Libraries", null));
			authorRepository.save(author3);
			
			Author author4 = new Author();
			author4.setName("John Kocer");
			author4.addBook(new Book(null, "Angular 11, Express and Node REST API", null));
			author4.addBook(new Book(null, "ASP.NET Core 5 & Angular 11", null));
			authorRepository.save(author4);
		};
	}

}
