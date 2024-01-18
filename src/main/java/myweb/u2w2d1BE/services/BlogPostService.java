package myweb.u2w2d1BE.services;

import myweb.u2w2d1BE.entities.BlogPost;
import myweb.u2w2d1BE.exceptions.NotFoundException;
import myweb.u2w2d1BE.payload.blogPosts.BlogPostDTO;
import myweb.u2w2d1BE.payload.NewBlogPostPayload;
import myweb.u2w2d1BE.repositories.BlogPostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostDAO blogPostDAO;

    @Autowired
    private AuthorService authorService;

    public Page<BlogPost> getBlogPosts(int page, int size, String orderBy) {
        if(size >= 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return blogPostDAO.findAll(pageable);
    }

    public BlogPost save(BlogPostDTO body) {
        BlogPost blogPost = new BlogPost();
        blogPost.setCategory(body.category());
        blogPost.setContent(body.content());
        blogPost.setTitle(body.title());
        blogPost.setCover(body.cover());
        blogPost.setReadTime(body.readTime());

        if(body.author() != null) {
            blogPost.setAuthor(authorService.findById(body.author()));
        }

        return blogPostDAO.save(blogPost);
    }

    public BlogPost findById(Long id) {
        return blogPostDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(Long id) {
        BlogPost found = this.findById(id);
        blogPostDAO.delete(found);
    }

    public BlogPost findByIdAndUpdate(Long id, NewBlogPostPayload body) {
        BlogPost found = this.findById(id);
        found.setCategory(body.getCategory());
        found.setContent(body.getContent());
        found.setTitle(body.getTitle());
        found.setCover(body.getCover());
        found.setReadTime(body.getReadTime());

        if(body.getAuthor() != null) {
            found.setAuthor(authorService.findById(body.getAuthor()));
        }

        return blogPostDAO.save(found);
    }
}
