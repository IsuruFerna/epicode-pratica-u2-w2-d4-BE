package myweb.u2w2d1BE.controllers;

import myweb.u2w2d1BE.entities.BlogPost;
import myweb.u2w2d1BE.payload.blogPosts.BlogPostDTO;
import myweb.u2w2d1BE.payload.NewBlogPostPayload;
import myweb.u2w2d1BE.payload.blogPosts.NewBlogPostResponseDTO;
import myweb.u2w2d1BE.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public NewBlogPostResponseDTO saveBlogPost(@RequestBody @Validated BlogPostDTO newBlogPostPayload, BindingResult validation) {
        if(validation.hasErrors()) {
            System.out.println(validation.getAllErrors());
//            throw new BadRequestException("there are errors in payload!");
        } else {
            BlogPost blogPost =  blogPostService.save(newBlogPostPayload);
            return new NewBlogPostResponseDTO(blogPost.getId());
        }

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
