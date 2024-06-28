package com.oquokka.hellbot.api;

import com.oquokka.hellbot.model.Interaction;
import com.oquokka.hellbot.service.InteractionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/interactions")
@AllArgsConstructor
public class InteractionController {

    private final InteractionService service;

    @PostMapping
    public ResponseEntity<Object> interactions() {
        Interaction response = service.interact();
        return ResponseEntity.ok(response);
    }

}
