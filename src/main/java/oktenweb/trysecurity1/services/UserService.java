package oktenweb.trysecurity1.services;

import oktenweb.trysecurity1.models.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

@Qualifier("userService")
public interface UserService extends UserDetailsService {

    void save(User user);

    List<User> findAll();

    User findOneById(Integer id);

}
