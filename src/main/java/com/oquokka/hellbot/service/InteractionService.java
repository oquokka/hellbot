package com.oquokka.hellbot.service;

import com.oquokka.hellbot.model.Interaction;
import com.oquokka.hellbot.model.InteractionData;
import com.oquokka.hellbot.model.Mentions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class InteractionService {

    @Value("${discord.id}")
    private String applicationId;

    @Value("${discord.key}")
    private String applicationKey;

    public Interaction interact() {
        return new Interaction(4, new InteractionData(false, "Congrats on sending your command!", emptyList(), new Mentions(emptyList())));
    }

}
