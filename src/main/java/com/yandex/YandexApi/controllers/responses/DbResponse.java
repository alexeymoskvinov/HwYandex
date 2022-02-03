package com.yandex.YandexApi.controllers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DbResponse implements IResponse {
    @JsonProperty("message")
    private String message;

    public DbResponse(String message){
        this.message = message;
    }
}
