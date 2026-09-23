package vn.iotstar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import vn.iotstar.dto.UserDTO;
import vn.iotstar.service.UserService;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping
    public String list(Model model) {

        model.addAttribute(
                "users",
                userService.findAll()
        );

        return "users/list";
    }


    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute(
                "user",
                new UserDTO()
        );

        return "users/form";
    }


    @PostMapping("/save")
    public String save(
            @ModelAttribute UserDTO user
    ) {

        userService.save(user);

        return "redirect:/users";
    }


    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable Long id
    ) {

        userService.delete(id);

        return "redirect:/users";
    }
}