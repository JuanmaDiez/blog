package blogGroup.blog.controllers;

import blogGroup.blog.entities.Article;
import blogGroup.blog.entities.Comment;
import blogGroup.blog.entities.User;
import blogGroup.blog.services.ArticleService;
import blogGroup.blog.services.CommentService;
import blogGroup.blog.services.UserService;
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
    private final UserService userService;

    public PageController(ArticleService articleService, CommentService commentService, UserService userService) {
        this.articleService = articleService;
        this.commentService = commentService;
        this.userService = userService;
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
        List<Comment> comments = this.commentService.getComments();
        model.addAttribute("comments", comments);
        return "comments";
    }

    @RequestMapping("/admin/comments/edit/{id}")
    public String getEditComment(@PathVariable Long id, Model model) {
        Comment comment = this.commentService.getComment(id);
        model.addAttribute("comment", comment);
        return "editComment";
    }

    @RequestMapping("/admin/users")
    public String getUsers(Model model) {
        List<User> users = this.userService.getUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping("/admin/users/edit/{id}")
    public String getEditUser(@PathVariable Long id, Model model) {
        User user = this.userService.getUser(id);
        model.addAttribute("user", user);
        return "editUser";
    }
}
