package com.kobuks.kiosk.menu.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 메뉴이미지를 저장하기 위한 정보를 담고 있는 클래스
 * 메뉴와 1:1 의 매핑 관계를 가짐
 */
@Entity
@Table(name = "menu_img")
@Getter
@Setter
public class MenuImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imgId;

    @Column(nullable = false, length = 100)
    private String imageName;

    @Column(name = "original_file_name", nullable = false, length = 100)
    private String originalFileName;

    @Column(nullable = false, length = 100)
    private String imageUrl;

    @Column(nullable = false, length = 100)
    private String imagePath;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] imageBytes; // Optional, for storing the image in the database as a binary object

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

}

