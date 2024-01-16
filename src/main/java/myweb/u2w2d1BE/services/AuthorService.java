package myweb.u2w2d1BE.services;

import myweb.u2w2d1BE.entities.Author;
import myweb.u2w2d1BE.entities.BlogPost;
import myweb.u2w2d1BE.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {
    private List<Author> authors = new ArrayList<>();

    public List<Author> getBlogPosts() {
        return this.authors;
    }

    public Author save(Author body) {
        Random rndm = new Random();
        body.setId(rndm.nextLong(0, 2000));
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getFirstName() + body.getLastName());
        this.authors.add(body);
        return body;
    }

    public Author findById(Long id) {
        Author found = null;
        for(Author author: this.authors) {
            if(author.getId() == id) {
                found = author;
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;

    }

    public void findByIdAndDelete(Long id) {
        Iterator<Author> iterator = this.authors.iterator();
        while (iterator.hasNext()) {
            Author current = iterator.next();
            if(current.getId() == id) {
                iterator.remove();
            }
        }
    }

    public Author findByIdAndUpdate(Long id, Author body) {
        Author found = null;
        for (Author post: this.authors) {
            if(post.getId() == id) {
                found = post;
                found.setId(id);
                found.setEmail(body.getEmail());
                found.setBirthDay(body.getBirthDay());
                found.setFirstName(body.getFirstName());
                found.setLastName(body.getLastName());
            }
        }
        if(found == null)
            throw new NotFoundException(id);
        return found;
    }
}
