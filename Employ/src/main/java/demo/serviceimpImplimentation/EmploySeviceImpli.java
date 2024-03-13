package demo.serviceimpImplimentation;

import demo.Entity.User;
import demo.Repository.UserRepository;
import demo.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmploySeviceImpli implements UserService
{
    @Autowired
    UserRepository employRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Long save(@NotNull User employ)
    {
        employ.setPassword(passwordEncoder.encode(employ.getUsername()));

        return employRepository.save(employ).getId();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return employRepository.findById(Long.valueOf(username));
    }
}
