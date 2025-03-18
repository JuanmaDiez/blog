package blogGroup.blog.services;

import blogGroup.blog.entities.Article;
import blogGroup.blog.entities.Comment;
import blogGroup.blog.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getComments() {
        return this.commentRepository.findAll();
    }

    public void deleteComment(Long id) {
        Comment comment = this.commentRepository.findById(id).orElseThrow();
        Article article = comment.getArticle();
        article.removeComment(comment);

        this.commentRepository.delete(comment);
    }
}
