package com.kobuks.kiosk.admin.controller;

import com.kobuks.kiosk.menu.domain.Menu;
import com.kobuks.kiosk.menu.domain.MenuImg;
import com.kobuks.kiosk.menu.service.MenuServiceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

import java.util.List;

@Controller
@SessionAttributes("id")
public class AdminMenuController {

    private final MenuServiceImpl menuService;

    public AdminMenuController(MenuServiceImpl menuService) {
        this.menuService = menuService;
    }

    @GetMapping(value = "/admin/menu_save")
    @ModelAttribute("menuSaveForm")
    public String menuSavePage(@RequestParam(name = "mid", required = false) Menu menu, Model model) {
        model.addAttribute("menuSaveForm", menu);
        return "/admin/menu_save";
    }

    @PostMapping(value = "/admin/menu_save")
    public String processMenuSave(@ModelAttribute("menuSaveForm") @Validated Menu menu,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes,
                           @RequestParam("imgFile") MultipartFile imgFile) throws IOException {
        if (bindingResult.hasErrors()) {
            return "/admin/menu_save";
        }

        // 이미지 파일이 있는 경우에만 이미지 저장
        if (!imgFile.isEmpty()) {
            MenuImg menuImg = new MenuImg();
            menuImg.setImgData(imgFile.getBytes());
            menuImg.setImgName(imgFile.getOriginalFilename());
            menuImg.setOriImgName(imgFile.getOriginalFilename());
            menuImg.setImgUrl("/menu/images/" + imgFile.getOriginalFilename());
            menu.setFile(menuImg.getFile());
        }

        menuService.saveMenu(menu);

        redirectAttributes.addAttribute("menuId", menu.getMid());

        return "redirect:/admin/menu_info";
    }

    @GetMapping(value = "/admin/menu_info")
    public String menuInfo(@RequestParam("menuId") Long menuId, Model model) {
        List<Menu> menuInfo = menuService.getMenuWithImage(menuId);
        model.addAttribute("menuCommand", menuInfo);
        return "/admin/menu_info";
    }

    @ModelAttribute("menuSaveForm")
    public Menu createMenuSaveForm() {
        return new Menu();
    }

    @GetMapping(value = "/admin/menu_management")
    public String menuManagement(Model model, Long mid) {
        Menu menus = menuService.getAllMenusById(mid);
        model.addAttribute("menuCommands", menus);

        return "admin/menu_management";
    }

    @GetMapping(value = "/admin/menu_info_page")
    public String menuInfoPage(@RequestParam("menuId") Long menuId, Model model) {
        List<Menu> menuInfo = menuService.getMenuWithImage(menuId);
        model.addAttribute("menuCommand", menuInfo);
        return "/admin/menu_info";
    }

    @GetMapping(value = "/admin/menu_modify")
    public String showModifyPage(@RequestParam(value = "parm", required = false) String parm,
                                 @RequestParam Long menuId,
                                 Model model) {
        List<Menu> menuModifyForm = menuService.getMenuWithImage(menuId);
        model.addAttribute("menuModifyForm", menuModifyForm);
        model.addAttribute("parm", parm);
        return "/admin/menu_modify";
    }

    @PostMapping(value = "/admin/menu_modify")
    public String modifyMenu(@ModelAttribute Menu menu,
                             @RequestParam(value = "parm", required = false) String parm,
                             Model model) {
        menuService.updateMenu(menu);
        if ("menudelete".equals(parm)) {
            return "redirect:/admin/menu_delete?menuId=" + menu.getMid();
        } else {
            return "redirect:/admin/menu_management";
        }
    }

    @GetMapping(value = "/admin/menu_delete")
    public String menuDelete(@RequestParam Long mid, Model model) {
        List<Menu> menuDeleteForm = menuService.getMenuWithImage(mid);
        model.addAttribute("menuDeleteForm", menuDeleteForm);
        return "/admin/menu_delete";
    }

    @PostMapping(value = "/admin/menu_delete")
    public String deleteMenu(@RequestParam Long mid) {
        menuService.deleteMenu(mid);
        return "redirect:/admin/menu_management";
    }

}


