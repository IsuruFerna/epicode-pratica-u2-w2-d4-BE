package myweb.u2w2d1BE.payload.users;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import myweb.u2w2d1BE.entities.BlogPost;

import java.util.List;

public record NewAuthorDTO(
        @NotEmpty(message = "First name required!")
        @Size(min = 3, max = 30, message = "Ensure the name is between 3 and 30 characters long!")
        String firstName,
        @NotEmpty(message = "Last name required!")
        @Size(min = 3, max = 30, message = "Ensure the name is between 3 and 30 characters long!")
        String lastName,
        @Email(message = "Inserted email isn't valid!")
        @NotEmpty(message = "Email required!")
        String email,
        String birthDay,
        String avatar
) {
}
