package myweb.u2w2d1BE.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Random;
import java.util.Stack;

@Entity
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

    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;

    public BlogPost(String category, String title, String content, int readTime) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.readTime = readTime;
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
