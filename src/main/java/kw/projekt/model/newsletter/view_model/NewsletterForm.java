package kw.projekt.model.newsletter.view_model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class NewsletterForm {

    @NotNull(message = "Imię nie może być puste.")


    @NotNull(message = "E-mail nie może być pusty.")
    @Email(message = "E-mail jest niepoprawny")
    private String subscriberEmail;

}
