package controller;

import entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import repository.UserRepository;

@Slf4j
@Controller
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/reg")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "reg";
    }

    @GetMapping("/auto")
    public String showLoginPage() {
        return "auto";
    }

    @PostMapping("/auto-check")
    public String processLogin(@RequestParam("name") String name,
                               @RequestParam("password") String password) {
        // Проверка пользователя в базе данных
        User user = userRepository.findByName(name); // или другое подходящее поле

        if (user != null && user.getPassword().equals(password)) {
            return "redirect:/start";
        }

        // Если авторизация не удалась
        return "redirect:/auto?error";
    }


        @GetMapping("/start")
    public String showStartPage() {
        return "start";
    }

    @PostMapping("/reg")
    public String createUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/auto";
    }

    @GetMapping("/vkr")
    public String vkrPage() {
        return "vkr"; // Должна существовать страница vkr.html в папке templates
    }

}
