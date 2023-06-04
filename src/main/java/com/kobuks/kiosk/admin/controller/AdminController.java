package com.kobuks.kiosk.admin.controller;


import com.kobuks.kiosk.admin.domain.Admin;
import com.kobuks.kiosk.admin.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("id")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @GetMapping(value = "/login")
    public String showLoginPage() {
        return "/admin/login";
    }

    @PostMapping(value = "/login")
    public String adminLogin(Admin admin, HttpSession session, Model model) {
        Admin loginAdmin = adminService.getAdmin(admin.getId(), admin.getPassword());
        if (loginAdmin != null) {
            session.setAttribute("id", "admin"); // 세션에 id 저장
            System.out.println(session.toString());
            return "/admin/admin_home";
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "/admin/login";
        }
    }
    @GetMapping(value = "/logout")
    public String adminLogout(HttpSession session) {
        session.invalidate(); // 세션 만료
        return "/admin/login";

    }

    @GetMapping(value = "/admin/admin_home")
    public String adminHome() {
        return "/admin/admin_home";
    }

    @GetMapping(value = "admin/order_list")
    public String adminOrderListPage() {
        return "/admin/order_list";
    }

    @GetMapping(value = "admin/sales_date")
    public String adminSalesDatePage() {
        return "admin/sales_date";
    }

    @GetMapping(value = "admin/sales_month")
    public String adminSalesMonthPage() {
        return "admin/sales_month";
    }

}
