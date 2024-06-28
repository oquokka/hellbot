package com.oquokka.hellbot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record InteractionData(boolean tts,
                              String content,
                              List<String> embeds,
                              @JsonProperty("allowed_mentions") Mentions allowedMentions) {
}
