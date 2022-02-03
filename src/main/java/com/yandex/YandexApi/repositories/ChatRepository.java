package com.yandex.YandexApi.repositories;

import com.yandex.YandexApi.models.chat.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> { }
