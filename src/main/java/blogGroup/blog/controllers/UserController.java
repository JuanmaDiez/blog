package blogGroup.blog.controllers;

import blogGroup.blog.dtos.UserRequestDTO;
import blogGroup.blog.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public String createUser(@ModelAttribute UserRequestDTO userRequest) {
        service.saveUser(userRequest);
        return "redirect:/";
    }
}
