package poly.edu.tv00059_lab5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import poly.edu.tv00059_lab5.service.CookieService;
import poly.edu.tv00059_lab5.service.ParamService;
import poly.edu.tv00059_lab5.service.SessionService;

@Controller
public class AccountController {

    @Autowired
    CookieService cookieService;

    @Autowired
    ParamService paramService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/account/login")
    public String loginForm() {
        return "account/login";
    }

    @PostMapping("/account/login")
    public String loginSubmit() {
        String username = paramService.getString("username", "");
        String password = paramService.getString("password", "");
        boolean remember = paramService.getBoolean("remember", false);

        if (username.equals("poly") && password.equals("123")) {
            sessionService.set("username", username);

            if (remember) {
                cookieService.add("user", username, 24 * 10); // 10 ngày
            } else {
                cookieService.remove("user");
            }
            return "redirect:/item/index";
        }

        return "account/login";
    }
}
