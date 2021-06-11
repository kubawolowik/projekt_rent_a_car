package kw.projekt.model.contact;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contact_state")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_state_id")
    private int id;

    @OneToMany(
            mappedBy = "state",
            fetch = FetchType.LAZY)
    private List<WantToContact> wantToContacts;

    @Column(name = "state_name")
    private String stateName;

}
