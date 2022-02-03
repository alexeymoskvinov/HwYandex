package com.yandex.YandexApi.models;

import com.yandex.YandexApi.models.user.DBUser;

import java.util.List;

public class AnswerForUser {
    public String getAnswerForUser(List<DBUser> users, String user_id ){

        StringBuilder message = new StringBuilder();

        for (DBUser user : users){
            if (user.getId().equals(user_id)){
                int time = Integer.parseInt(user.getTime().substring(0,2));
                if(time > 5 && time < 12)
                    message = new StringBuilder("Good morning." + user.getName() + ". The server is unavailable now.");
                else if (time < 17)
                    message = new StringBuilder("Good afternoon," + user.getName() + ". The server is unavailable now.");
                else
                    message = new StringBuilder("Good evening," + user.getName() + ". The server is unavailable now.");
            }
        }
        if (message.length() < 1){
            message = new StringBuilder("The server is unavailable now.");
        }
        return message.toString();
    }
}
