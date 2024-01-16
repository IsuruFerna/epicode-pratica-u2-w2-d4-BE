package myweb.u2w2d1BE.controllers;

import myweb.u2w2d1BE.entities.Author;
import myweb.u2w2d1BE.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorContoller {
    @Autowired
    AuthorService authorService;

    @GetMapping
    public List<Author> getBlogPosts() {
        return authorService.getBlogPosts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveBlogPost(@RequestBody Author body) {
        return authorService.save(body);
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable Long id) {
        return authorService.findById(id);
    }

    @PutMapping("/{id}")
    public Author findByIdAndUpdate(@PathVariable Long id, @RequestBody Author body) {
        return this.authorService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable Long id) {
        this.authorService.findByIdAndDelete(id);
    }
}
