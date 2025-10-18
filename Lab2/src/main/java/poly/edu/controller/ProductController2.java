package poly.edu.controller;

import poly.edu.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController2 {

    private final List<Product> items = new ArrayList<>();

    public ProductController2() {
        items.add(new Product("A", 1.0));
        items.add(new Product("B", 12.0));
    }

    @GetMapping("/product/form2")
    public String form2(Model model) {
        Product p = new Product("iPhone 30", 5000.0);
        model.addAttribute("item1", p);
        model.addAttribute("item2", new Product());
        model.addAttribute("items", items);
        return "product/form2";
    }

    @PostMapping("/product/save2")
    public String save2(@ModelAttribute("item2") Product p, Model model) {
        model.addAttribute("item1", new Product("iPhone 30", 5000.0));
        model.addAttribute("item2", p);
        items.add(p); // Thêm sản phẩm mới vào danh sách
        model.addAttribute("items", items);
        return "product/form2";
    }

    public List<Product> getItems() {
        return items;
    }
}