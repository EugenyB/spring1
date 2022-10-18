package ua.edu.nuos.spring1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.edu.nuos.spring1.model.Point;
import ua.edu.nuos.spring1.model.User;
import ua.edu.nuos.spring1.services.TabulationService;

import java.util.List;

@Controller
@AllArgsConstructor
public class MyController {

    private TabulationService tabulationService;

    @PostMapping("/hello")
    public String hello(@RequestParam("username") String name, @RequestParam("userage") int age, Model model) {
        User user = new User(name, age);
        model.addAttribute("user", user);
        return "hello";
    }

    @PostMapping("/tabulation")
    public String tabulation(@RequestParam double start, @RequestParam double finish, @RequestParam double step, Model model) {
        List<Point> points = tabulationService.tabulate(start, finish, step);
        model.addAttribute("pts", points);
        return "tabulation";
    }
}
