package ru.albertgazin.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("message", "Hello, " + name);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam("number1") int firstNumber
            , @RequestParam("number2") int secondNumber
            , @RequestParam("action") String action
            , Model model) {
        double result = 0;
        switch (action) {
            case "m":
                result = firstNumber * secondNumber;
                break;
            case "s":
                result = firstNumber - secondNumber;
                break;
            case "d":
                result = (double) firstNumber / secondNumber;
                break;
            case "a":
                result = firstNumber + secondNumber;
                break;
        }
        model.addAttribute("result", result);
        return "first/calculation";
    }
}
