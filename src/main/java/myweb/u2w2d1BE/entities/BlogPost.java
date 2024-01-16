package myweb.u2w2d1BE.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Random;
import java.util.Stack;

@ToString
@Getter
@Setter
public class BlogPost {
    private long id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private double readTime;

    public BlogPost(String category, String title, String content, double readTime) {
        Random rndm = new Random();
        this.id = rndm.nextLong(0, 2000);
        this.category = category;
        this.title = title;
        this.cover = "https://picsum.photos/200/300";
        this.content = content;
    }
}
