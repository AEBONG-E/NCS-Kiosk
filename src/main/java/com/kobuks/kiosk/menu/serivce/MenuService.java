package com.kobuks.kiosk.menu.serivce;

import com.kobuks.kiosk.config.FileStorageProperties;
import com.kobuks.kiosk.exception.ResourceNotFoundException;
import com.kobuks.kiosk.menu.entity.Menu;
import com.kobuks.kiosk.menu.entity.MenuImg;
import com.kobuks.kiosk.menu.entity.MenuType;
import com.kobuks.kiosk.menu.repository.MenuImgRepository;
import com.kobuks.kiosk.menu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private MenuImgRepository menuImgRepository;
    @Autowired
    private FileStorageProperties fileStorageProperties;


    // Menu creation
    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    // Creating menu image
    public Menu createMenuImage(Long menuId, MenuImg menuImg)
            throws ResourceNotFoundException {
        Menu menu = menuRepository.findById(menuId).orElseThrow(() ->
                new ResourceNotFoundException("Menu not found"));
        menu.setMenuImg(menuImg);
        return menuRepository.save(menu);
    }

    public MenuImg storeMenuImage(MultipartFile imageFile) throws IOException {
        // Create upload directory if it doesn't exist
        Path uploadPath = Paths.get(fileStorageProperties.getUploadDir());
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Store the image file
        String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // Create a new MenuImg instance and populate its properties
        MenuImg menuImg = new MenuImg();
        menuImg.setImageName(fileName);
        menuImg.setImageUrl("/resources/static/images/" + fileName);
        menuImg.setOriginalFileName(imageFile.getOriginalFilename());
        menuImg.setImagePath(filePath.toString());

        // Return the saved MenuImg instance
        return menuImgRepository.save(menuImg);
    }

    // Menu inquiry by menu type
    public List<Menu> getMenusByType(MenuType type) {
        return menuRepository.findByType(type);
    }

    // Menu inquiry by menu id
    public Optional<Menu> getMenuById(Long id) {
        return menuRepository.findById(id);
    }

    // Menu and menu image inquiry by menu type
    public List<Menu> getMenusWithImagesByType(MenuType type) {
        return menuRepository.findByTypeAndMenuImgIsNotNull(type);
    }

    // Menu and menu image inquiry by menu id
    public Optional<Menu> getMenuWithImageById(Long id) {
        return menuRepository.findByIdAndMenuImgIsNotNull(id);
    }

    // Modifying the menu
    public Menu updateMenu(Long id, Menu updatedMenu)
            throws ResourceNotFoundException {
        Menu existingMenu = menuRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Menu not found"));
        existingMenu.setName(updatedMenu.getName());
        existingMenu.setPrice(updatedMenu.getPrice());
        existingMenu.setType(updatedMenu.getType());
        existingMenu.setSize(updatedMenu.getSize());
        existingMenu.setOptions(updatedMenu.getOptions());
        existingMenu.setStock(updatedMenu.getStock());
        existingMenu.setMenuImg(updatedMenu.getMenuImg());
        return menuRepository.save(existingMenu);
    }

    // Modify menu image
    public Menu updateMenuImage(Long menuId, MenuImg updatedMenuImg)
            throws ResourceNotFoundException {
        Menu menu = menuRepository.findById(menuId).orElseThrow(() ->
                new ResourceNotFoundException("Menu not found"));
        menu.setMenuImg(updatedMenuImg);
        return menuRepository.save(menu);
    }

    // Delete menu
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }

    // Delete menu image
    public void deleteMenuImage(Long menuId) throws ResourceNotFoundException {
        Menu menu = menuRepository.findById(menuId).orElseThrow(() ->
                new ResourceNotFoundException("Menu not found"));
        menu.setMenuImg(null);
        menuRepository.save(menu);
    }
}

