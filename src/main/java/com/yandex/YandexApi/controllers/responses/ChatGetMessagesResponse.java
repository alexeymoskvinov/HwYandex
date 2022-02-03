package com.yandex.YandexApi.controllers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yandex.YandexApi.models.Cursor;
import com.yandex.YandexApi.models.message.MessageForResponse;

import java.util.ArrayList;

public class ChatGetMessagesResponse implements IResponse {
    @JsonProperty("messages")
    private ArrayList<MessageForResponse> messages;
    @JsonProperty("next")
    private Cursor cursor;
    public ChatGetMessagesResponse(ArrayList<MessageForResponse> messages, Cursor cursor){
        this.messages = messages;
        this.cursor = cursor;
    }
}
