package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import app.model.User;
import app.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("users", userService.foundUser(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("users") User user) {
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("users") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "users/new";

        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("users", userService.foundUser(id));
        return "users/editor";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("users") @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors())
            return "users/editor";

        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }
}
