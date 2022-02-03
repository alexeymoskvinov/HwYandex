package com.yandex.YandexApi.services.chatServices;

import com.yandex.YandexApi.controllers.exception.ConnectWithNameException;
import com.yandex.YandexApi.models.Cursor;
import com.yandex.YandexApi.models.chat.Chat;
import com.yandex.YandexApi.models.chat.ChatCommonFields;
import com.yandex.YandexApi.models.message.Message;
import com.yandex.YandexApi.models.message.MessageCommonFields;
import com.yandex.YandexApi.models.message.MessageForResponse;
import com.yandex.YandexApi.models.user.User;
import com.yandex.YandexApi.models.user.UserCommonFields;
import javassist.NotFoundException;

import java.net.ConnectException;
import java.util.ArrayList;

public interface IChatService {
    Chat getChatById(String id) throws ConnectException, ConnectWithNameException;

    Chat createChat(ChatCommonFields chatCommonFields) throws ConnectException, ConnectWithNameException;

    User joinUser(String chatId, UserCommonFields userCommonFields) throws ConnectException, NotFoundException;

    Message addMessage(String chatId, MessageCommonFields messageCommonFields, String userId) throws ConnectException, NotFoundException;

    ArrayList<MessageForResponse> getMessages(String chatId, int limit, Cursor from) throws ConnectException, NotFoundException;
}
