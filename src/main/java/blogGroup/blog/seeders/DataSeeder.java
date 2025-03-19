package blogGroup.blog.seeders;

import blogGroup.blog.entities.Article;
import blogGroup.blog.entities.Comment;
import blogGroup.blog.entities.User;
import blogGroup.blog.repositories.ArticleRepository;
import blogGroup.blog.repositories.CommentRepository;
import blogGroup.blog.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataSeeder {
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public DataSeeder(UserRepository userRepository, ArticleRepository articleRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
    }

    @Transactional
    public void addData() {
        User john = new User();
        john.setFirstname("John");
        john.setLastname("Ten");
        john.setEmail("jm10yap@gmail.com");
        john.setPassword("password");
        john.setCreatedAt(LocalDateTime.now());

        User fan = new User();
        fan.setFirstname("Paula");
        fan.setLastname("Cutruneo");
        fan.setEmail("paulic@gmail.com");
        fan.setPassword("password");
        fan.setCreatedAt(LocalDateTime.now());

        User fan2 = new User();
        fan2.setFirstname("Maups");
        fan2.setLastname("Loren");
        fan2.setEmail("maupsl@gmail.com");
        fan2.setPassword("password");
        fan2.setCreatedAt(LocalDateTime.now());

        this.userRepository.save(john);
        this.userRepository.save(fan);
        this.userRepository.save(fan2);

        for (int i = 0; i < 19; i++) {
            Article article = new Article();
            article.setTitle("Article " + (i + 1));
            article.setContent("This is the content of the article number " + (i + 1) + ". It is an article created for a project that uses Java, with its framework Spring (Spring Boot) using a MVC architecture with Thymeleaf as its model. Thank you for your visit and we hope to see you again.");
            article.setCreatedAt(LocalDateTime.now());

            john.addArticle(article);
            this.articleRepository.save(article);
            this.userRepository.save(john);

            Comment comment = new Comment();
            comment.setContent("Wow that is very interesting");
            comment.setAuthor(fan);
            comment.setCreatedAt(LocalDateTime.now());
            article.addComment(comment);

            Comment comment2 = new Comment();
            comment2.setContent("Thanks Paula!");
            comment2.setAuthor(john);
            comment2.setCreatedAt(LocalDateTime.now());
            article.addComment(comment2);

            Comment comment3 = new Comment();
            comment3.setContent("I like this a lot");
            comment3.setAuthor(fan2);
            comment3.setCreatedAt(LocalDateTime.now());
            article.addComment(comment3);

            Comment comment4 = new Comment();
            comment4.setContent("Thanks");
            comment4.setAuthor(john);
            comment4.setCreatedAt(LocalDateTime.now());
            article.addComment(comment4);

            this.commentRepository.save(comment);
            this.commentRepository.save(comment2);
            this.commentRepository.save(comment3);
            this.commentRepository.save(comment4);
            this.articleRepository.save(article);
            this.userRepository.save(john);
            this.userRepository.save(fan);
            this.userRepository.save(fan2);
        }
    }
}
