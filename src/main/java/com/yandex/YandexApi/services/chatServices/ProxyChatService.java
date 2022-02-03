package com.yandex.YandexApi.services.chatServices;

import com.yandex.YandexApi.models.Cursor;
import com.yandex.YandexApi.models.chat.Chat;
import com.yandex.YandexApi.models.chat.ChatCommonFields;
import com.yandex.YandexApi.models.message.Message;
import com.yandex.YandexApi.models.message.MessageCommonFields;
import com.yandex.YandexApi.models.message.MessageForResponse;
import com.yandex.YandexApi.models.user.User;
import com.yandex.YandexApi.models.user.UserCommonFields;
import com.yandex.YandexApi.repositories.ChatRepository;
import com.yandex.YandexApi.repositories.MessageRepository;
import com.yandex.YandexApi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.ConnectException;
import java.util.ArrayList;

public class ProxyChatService implements IChatService {

    private ChatRepository chatRepository;
    private MessageRepository messageRepository;
    private UserRepository userRepository;

    @Autowired
    public ProxyChatService (ChatRepository chatRepository, MessageRepository messageRepository, UserRepository userRepository){
        this.chatRepository = chatRepository;
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Chat getChatById(String id) throws ConnectException {
        throw new ConnectException();
    }

    @Override
    public Chat createChat(ChatCommonFields chatCommonFields) throws ConnectException {
        throw new ConnectException();
    }

    @Override
    public User joinUser(String chatId, UserCommonFields userCommonFields) throws ConnectException {
        throw new ConnectException();
    }

    @Override
    public Message addMessage(String chatId, MessageCommonFields messageCommonFields, String userId) throws ConnectException {
        throw new ConnectException();
    };

    @Override
    public ArrayList<MessageForResponse> getMessages(String chatId, int limit, Cursor from) throws ConnectException {
        throw new ConnectException();
    }

}
