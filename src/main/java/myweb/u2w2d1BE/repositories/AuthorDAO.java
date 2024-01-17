package myweb.u2w2d1BE.repositories;

import myweb.u2w2d1BE.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorDAO extends JpaRepository<Author, Long> {
//    Optional<Author> findByName(String name);
}
