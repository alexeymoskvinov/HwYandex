package com.yandex.YandexApi.models.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class MessageForResponse {
    @Getter
    @JsonProperty("text")
    private String text;

    public MessageForResponse(String text){
        this.text = text;
    }
}
