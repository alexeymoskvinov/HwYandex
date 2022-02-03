package com.yandex.YandexApi.services;

import com.yandex.YandexApi.services.chatServices.ChatService;
import com.yandex.YandexApi.services.chatServices.IChatService;
import com.yandex.YandexApi.services.chatServices.ProxyChatService;

public class DatabaseService {

//    public enum DatabaseState{
//
//        CONNECTED{
//            private final IChatService chatService = new ChatService();
//            @Override
//            public IChatService getChatService(){
//                return chatService;
//            }
//        },
//
//        DISCONNECTED{
//            private final IChatService chatService = new ProxyChatService();
//            @Override
//            public IChatService getChatService(){
//                return chatService;
//            }
//        };
//
//        public abstract IChatService getChatService();
//    }
}
