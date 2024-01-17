package myweb.u2w2d1BE.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Random;
import java.util.Stack;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
public class BlogPost {
    @Id
    @GeneratedValue
//    @Setter(AccessLevel.NONE)
    private long id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private int readTime;

    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;

    public BlogPost(String category, String title, String content, int readTime) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.readTime = readTime;
    }
}
