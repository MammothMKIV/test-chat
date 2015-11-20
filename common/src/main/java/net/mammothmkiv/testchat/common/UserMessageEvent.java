package net.mammothmkiv.testchat.common;

/**
 * Created by n.rogovoy on 11/13/2015.
 */
public class UserMessageEvent {
    public ChatMessage message;

    public UserMessageEvent(ChatMessage message) {
        this.message = message;
    }
}
