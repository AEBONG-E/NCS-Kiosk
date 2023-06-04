package com.kobuks.kiosk.menu.repository;

import com.kobuks.kiosk.menu.entity.Menu;
import com.kobuks.kiosk.menu.entity.MenuType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    // 메뉴 유형별로 메뉴 찾기
    List<Menu> findByType(MenuType type);

    // ID로 메뉴 찾기(JpaRepository에서 이미 제공하므로 이 방법을 명시적으로 정의할 필요가 없음)
    // Optional<Menu> findById(Long id);

    // 메뉴 유형별로 이미지가 있는 메뉴 찾기
    List<Menu> findByTypeAndMenuImgIsNotNull(MenuType type);

    // ID로 이미지가 있는 메뉴 찾기
    Optional<Menu> findByIdAndMenuImgIsNotNull(Long id);
}

