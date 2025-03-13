package blogGroup.blog.Services;

import blogGroup.blog.Entities.Article;
import blogGroup.blog.Repositories.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getArticlesForHome(String query) {
        return this.articleRepository.findAll();
    }
}
