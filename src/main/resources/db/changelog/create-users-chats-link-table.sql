create table users_chats_link
(
    chat_id   bigint       not null,
    user_id   bigint       not null,
    users_key varchar(255) not null,
    primary key (chat_id, users_key)
);

alter table if exists users_chats_link
    add constraint FKre4x58jbp8pn0khxj3a4y3g5h
        foreign key (user_id)
            references users;

alter table if exists users_chats_link
    add constraint FK4oo4w6uvaii600r0nf9f56v5g
        foreign key (chat_id)
            references chats;