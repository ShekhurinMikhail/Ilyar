package web.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.DAO.UserDaolmpl;
import web.model.User;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserDaolmpl userDaolmpl;
    public UsersController(UserDaolmpl userDaolmpl) {
        this.userDaolmpl = userDaolmpl;
    }

    @GetMapping()
    public String ShowAllUsers(Model model) {
        model.addAttribute("users",userDaolmpl.showAllUsers());
        return "showAllUsers";
    }
    @GetMapping("/{id}")
    public String ShowUserId(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDaolmpl.showUserId(id));
        return "showUser";
    }
    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "newUser";
    }
    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "newUser";
        userDaolmpl.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userDaolmpl.showUserId(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult,@PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "edit";
        userDaolmpl.updateUser(id, user);
        return "redirect:/users";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userDaolmpl.deleteUser(id);
        return "redirect:/users";
    }
}
