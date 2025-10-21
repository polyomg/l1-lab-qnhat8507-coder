package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RectangleController {

    @GetMapping("/form2")
    public String showForm() {
        return "form2"; // Hiển thị form.html
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam("length") double length,
            @RequestParam("width") double width,
            Model model) {

        double area = length * width;
        double perimeter = 2 * (length + width);

        model.addAttribute("length", length);
        model.addAttribute("width", width);
        model.addAttribute("area", area);
        model.addAttribute("perimeter", perimeter);

        return "result"; // Hiển thị result.html
    }
}
