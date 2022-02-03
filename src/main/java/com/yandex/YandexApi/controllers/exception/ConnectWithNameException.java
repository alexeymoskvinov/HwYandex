package com.yandex.YandexApi.controllers.exception;

import com.yandex.YandexApi.models.AnswerForUser;
import com.yandex.YandexApi.models.user.DBUser;
import lombok.Getter;

import java.net.ConnectException;
import java.util.List;

public class ConnectWithNameException extends ConnectException {

    @Getter
    private List<DBUser> users;

    @Getter
    private String userId;

    public ConnectWithNameException(List<DBUser> users, String userId){
        super(new AnswerForUser().getAnswerForUser(users, userId));

    }
}
