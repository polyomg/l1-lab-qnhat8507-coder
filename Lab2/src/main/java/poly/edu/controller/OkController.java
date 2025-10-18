package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ctrl")
public class OkController {

    @PostMapping("/ok1")
    public String m1() {
        return "ok"; // trả về ok.html
    }

    @GetMapping("/ok2")
    public String m2() {
        return "ok"; // trả về ok.html
    }

    @RequestMapping("/ok3")
    public String m3() {
        return "ok"; // trả về ok.html
    }
}