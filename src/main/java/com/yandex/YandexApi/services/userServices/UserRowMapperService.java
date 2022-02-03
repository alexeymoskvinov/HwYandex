package com.yandex.YandexApi.services.userServices;

import com.yandex.YandexApi.models.user.DBUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapperService implements RowMapper {

    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        DBUser user = new DBUser();
        user.setId(resultSet.getString("id"));
        user.setName(resultSet.getString("name"));
        user.setTime(resultSet.getString("time"));
        return user;
    }
}
