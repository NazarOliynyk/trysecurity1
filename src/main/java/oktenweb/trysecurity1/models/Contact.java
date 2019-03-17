package oktenweb.trysecurity1.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity(name = "Contacts")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString(exclude = {"user"})
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;
     String contactName;
     String email;
    @ManyToOne(cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY)
    User user;

}
