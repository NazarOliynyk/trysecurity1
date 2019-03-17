package oktenweb.trysecurity1.dao;

import oktenweb.trysecurity1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer>{

    User findByUsername(String username);
}
