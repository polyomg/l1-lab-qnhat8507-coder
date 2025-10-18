package poly.edu.tv00059_lab6.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.tv00059_lab6.dao.ProductDAO;
import poly.edu.tv00059_lab6.entity.Product;

@Controller
public class ProductController {

    @Autowired
    ProductDAO dao;

    @RequestMapping("/product/sort")
    public String sort(Model model,
                       @RequestParam("field") Optional<String> field) {

        // Sắp xếp giảm dần theo field, nếu field rỗng thì mặc định là price
        Sort sort = Sort.by(Direction.DESC, field.orElse("price"));
        model.addAttribute("field", field.orElse("price").toUpperCase());

        List<Product> items = dao.findAll(sort);
        model.addAttribute("items", items);

        return "product/sort-and-page"; // Trả về view
    }

    @RequestMapping("/product")
    public String productRoot() {
        return "redirect:/product/page?p=0";
    }

    @RequestMapping("/product/page")
    public String paginate(Model model,
                           @RequestParam("p") Optional<Integer> p) {

        // Trang hiện tại, mặc định là 0. Mỗi trang có 5 sản phẩm.
        int requestedPage = Math.max(0, p.orElse(0));
        Pageable pageable = PageRequest.of(requestedPage, 5);
        Page<Product> page = dao.findAll(pageable);

        // Nếu trang yêu cầu vượt quá tổng số trang, chuyển về trang cuối (nếu có)
        if (requestedPage >= page.getTotalPages() && page.getTotalPages() > 0) {
            Pageable lastPageable = PageRequest.of(page.getTotalPages() - 1, 5);
            page = dao.findAll(lastPageable);
        }

        model.addAttribute("page", page);
        return "product/sort-and-page"; // Trả về cùng view
    }
}
