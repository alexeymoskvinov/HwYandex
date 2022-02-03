package com.yandex.YandexApi.models.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class DBUser {
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String time;  //hh
}
