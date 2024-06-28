package com.oquokka.hellbot.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/interactions")
public class BotController {

    @Value("${discord.id}")
    private String applicationId;

    @Value("${discord.key}")
    private String applicationKey;

    @PostMapping
    public ResponseEntity<Object> interactions() {
        return ResponseEntity.ok().build();
    }

}
