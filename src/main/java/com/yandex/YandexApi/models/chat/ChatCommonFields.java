package com.yandex.YandexApi.models.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.MappedSuperclass;

public class ChatCommonFields {
    @Getter
    @NonNull
    @JsonProperty("chat_name")
    @Length(min = 1, max = 255, message = "Wrong name format")
    protected String name;

}
