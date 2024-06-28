package com.oquokka.hellbot.event;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.user.update.UserUpdateActivitiesEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Slf4j
public class UserActivityEvent extends ListenerAdapter {

    @Override
    public void onUserUpdateActivities(UserUpdateActivitiesEvent event) {
        String user = event.getUser().getName();
        Activity activity = event.getNewValue().getFirst();
        log.info("{} has activities {}", user, activity);
    }

}
