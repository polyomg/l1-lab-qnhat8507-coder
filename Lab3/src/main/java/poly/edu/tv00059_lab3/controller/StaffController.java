package poly.edu.tv00059_lab3.controller;

import poly.edu.tv00059_lab3.model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    private List<Staff> createList() {
        return List.of(
                Staff.builder().id("user1@gmail.com").fullname("nguyễn văn user1").level(0).build(),
                Staff.builder().id("user2@gmail.com").fullname("nguyễn văn user2").level(1).build(),
                Staff.builder().id("user3@gmail.com").fullname("nguyễn văn user3").level(2).build(),
                Staff.builder().id("user4@gmail.com").fullname("nguyễn văn user4").level(2).build(),
                Staff.builder().id("user5@gmail.com").fullname("nguyễn văn user5").level(1).build(),
                Staff.builder().id("user6@gmail.com").fullname("nguyễn văn user6").level(0).build()
        );
    }

    @GetMapping("/detail")
    public String detail(Model model) {
        Staff staff = Staff.builder()
                .id("user@gmail.com")
                .fullname("nguyễn văn user")
                .level(2)
                .build();
        model.addAttribute("staff", staff);
        return "demo/staff-detail";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("list", createList());
        return "demo/staff-list";
    }

    @GetMapping("/list-status")
    public String listStatus(Model model) {
        model.addAttribute("list", createList());
        return "demo/list-status";
    }

    @GetMapping("/list-controls")
    public String listControls(Model model) {
        model.addAttribute("list", createList());
        return "demo/list-controls";
    }
}
