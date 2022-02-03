package com.yandex.YandexApi.services.userServices;


import com.yandex.YandexApi.models.user.DBUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserInformationService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserInformationService(){
        this.jdbcTemplate = new JdbcTemplate();
    }

    public List<DBUser> getUsers(){
        List users = jdbcTemplate.query("SELECT id, name, time FROM users_information", new UserRowMapperService());
        return users;
    }



}
