package poly.edu.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ctrl")
public class OkController {

    // GET /ctrl/ok -> hiển thị trang ok (khi người mở trang)
    @GetMapping("/ok")
    public String m2(Model model) {
        model.addAttribute("message", "m2() — GET /ctrl/ok");
        return "ok"; // src/main/resources/templates/ok.html
    }

    // POST /ctrl/ok (khi nhấn OK1)
    @PostMapping("/ok")
    public String m1(Model model) {
        model.addAttribute("message", "m1() — POST /ctrl/ok");
        return "ok";
    }

    // POST /ctrl/ok?x  (khi nhấn OK3) -> mapping cụ thể với param x
    @PostMapping(value = "/ok", params = "x")
    public String m3(Model model) {
        model.addAttribute("message", "m3() — POST /ctrl/ok?x");
        return "ok";
    }
}
