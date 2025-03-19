package blogGroup.blog.services;

import blogGroup.blog.dtos.UserRequestDTO;
import blogGroup.blog.entities.User;
import blogGroup.blog.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public void saveUser(UserRequestDTO userRequest) {
        User newUser = new User(userRequest.getFirstname(), userRequest.getLastname(), userRequest.getEmail(), userRequest.getPassword());
        userRepository.save(newUser);
    }
}
