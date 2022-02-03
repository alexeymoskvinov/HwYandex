package com.yandex.YandexApi.controllers;


import com.yandex.YandexApi.controllers.responses.DbResponse;
import com.yandex.YandexApi.controllers.responses.IResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping_db")
public class PingDbController {

    @GetMapping
    public ResponseEntity<IResponse> checkDbStatus(){
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
