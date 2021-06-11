package kw.projekt.model.contact;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "want_to_contact")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WantToContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "want_to_contact_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "message")
    private String message;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_state_id")
    private ContactState state;

    @Column(name = "add_date")
    private Date addDate;

}
