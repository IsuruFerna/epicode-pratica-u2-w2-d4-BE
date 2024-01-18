package myweb.u2w2d1BE.controllers;

import myweb.u2w2d1BE.entities.Author;
import myweb.u2w2d1BE.exceptions.BadRequestExeption;
import myweb.u2w2d1BE.payload.users.NewAuthorDTO;
import myweb.u2w2d1BE.payload.users.NewAuthorResponseDTO;
import myweb.u2w2d1BE.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public NewAuthorResponseDTO saveBlogPost(@RequestBody @Validated NewAuthorDTO authorPayload, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestExeption("There are erros in payload!");
        } else  {

            Author author = new Author();
            author.setAvatar(authorPayload.avatar());
            author.setEmail(authorPayload.avatar());
            author.setLastName(authorPayload.lastName());
            author.setFirstName(authorPayload.firstName());
            author.setBirthDay(authorPayload.birthDay());
            authorService.save(author);
            return new NewAuthorResponseDTO(author.getId());
        }
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
