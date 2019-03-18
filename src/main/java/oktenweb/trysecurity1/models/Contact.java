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

    public Contact(String contactName, String email) {
        this.contactName = contactName;
        this.email = email;
    }

    @ManyToOne(cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY)
    User user;
//    @ManyToOne(cascade = CascadeType.DETACH,
//            fetch = FetchType.LAZY)
//    Worker worker;

}
