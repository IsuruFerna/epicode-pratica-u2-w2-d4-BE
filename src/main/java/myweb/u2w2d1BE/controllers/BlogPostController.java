package myweb.u2w2d1BE.controllers;

import myweb.u2w2d1BE.entities.BlogPost;
import myweb.u2w2d1BE.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {
    @Autowired
    BlogPostService blogPostService;

    @GetMapping
    public List<BlogPost> getBlogPosts() {
        return blogPostService.getBlogPosts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost saveBlogPost(@RequestBody BlogPost body) {
        return blogPostService.save(body);
    }

    @GetMapping("/{id}")
    public BlogPost findById(@PathVariable Long id) {
        return blogPostService.findById(id);
    }

    @PutMapping("/{id}")
    public BlogPost findByIdAndUpdate(@PathVariable Long id, @RequestBody BlogPost body) {
        return this.blogPostService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable Long id) {
        this.blogPostService.findByIdAndDelete(id);
    }
}
