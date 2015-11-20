package net.mammothmkiv.testchat.common;

import java.io.Serializable;

/**
 * Created by n.rogovoy on 11/13/2015.
 */
public class ChatMessage implements Serializable {
    public UserDescriptor sender;
    public String text;

    public ChatMessage(UserDescriptor sender, String message) {
        this.sender = sender;
        this.text = message;
    }
}
