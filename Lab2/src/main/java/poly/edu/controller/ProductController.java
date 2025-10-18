package poly.edu.controller;

import poly.edu.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @GetMapping("/product/form1")
    public String form(Model model) {
        // tạo 1 product rỗng để binding vào form
        model.addAttribute("product", new Product());
        return "product/form1"; // gọi tới file templates/product/form.html
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute("product") Product product, Model model) {
        // Sau khi submit, dữ liệu sẽ map vào Product
        model.addAttribute("name", product.getName());
        model.addAttribute("price", product.getPrice());
        return "product/form1";
    }
}