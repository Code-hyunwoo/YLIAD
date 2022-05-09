package com.yliad.user_api.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Setting {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "settingId")
    private Long id;

    private Long user_id;
    private Long bgm_id;
    private Long theme_id;
    private Long font_id;

}
