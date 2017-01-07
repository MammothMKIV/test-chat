package net.mammothmkiv.testchat.common.packets;

import net.mammothmkiv.testchat.common.ChatMessage;

import java.io.Serializable;

public class UserMessagePacket implements Serializable {
    private ChatMessage message;

    public UserMessagePacket(ChatMessage message) {
        this.message = message;
    }

    public ChatMessage getMessage() {
        return message;
    }

    public void setMessage(ChatMessage message) {
        this.message = message;
    }
}
