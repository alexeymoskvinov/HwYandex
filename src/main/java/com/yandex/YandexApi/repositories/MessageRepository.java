package com.yandex.YandexApi.repositories;

import com.yandex.YandexApi.models.message.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> { }
