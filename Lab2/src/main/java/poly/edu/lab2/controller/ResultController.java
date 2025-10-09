package poly.edu.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResultController {

    @RequestMapping("/a")
    public String m1() {
        return "a"; // trả view a.html
    }

    @RequestMapping("/b")
    public String m2(Model model) {
        model.addAttribute("message", "I come from b");
        return "forward:/a"; // ?1: forward giữ model attributes -> a.html thấy ${message}
    }

    @RequestMapping("/c")
    public String m3(RedirectAttributes params) {
        params.addAttribute("message", "I come from c"); // thêm vào query param
        return "redirect:/a"; // ?2: redirect -> gửi param as URL param (/a?message=I%20come%20from%20c)
    }

    @ResponseBody // ?3: trả trực tiếp string (không qua view resolver)
    @RequestMapping("/d")
    public String m4() {
        return "I come from d";
    }
}
