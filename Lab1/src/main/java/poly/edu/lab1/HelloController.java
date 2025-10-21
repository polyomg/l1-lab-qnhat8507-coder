package poly.edu.lab1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/poly/hello")
    public String hello() {
        return "hello"; // trả về hello.html
    }

}
