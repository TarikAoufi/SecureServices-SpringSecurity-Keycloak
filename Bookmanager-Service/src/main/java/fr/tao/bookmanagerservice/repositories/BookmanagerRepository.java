package fr.tao.bookmanagerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.tao.bookmanagerservice.entities.Bookmanager;

@RepositoryRestResource
public interface BookmanagerRepository extends JpaRepository<Bookmanager, Long> {

}
