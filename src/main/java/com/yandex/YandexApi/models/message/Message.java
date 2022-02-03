package com.yandex.YandexApi.models.message;

import com.yandex.YandexApi.models.chat.Chat;
import com.yandex.YandexApi.models.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Messages")
public class Message {

    @Getter
    @Setter
    @Column(name = "message")
    protected String message;

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "userId")
    protected User user;

    @ManyToOne
    @JoinColumn(name = "chatId")
    private Chat chat;

    public Message(String message, User user, Chat chat) {
        this.message = message;
        this.user = user;
        this.chat = chat;
    }

    public Message() {
    }
}
