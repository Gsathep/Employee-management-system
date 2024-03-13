package demo.service;

import demo.Entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    Long save(User employ);
    Optional<User> findByUsername(String username);
}
