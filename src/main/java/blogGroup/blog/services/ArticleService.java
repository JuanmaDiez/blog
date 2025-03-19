package blogGroup.blog.services;

import blogGroup.blog.dtos.ArticleRequestDTO;
import blogGroup.blog.entities.Article;
import blogGroup.blog.entities.User;
import blogGroup.blog.repositories.ArticleRepository;
import blogGroup.blog.repositories.CommentRepository;
import blogGroup.blog.repositories.UserRepository;
import org.springframework.stereotype.Service;

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

}
