package fr.tao.bookservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.tao.bookservice.entities.Book;

@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book, Long> {

}
