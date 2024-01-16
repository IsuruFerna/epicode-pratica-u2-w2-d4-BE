package myweb.u2w2d1BE.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Random;

@Getter
@Setter
@ToString
public class Author {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDay;
    private String avatar;

    public Author(String firstName, String lastName, String email, String birthDay, String avatar) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDay = LocalDate.parse(birthDay);
    }
}
