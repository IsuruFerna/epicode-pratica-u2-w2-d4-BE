package myweb.u2w2d1BE.payload;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NewBlogPostPayload {
    private String category;
    private String title;
    private String cover;
    private String content;
    private int readTime;
    private Long author;
}
