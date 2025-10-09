package poly.edu.lab2.controller;

import poly.edu.lab2.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    // GET: hiển thị form + sản phẩm mặc định
    @GetMapping("/product/form")
    public String form(Model model) {
        // Sản phẩm mặc định (hiện trên view)
        Product defaultProduct = new Product("iPhone 30", 5000.0);
        model.addAttribute("p", defaultProduct);

        // Sản phẩm nhập từ form (binding)
        model.addAttribute("product", new Product());

        return "product/form";
    }

    // POST: nhận dữ liệu từ form
    @PostMapping("/product/save")
    public String save(@ModelAttribute("product") Product product, Model model) {
        // Truyền lại product vừa nhập để hiển thị
        model.addAttribute("product", product);
        return "product/form";
    }

    // Danh sách sản phẩm mẫu (dùng @ModelAttribute)
    @ModelAttribute("items")
    public List<Product> getItems() {
        return Arrays.asList(
                new Product("A", 1.0),
                new Product("B", 12.0),
                new Product("C", 25.5)
        );
    }
}
