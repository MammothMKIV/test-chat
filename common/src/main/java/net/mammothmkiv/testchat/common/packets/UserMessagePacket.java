package net.mammothmkiv.testchat.common.packets;

import net.mammothmkiv.testchat.common.ChatMessage;

import java.io.Serializable;

/**
 * Created by n.rogovoy on 11/13/2015.
 */
public class UserMessagePacket implements Serializable {
    public ChatMessage message;

    public UserMessagePacket(ChatMessage message) {
        this.message = message;
    }
}