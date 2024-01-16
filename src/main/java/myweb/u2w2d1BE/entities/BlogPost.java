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
    private int readTime;

    public BlogPost(String category, String title, String content, int readTime) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.readTime = readTime;
    }
}
