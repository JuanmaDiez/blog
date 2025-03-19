package blogGroup.blog.services;

import blogGroup.blog.dtos.CommentRequestDTO;
import blogGroup.blog.entities.Article;
import blogGroup.blog.entities.Comment;
import blogGroup.blog.entities.User;
import blogGroup.blog.repositories.ArticleRepository;
import blogGroup.blog.repositories.CommentRepository;
import blogGroup.blog.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository, ArticleRepository articleRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    public List<Comment> getComments() {
        return this.commentRepository.findAll();
    }

    public void createComment(CommentRequestDTO commentRequestDTO) {
        Article article = this.articleRepository.findById(commentRequestDTO.getArticleId()).orElseThrow();
        User author = this.userRepository.findById(2L).orElseThrow();

        Comment comment = new Comment(commentRequestDTO.getContent());
        article.addComment(comment);
        comment.setAuthor(author);

        this.commentRepository.save(comment);
        this.articleRepository.save(article);
        this.userRepository.save(author);
    }

    public void deleteComment(Long id) {
        Comment comment = this.commentRepository.findById(id).orElseThrow();
        Article article = comment.getArticle();
        article.removeComment(comment);

        this.commentRepository.delete(comment);
    }
}
