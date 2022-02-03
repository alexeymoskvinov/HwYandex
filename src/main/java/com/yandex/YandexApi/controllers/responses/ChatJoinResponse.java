package com.yandex.YandexApi.controllers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatJoinResponse implements IResponse{
    @JsonProperty("user_id")
    private final String id;

    public ChatJoinResponse(String id){
        this.id = id;
    }

}
