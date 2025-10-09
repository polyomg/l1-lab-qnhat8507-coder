package poly.edu.lab1;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RectangleController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/rectangle/form")
    public String form() {
        return "rectangle";
    }

    @PostMapping("/rectangle/calc")
    public String calc(Model model) {
        double width = Double.parseDouble(request.getParameter("width"));
        double height = Double.parseDouble(request.getParameter("height"));

        double area = width * height;
        double perimeter = 2 * (width + height);

        model.addAttribute("result",
                "Diện tích = " + area + ", Chu vi = " + perimeter);

        return "rectangle";
    }
}