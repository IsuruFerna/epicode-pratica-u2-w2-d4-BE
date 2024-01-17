package myweb.u2w2d1BE.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Entity
@Getter
@Setter
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Author{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", birthDay=").append(birthDay);
        sb.append(", avatar='").append(avatar).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
