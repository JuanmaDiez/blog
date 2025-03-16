package blogGroup.blog.controllers;

import blogGroup.blog.entities.Article;
import blogGroup.blog.services.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PageController {
    private final ArticleService articleService;

    public PageController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    @RequestMapping("/")
    public String getHomePage(Model model) {
        List<Article> articles = articleService.getArticlesForHome(null);
        model.addAttribute("articles", articles);
        return "home";
    }

    @GetMapping
    @RequestMapping("/articles/{id}")
    public String getArticlePage(@PathVariable Long id, Model model) {
        Article article = articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article";
    }
}
