package com.yandex.YandexApi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class Cursor {
    @Getter @Setter
    @JsonProperty("from")
    protected String from;

}
