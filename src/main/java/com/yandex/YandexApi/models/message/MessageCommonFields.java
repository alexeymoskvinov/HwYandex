package com.yandex.YandexApi.models.message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

public class MessageCommonFields {

    @Getter
    @Setter
    @Column(name = "message")
    protected String message;

}
