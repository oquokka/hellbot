package com.oquokka.hellbot.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateActivitiesEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateOnlineStatusEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DiscordBotService extends ListenerAdapter {

    @Value("${discord.token}")
    private String botToken;

    @PostConstruct
    public void startBot() {
        JDABuilder.createDefault(botToken)
                .enableIntents(GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MEMBERS)
                .addEventListeners(this)
                .setActivity(Activity.watching("the server"))
                .build();
    }

    @Override
    public void onReady(ReadyEvent event) {
        log.info("Bot is ready!");
    }

    @Override
    public void onUserUpdateOnlineStatus(UserUpdateOnlineStatusEvent event) {
        if (event.getNewOnlineStatus() == OnlineStatus.ONLINE) {
            log.info("{} is online", event.getUser().getName());
        }
    }

    @Override
    public void onUserUpdateActivities(UserUpdateActivitiesEvent event) {
        String user = event.getUser().getName();
        Activity activity = event.getNewValue().getFirst();
        log.info("{} has activities {}", user, activity);
    }

    @Override
    public void onGuildVoiceUpdate(GuildVoiceUpdateEvent event) {
        String userName = event.getMember().getUser().getName();
        String channelName = event.getChannelJoined().getName();
        log.info("{} joined voice channel: {}", userName, channelName);
    }

}
