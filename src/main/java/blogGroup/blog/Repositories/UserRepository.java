package blogGroup.blog.Repositories;

import blogGroup.blog.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
