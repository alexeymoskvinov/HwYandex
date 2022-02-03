package com.yandex.YandexApi.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

public class UserCommonFields {
    @Getter
    @Setter
    @Length(min = 1, max = 255, message = "Wrong name format")
    @JsonProperty("user_name")
    @Column(name = "name")
    protected String name;
}
