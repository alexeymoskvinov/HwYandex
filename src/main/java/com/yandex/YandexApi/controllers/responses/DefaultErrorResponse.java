package com.yandex.YandexApi.controllers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DefaultErrorResponse implements IResponse {
    @JsonProperty("message")
    private String message;

    public DefaultErrorResponse(String message){
        this.message = message;
    }
}
