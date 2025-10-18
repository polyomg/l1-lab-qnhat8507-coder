package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/ok")
    public String showOkForm() {
        return "ok"; // Spring sẽ tìm file ok.html trong /templates
    }
}