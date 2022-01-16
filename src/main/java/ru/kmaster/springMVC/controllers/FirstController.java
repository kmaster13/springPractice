package ru.kmaster.springMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a", required = false) double a,
                                 @RequestParam(value = "b", required = false) double b,
                                 @RequestParam(value = "action", required = false) String action,
                                 Model model) {

        model.addAttribute("message", "Your numbers " + a + " and " + b + ", action is " + action);

        switch (action) {
            case "multiplication":
                model.addAttribute("action", a * b);
                break;
            case "addition":
                model.addAttribute("action", a + b);
                break;
            case "subtraction":
                model.addAttribute("action", a - b);
                break;
            case "division":
                model.addAttribute("action", a / b);
                break;
            default:
                model.addAttribute("action", "Action is not found!");
                break;
        }
        return "/first/calculator";
    }
}
