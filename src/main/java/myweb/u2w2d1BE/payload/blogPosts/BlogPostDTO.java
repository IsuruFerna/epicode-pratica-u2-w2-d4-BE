package myweb.u2w2d1BE.payload.blogPosts;


import jakarta.validation.constraints.NotEmpty;

public record BlogPostDTO(
        @NotEmpty(message = "Title is required!")
        String title,
        @NotEmpty(message = "Category is required!")
        String category,
        @NotEmpty(message = "Content is required!")
        String content,
        String cover,
        int readTime,
        Long author
) {
}
