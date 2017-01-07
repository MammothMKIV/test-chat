package net.mammothmkiv.testchat.common.events;

import net.mammothmkiv.testchat.common.ChatMessage;

public class UserMessageEvent {
    private ChatMessage message;

    public UserMessageEvent(ChatMessage message) {
        this.message = message;
    }

    public ChatMessage getMessage() {
        return message;
    }

    public void setMessage(ChatMessage message) {
        this.message = message;
    }
}
