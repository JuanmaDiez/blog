package blogGroup.blog.controllers;

import blogGroup.blog.dtos.ArticleRequestDTO;
import blogGroup.blog.services.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public String store(@ModelAttribute ArticleRequestDTO articleRequestDTO) {
        this.articleService.createArticle(articleRequestDTO);
        return "redirect:/admin";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute ArticleRequestDTO articleRequestDTO) {
        this.articleService.editArticle(id, articleRequestDTO);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        this.articleService.deleteArticle(id);
        return "redirect:/admin";
    }
}
