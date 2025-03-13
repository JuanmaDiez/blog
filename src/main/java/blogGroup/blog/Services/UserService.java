package blogGroup.blog.Services;

import blogGroup.blog.Entities.User;
import blogGroup.blog.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
