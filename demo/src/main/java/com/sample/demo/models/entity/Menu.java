package com.sample.demo.models.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;

@NoArgsConstructor(access = AccessLevel.PROTECTED) 
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name="menu")
public class Menu {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "level")
    private int level;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "path")
    private String path;

    @Column(name = "parent_menu_id")
    private int parentMenuId;
}
