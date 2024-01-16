package myweb.u2w2d1BE.services;

import myweb.u2w2d1BE.entities.BlogPost;
import myweb.u2w2d1BE.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {
    private List<BlogPost> blogPosts = new ArrayList<>();

    public List<BlogPost> getBlogPosts() {
        return this.blogPosts;
    }

    public BlogPost save(BlogPost body) {
        Random rndm = new Random();
        body.setId(rndm.nextLong(0, 2000));
        body.setCover("https://picsum.photos/200/300");
        this.blogPosts.add(body);
        return body;
    }

    public BlogPost findById(Long id) {
        BlogPost found = null;
        for(BlogPost post: this.blogPosts) {
            if(post.getId() == id) {
                found = post;
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;

    }

    public void findByIdAndDelete(Long id) {
        Iterator<BlogPost> blogPostIterator = this.blogPosts.iterator();
        while (blogPostIterator.hasNext()) {
            BlogPost current = blogPostIterator.next();
            if(current.getId() == id) {
                blogPostIterator.remove();
            }
        }
    }

    public BlogPost findByIdAndUpdate(Long id, BlogPost body) {
        BlogPost found = null;
        for (BlogPost post: this.blogPosts) {
            if(post.getId() == id) {
                found = post;
                found.setId(id);
                found.setCategory(body.getCategory());
                found.setTitle(body.getTitle());
                found.setCover(body.getCover());
                found.setReadTime(body.getReadTime());
                found.setContent(body.getContent());
            }
        }
        if(found == null)
            throw new NotFoundException(id);
        return found;
    }
}
