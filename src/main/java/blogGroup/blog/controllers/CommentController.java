package blogGroup.blog.controllers;

import blogGroup.blog.dtos.CommentRequestDTO;
import blogGroup.blog.services.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public String store(@ModelAttribute CommentRequestDTO commentRequestDTO) {
        this.commentService.createComment(commentRequestDTO);
        return "redirect:/articles/" + commentRequestDTO.getArticleId();
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute CommentRequestDTO commentRequestDTO) {
        this.commentService.editComment(id, commentRequestDTO);
        return "redirect:/admin/comments";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        this.commentService.deleteComment(id);
        return "redirect:/admin/comments";
    }
}
