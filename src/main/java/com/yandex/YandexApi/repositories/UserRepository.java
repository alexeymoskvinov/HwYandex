package com.yandex.YandexApi.repositories;

import com.yandex.YandexApi.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User, Long> { }
