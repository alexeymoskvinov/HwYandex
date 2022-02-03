package com.yandex.YandexApi.controllers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatSendMessageResponse implements IResponse {
    @JsonProperty("message_id")
    private String id;

    public ChatSendMessageResponse(String id){
        this.id = id;
    }
}
