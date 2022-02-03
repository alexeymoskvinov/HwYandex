package com.yandex.YandexApi.models.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yandex.YandexApi.models.message.Message;
import com.yandex.YandexApi.models.user.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Entity
@Table(name = "Chats")
public class Chat {

    @Getter
    @Setter
    @JsonProperty("chat_name")
    @Length(min = 1, max = 255, message = "Wrong name format")
    protected String name;

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    public String getId(){
//        return this.id.toString();
//    }

    @Getter
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_chats_link",
            joinColumns = @JoinColumn(name = "chat_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Map<String, User> users;

    @Getter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chat")
    private List<Message> messages;


    public Chat(String name){
        this.name = name;
        this.users = new HashMap<>();
        this.messages = new ArrayList<>();
    }

    public Chat() {
        this.users = new HashMap<>();
        this.messages = new ArrayList<>();
    }

    public User addUser(User user){
        users.put(user.getId().toString(),user);
        return user;
    }

    public Message addMessage(Message message){
        messages.add(message);
        return  message;
    }

}
