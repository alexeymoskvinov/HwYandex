package com.yandex.YandexApi.controllers.responses;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatCreateResponse implements IResponse {
    @JsonProperty("id")
    private String id;

    public ChatCreateResponse(String id){
        this.id = id;
    }

}
