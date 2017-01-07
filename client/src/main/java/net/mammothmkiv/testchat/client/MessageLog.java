package net.mammothmkiv.testchat.client;

import net.mammothmkiv.testchat.common.ChatMessage;

import java.util.ArrayList;

public class MessageLog {
    private ArrayList<ChatMessage> log;

    public MessageLog() {
        log = new ArrayList<>();
    }

    public void pushMessage(ChatMessage msg) {
        log.add(msg);
    }

    public ArrayList<ChatMessage> getMessages() {
        return log;
    }
}
