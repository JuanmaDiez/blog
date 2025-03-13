package blogGroup.blog;

import blogGroup.blog.Entities.User;
import blogGroup.blog.Services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BlogApplication.class, args);
	}

}
