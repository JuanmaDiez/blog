package blogGroup.blog.controllers;

import blogGroup.blog.services.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        this.commentService.deleteComment(id);
        return "redirect:/admin/comments";
    }
}
