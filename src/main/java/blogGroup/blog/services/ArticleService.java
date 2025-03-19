package blogGroup.blog.services;

import blogGroup.blog.dtos.ArticleRequestDTO;
import blogGroup.blog.entities.Article;
import blogGroup.blog.entities.Comment;
import blogGroup.blog.entities.User;
import blogGroup.blog.repositories.ArticleRepository;
import blogGroup.blog.repositories.CommentRepository;
import blogGroup.blog.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    public ArticleService(ArticleRepository articleRepository, UserRepository userRepository, CommentRepository commentRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    public List<Article> getArticlesForHome(String query) {
        return this.articleRepository.findAllByOrderByCreatedAtDesc();
    }

    public Article getArticle(Long id) {
        return this.articleRepository.findById(id).orElseThrow();
    }

    public List<Article> getArticlesForAdmin() {
        return this.articleRepository.findAll();
    }

    public void createArticle(ArticleRequestDTO articleRequestDTO) {
        User author = this.userRepository.findById(1L).orElseThrow();
        Article newArticle = new Article(articleRequestDTO.getTitle(), articleRequestDTO.getContent());
        author.addArticle(newArticle);
        this.articleRepository.save(newArticle);
        this.userRepository.save(author);
    }

    public void editArticle(Long id, ArticleRequestDTO articleRequestDTO) {
        Article article = this.articleRepository.findById(id).orElseThrow();
        if (articleRequestDTO.getTitle() != null) article.setTitle(articleRequestDTO.getTitle());
        if (articleRequestDTO.getContent() != null) article.setContent(articleRequestDTO.getContent());
        this.articleRepository.save(article);
    }

    public void deleteArticle(Long id) {
        Article article = this.articleRepository.findById(id).orElseThrow();
        User author = article.getAuthor();
        author.removeArticle(article);

        this.articleRepository.delete(article);
    }

    @Transactional
    public void addArticles() {
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

        userRepository.save(john);
        userRepository.save(fan);
        userRepository.save(fan2);

        for (int i = 0; i < 19; i++) {
            Article article = new Article();
            article.setTitle("Article " + (i + 1));
            article.setContent("This is the content of the article number " + (i + 1) + ". It is an article created for a project that uses Java, with its framework Spring (Spring Boot) using a MVC architecture with Thymeleaf as its model. Thank you for your visit and we hope to see you again.");
            article.setCreatedAt(LocalDateTime.now());

            john.addArticle(article);
            articleRepository.save(article);
            userRepository.save(john);

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

            commentRepository.save(comment);
            commentRepository.save(comment2);
            commentRepository.save(comment3);
            commentRepository.save(comment4);
            articleRepository.save(article);
            userRepository.save(john);
            userRepository.save(fan);
            userRepository.save(fan2);
        }


    }

}
