package blogGroup.blog.controllers;

import blogGroup.blog.dtos.UserRequestDTO;
import blogGroup.blog.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String store(@ModelAttribute UserRequestDTO userRequest) {
        this.userService.saveUser(userRequest);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        this.userService.deleteUser(id);
        return "redirect:/admin/users";
    }
}
