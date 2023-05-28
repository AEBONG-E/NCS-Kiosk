package com.kobuks.kiosk.admin.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.kobuks.kiosk.admin.service.AdminService;


@Controller("kiosk.deleteMenuController")
public class RemoveMenuController {

    @Autowired
    private AdminService adminService;

    @DeleteMapping("/menu/{menuId}")
    public String removeMenu(@PathParam("menuId") long menuId, Model model) {
    	adminService.removeMenu(menuId);
        model.addAttribute("message", "메뉴가 삭제되었습니다.");
        return "result";
    }
}