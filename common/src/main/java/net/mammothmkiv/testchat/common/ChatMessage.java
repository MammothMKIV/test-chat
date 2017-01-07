package net.mammothmkiv.testchat.common;

import java.io.Serializable;

public class ChatMessage implements Serializable {
    private UserDescriptor sender;
    private String text;

    public ChatMessage(UserDescriptor sender, String message) {
        this.sender = sender;
        this.text = message;
    }

    public UserDescriptor getSender() {
        return sender;
    }

    public void setSender(UserDescriptor sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
