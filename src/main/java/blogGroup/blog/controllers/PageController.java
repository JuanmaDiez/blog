package blogGroup.blog.controllers;

import blogGroup.blog.entities.Article;
import blogGroup.blog.entities.Comment;
import blogGroup.blog.services.ArticleService;
import blogGroup.blog.services.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PageController {
    private final ArticleService articleService;
    private final CommentService commentService;

    public PageController(ArticleService articleService, CommentService commentService) {
        this.articleService = articleService;
        this.commentService = commentService;
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

    @RequestMapping("/register")
    public String getRegisterPage() {
        return "register";
    }

    @RequestMapping("/admin")
    public String getAdminPage(Model model) {
        List<Article> articles = articleService.getArticlesForAdmin();
        model.addAttribute("articles", articles);
        return "admin";
    }

    @RequestMapping("/admin/articles/create")
    public String getCreateArticle() {
        return "createArticle";
    }

    @RequestMapping("/admin/articles/edit/{id}")
    public String getEditArticle(@PathVariable Long id, Model model) {
        Article article = articleService.getArticle(id);
        model.addAttribute("article", article);
        return "editArticle";
    }

    @RequestMapping("/admin/comments")
    public String getComments(Model model) {
        List<Comment> comments = commentService.getComments();
        model.addAttribute("comments", comments);
        return "comments";
    }
}
