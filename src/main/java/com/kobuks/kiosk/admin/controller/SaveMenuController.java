package com.kobuks.kiosk.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kobuks.kiosk.admin.service.AdminService;
import com.kobuks.kiosk.menu.command.MenuCommand;
import com.kobuks.kiosk.menu.domain.Menu;

@Controller("kiosk.saveMenuController")
@RequestMapping("")
public class SaveMenuController {
	
	private AdminService adminService;
	
	@Autowired
	public SaveMenuController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@GetMapping
	public String saveMenu(Model model) {
		model.addAttribute("menu", new Menu());
		return "";
	}
	
	@PostMapping
	public String SaveMenu(@ModelAttribute("menu")MenuCommand menu, Model model) {
		
		//Menu 객체를 이용하여 새로운 메뉴 추가
		Menu m = new Menu();
		m.setMenuName(menu.getMenuName());
		m.setPrice(menu.getPrice());
		m.setMenuImg(menu.getMenuImg());
		m.setMenuType(menu.getMenuType());
		m.setMenuSize(menu.getMenuSize());
		m.setMenuOption(menu.isMenuOption());
		
		adminService.saveMenu(m);
		
		model.addAttribute("menu", m);
		return "";
	}
	

}
