package net.mammothmkiv.testchat.common.events;

import net.mammothmkiv.testchat.common.ChatMessage;

/**
 * Created by n.rogovoy on 11/13/2015.
 */
public class UserMessageEvent {
    public ChatMessage message;

    public UserMessageEvent(ChatMessage message) {
        this.message = message;
    }
}
