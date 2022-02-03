package com.yandex.YandexApi.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yandex.YandexApi.controllers.exception.ConnectWithNameException;
import com.yandex.YandexApi.controllers.responses.*;
import com.yandex.YandexApi.models.Cursor;
import com.yandex.YandexApi.models.chat.Chat;
import com.yandex.YandexApi.models.chat.ChatCommonFields;
import com.yandex.YandexApi.models.message.Message;
import com.yandex.YandexApi.models.message.MessageCommonFields;
import com.yandex.YandexApi.models.message.MessageForResponse;
import com.yandex.YandexApi.models.user.DBUser;
import com.yandex.YandexApi.models.user.User;
import com.yandex.YandexApi.models.user.UserCommonFields;
import com.yandex.YandexApi.services.chatServices.IChatService;
import com.yandex.YandexApi.services.userServices.UserInformationService;
import javassist.NotFoundException;
import lombok.SneakyThrows;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("v1/chats")
@EnableCaching
public class ChatsController {

    IChatService chatService;

    @Autowired
    public ChatsController(IChatService iChatService){
        this.chatService = iChatService;
    }

    public ChatsController(UserInformationService userInformationService) {
        this.userInformationService = userInformationService;
        this.users = userInformationService.getUsers();
    }
    UserInformationService userInformationService;
    List<DBUser> users;

    @PostMapping("/hhh")
    public ResponseEntity<IResponse> kapusta(@Valid @RequestBody String chatCommonFields){
        return new ResponseEntity<>(new DefaultErrorResponse(chatCommonFields),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<IResponse> createChat(
            @Valid
            @RequestBody
            @JsonProperty("chat_name")
            ChatCommonFields body) throws ConnectException {

        Chat chat = chatService.createChat(body);
        return new ResponseEntity<>(new ChatCreateResponse(chat.getId().toString()), HttpStatus.OK);

    }

    @PostMapping("/{id}/users")
    public ResponseEntity<IResponse> joinUser(
            @PathVariable("id")
            String id,
            @Valid
            @RequestBody
            UserCommonFields body) throws ConnectException, NotFoundException {

        User user = chatService.joinUser(id,body);

        return new ResponseEntity<>(new ChatJoinResponse(user.getId().toString()), HttpStatus.OK);
    }

    @SneakyThrows
    @PostMapping("/{chat_id}/messages")
    public ResponseEntity<IResponse> addMessage(
            @PathVariable("chat_id")
            String chatId,
            @RequestBody
            MessageCommonFields body,
            @RequestParam("user_id")
            String userId)  {

        Message message = chatService.addMessage(chatId, body, userId);

        return new ResponseEntity<>(new ChatSendMessageResponse(message.getId().toString()), HttpStatus.OK);

    }


    @GetMapping("/{chat_id}/messages")
    @Cacheable(cacheNames = "cursor")
    public ResponseEntity<IResponse> getMessages(
            @PathVariable("chat_id")
            String chatId,
            @RequestParam
            @Valid
            @Length(min = 1, max = 1000, message = "Bad parameters")
            Integer limit,
            @Nullable
            @RequestBody
            Cursor from) throws ConnectWithNameException, ConnectException, NotFoundException {

        ArrayList<MessageForResponse> messages = chatService.getMessages(chatId,limit,from);

        return new ResponseEntity<>(new ChatGetMessagesResponse(messages, from), HttpStatus.OK);

    }

    @GetMapping("/ping_db")
    public ResponseEntity<IResponse> checkDbStatus(){
        return new ResponseEntity<>(HttpStatus.OK);
    }



//    @GetMapping("DbState/connected")
//    public ResponseEntity<DefaultErrorResponse> connectDb(){
//        chatService = DatabaseService.DatabaseState.CONNECTED.getChatService();
//        return new ResponseEntity<>(new DefaultErrorResponse("Connected"),HttpStatus.OK);
//    }
//
//    @GetMapping("DbState/disconnected")
//    public ResponseEntity<DefaultErrorResponse> disconnectDb(){
//        chatService = DatabaseService.DatabaseState.DISCONNECTED.getChatService();
//        return new ResponseEntity<>(new DefaultErrorResponse("Disconnected"),HttpStatus.OK);
//    }
}

