package myweb.u2w2d1BE.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Random;
import java.util.Stack;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlogPost {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private long id;
    private String category;
    private String title;
    private String cover;
    @Lob
    private String content;
    private int readTime;

//    @NonNull
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;

    public BlogPost(String category, String title, String content, int readTime) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.readTime = readTime;
    }

    public BlogPost(String category, String title, String content, int readTime, Author author) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.readTime = readTime;
        this.author = author;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BlogPost{");
        sb.append("id=").append(id);
        sb.append(", category='").append(category).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", cover='").append(cover).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", readTime=").append(readTime);
        sb.append(", author=").append(author);
        sb.append('}');
        return sb.toString();
    }
}
