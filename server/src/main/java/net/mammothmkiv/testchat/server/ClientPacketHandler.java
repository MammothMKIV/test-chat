package net.mammothmkiv.testchat.server;


import com.google.common.eventbus.Subscribe;
import net.mammothmkiv.testchat.common.*;
import net.mammothmkiv.testchat.common.events.UserLoginEvent;
import net.mammothmkiv.testchat.common.events.UserMessageEvent;
import net.mammothmkiv.testchat.common.packets.MemberListRequestPacket;
import net.mammothmkiv.testchat.common.packets.MemberListResponsePacket;
import net.mammothmkiv.testchat.common.packets.TestPacket;
import net.mammothmkiv.testchat.common.packets.UserMessagePacket;

import java.io.IOException;

public class ClientPacketHandler {

    @Subscribe public void handleTestPacket(ClientMessage message) {
        if (message.getPacket() instanceof TestPacket) {
            System.out.println("Received TestPacket from client with value: " + ((TestPacket)message.getPacket()).value);
            System.out.println("Client message: " + ((TestPacket)message.getPacket()).message);
        }
    }

    @Subscribe public void handleMemberListRequestPacket(ClientMessage message) {
        if (message.getPacket() instanceof MemberListRequestPacket) {
            try {
                ActiveUserRegistry.getInstance().getUserConnection(message.getDescriptor().id).setReady(true);
                ServerEventBus.getInstance().post(new UserLoginEvent(message.getDescriptor()));
                message.getClientHandler().send(new MemberListResponsePacket(ActiveUserRegistry.getInstance().getActiveUserDescriptors()));
            } catch (IOException e) {
                System.out.println("Failed to send client list");
            }
        }
    }

    @Subscribe public void handleUserMessagePacket(ClientMessage message) {
        if (message.getPacket() instanceof UserMessagePacket) {
            ChatMessage msg = new ChatMessage(message.getDescriptor(), ((UserMessagePacket) message.getPacket()).message.text);
            ServerEventBus.getInstance().post(new UserMessageEvent(msg));
        }
    }
}
