package kw.projekt.model.contact.view_model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class ContactForm {

    @NotNull(message = "Imię nie może być puste.")
    private String firstName;

    @NotNull(message = "Nazwisko nie może być puste.")
    private String lastName;

    @NotNull(message = "E-mail nie może być pusty.")
    @Email(message = "E-mail jest niepoprawny")
    private String email;

    private String phone;

    @NotNull(message = "Wiadomość nie może być pusta")
    @Size(min = 30, message = "Wiadomość za krótka.")
    private String message;

}