package com.yandex.YandexApi.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yandex.YandexApi.models.chat.Chat;
import com.yandex.YandexApi.models.message.Message;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Entity(name = "users")
public class User {
    private static final AtomicLong idCounter = new AtomicLong();


    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Length(min = 1, max = 255, message = "Wrong name format")
    @JsonProperty("user_name")
    @Column(name = "name")
    protected String name;

//    public String getId(){
//        return this.id.toString();
//    }

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private List<Chat> chats = new ArrayList<>();

    @Getter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private final List<Message> messages = new LinkedList<>();


    public User(String name){
        this.name = name;
    }


    public User() {
    }
}
