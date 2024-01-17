package myweb.u2w2d1BE.controllers;

import myweb.u2w2d1BE.entities.BlogPost;
import myweb.u2w2d1BE.payload.NewBlogPostPayload;
import myweb.u2w2d1BE.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {
    @Autowired
    BlogPostService blogPostService;

    @GetMapping
    public Page<BlogPost> getBlogPosts(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size,
                                       @RequestParam(defaultValue = "id") String orderBy) {
        return blogPostService.getBlogPosts(page, size, orderBy);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost saveBlogPost(@RequestBody NewBlogPostPayload body) {
        return blogPostService.save(body);
    }

    @GetMapping("/{id}")
    public BlogPost findById(@PathVariable Long id) {
        return blogPostService.findById(id);
    }

    @PutMapping("/{id}")
    public BlogPost findByIdAndUpdate(@PathVariable Long id, @RequestBody NewBlogPostPayload body) {
        return this.blogPostService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable Long id) {
        this.blogPostService.findByIdAndDelete(id);
    }
}
