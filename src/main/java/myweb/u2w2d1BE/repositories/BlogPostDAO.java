package myweb.u2w2d1BE.repositories;

import myweb.u2w2d1BE.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostDAO extends JpaRepository<BlogPost, Long> {
}
