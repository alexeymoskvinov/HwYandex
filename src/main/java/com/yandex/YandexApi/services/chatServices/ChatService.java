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
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.ConnectException;
import java.util.ArrayList;

public class ChatService implements IChatService {

    private ChatRepository chatRepository;
    private MessageRepository messageRepository;
    private UserRepository userRepository;

    @Autowired
    public ChatService (ChatRepository chatRepository, MessageRepository messageRepository, UserRepository userRepository){
        this.chatRepository = chatRepository;
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    public Chat getChatById(String id) {
        return chatRepository.getById(Long.parseLong(id));
    }

    @Override
    public Chat createChat(ChatCommonFields chatCommonFields) {
        Chat chat = new Chat(chatCommonFields.getName());
        chatRepository.save(chat);

        return chat;
    }

    @Override
    public User joinUser(String chatId, UserCommonFields userCommonFields) throws NotFoundException {
        if(!chatRepository.existsById(Long.parseLong(chatId))){
            throw new NotFoundException("Chat not found");
        }
        Chat chat = chatRepository.getById(Long.parseLong(chatId));
        User user = new User(userCommonFields.getName());
        userRepository.save(user);
        chat.addUser(user);
        return user;
    };

    @Override
    public Message addMessage(String chatId, MessageCommonFields messageCommonFields, String userId) throws NotFoundException {
        if(!chatRepository.existsById(Long.parseLong(chatId))){
            throw new NotFoundException("Chat not found");
        }
        if(!userRepository.existsById(Long.parseLong(userId))){
            throw new NotFoundException("User not found");
        }
        Chat chat = chatRepository.getById(Long.parseLong(chatId));
        User user = userRepository.getById(Long.parseLong(userId));

        Message message = new Message(messageCommonFields.getMessage(), user, chat);
        messageRepository.save(message);
        chat.addMessage(message);

        return message;

    };

    @Override
    public ArrayList<MessageForResponse> getMessages(String chatId, int limit, Cursor from) throws ConnectException, NotFoundException {
        ArrayList<MessageForResponse> messages = new ArrayList<>();

        if(!chatRepository.existsById(Long.parseLong(chatId))){
            throw new NotFoundException("Chat not found");
        }
        Chat chat = chatRepository.getById(Long.parseLong(chatId));

        int start = from != null ? Integer.parseInt(from.getFrom()) - 1 : 0;
        if (start == 0) {
            from = new Cursor();
            from.setFrom("1");
        }
        int end = start + limit;
        end = Math.min(end, chat.getMessages().size());

        for (int i = start; i < end; i++) {
            messages.add(new MessageForResponse(chat.getMessages().get(i).getMessage()));
        }

        return messages;

    }
}
