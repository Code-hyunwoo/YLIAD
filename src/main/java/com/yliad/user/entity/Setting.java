package com.yliad.user.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Setting extends BaseTimeEntity{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "settingId")
    private Long id;

    @OneToOne(mappedBy = "setting", cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name="settingId")
    private User user;

    private String bgmName;

    private String themeName;

    private String fontName;

    //폰트,테마,bgm을 enum으로 넣은다면?

    public Setting(Long id, User user, String bgmName, String themeName, String fontName) {
        this.id = id;
        this.user = user;
        this.bgmName = bgmName;
        this.themeName = themeName;
        this.fontName = fontName;
    }

    public void setSetting() {
        this.bgmName = "default";
        this.fontName = "default";
        this.themeName = "default";
    }

    public void changeBgm(String bgmName) {
        this.bgmName = bgmName;
    }
    public void changeFont(String fontName) {
        this.fontName = fontName;
    }
    public void changeTheme(String themeName) {
        this.themeName = themeName;
    }
}
