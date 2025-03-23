package blogGroup.blog.services;

import blogGroup.blog.dtos.UserRequestDTO;
import blogGroup.blog.entities.Role;
import blogGroup.blog.entities.User;
import blogGroup.blog.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public User getUser(Long id) {
        return this.userRepository.findById(id).orElseThrow();
    }

    public void saveUser(UserRequestDTO userRequest) {
        Role role = switch (userRequest.getRole()) {
            case "ADMIN" -> Role.ADMIN;
            case "EDITOR" -> Role.EDITOR;
            case "WRITER" -> Role.WRITER;
            default -> Role.READER;
        };
        User newUser = new User(userRequest.getFirstname(), userRequest.getLastname(), userRequest.getEmail(), this.passwordEncoder.encode(userRequest.getPassword()), role);
        this.userRepository.save(newUser);
    }

    public void editUser(Long id, UserRequestDTO userRequestDTO) {
        User user = this.userRepository.findById(id).orElseThrow();

        if (userRequestDTO.getEmail() != null) user.setEmail(userRequestDTO.getEmail());
        if (userRequestDTO.getFirstname() != null) user.setFirstname(userRequestDTO.getFirstname());
        if (userRequestDTO.getLastname() != null) user.setLastname(userRequestDTO.getLastname());
        if (userRequestDTO.getPassword() != null)
            user.setPassword(this.passwordEncoder.encode(userRequestDTO.getPassword()));

        this.userRepository.save(user);
    }

    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }
}
