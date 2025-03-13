package blogGroup.blog.Controllers;

import blogGroup.blog.Entities.Article;
import blogGroup.blog.Services.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
