package com.yandex.YandexApi.services.chatServices;

import com.yandex.YandexApi.repositories.ChatRepository;
import com.yandex.YandexApi.repositories.MessageRepository;
import com.yandex.YandexApi.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ServiceConfig{
    @Bean
    @Primary
    public IChatService getServiceImpl(ChatRepository chatsRepo, MessageRepository messagesRepo, UserRepository usersRepo) {
        return new ChatService(chatsRepo, messagesRepo, usersRepo);
    }

    @Bean

    public IChatService getServiceProxy(ChatRepository chatsRepo, MessageRepository messagesRepo, UserRepository usersRepo) {
        return new ProxyChatService(chatsRepo, messagesRepo, usersRepo);
    }
}
