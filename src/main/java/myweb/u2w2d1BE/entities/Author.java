package myweb.u2w2d1BE.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue
//    @Setter(AccessLevel.NONE)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDay;
    private String avatar;

    @NonNull
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    List<BlogPost> blogPostList;

    public Author(String firstName, String lastName, String email, String birthDay, String avatar) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDay = LocalDate.parse(birthDay);
    }
}
