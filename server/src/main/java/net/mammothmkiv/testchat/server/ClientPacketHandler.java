package net.mammothmkiv.testchat.server;


import com.google.common.eventbus.Subscribe;
import net.mammothmkiv.testchat.common.*;

import java.io.IOException;

public class ClientPacketHandler {

    @Subscribe public void handleTestPacket(ClientMessage message) {
        if (message.packet instanceof TestPacket) {
            System.out.println("Received TestPacket from client with value: " + ((TestPacket)message.packet).value);
            System.out.println("Client message: " + ((TestPacket)message.packet).message);
        }
    }

    @Subscribe public void handleMemberListRequestPacket(ClientMessage message) {
        if (message.packet instanceof MemberListRequestPacket) {
            try {
                ActiveUserRegistry.getInstance().getUserConnection(message.descriptor.id).isReady = true;
                ServerEventBus.getInstance().post(new UserLoginEvent(message.descriptor));
                message.clientHandler.send(new MemberListResponsePacket(ActiveUserRegistry.getInstance().getActiveUserDescriptors()));
            } catch (IOException e) {
                System.out.println("Failed to send client list");
            }
        }
    }

    @Subscribe public void handleUserMessagePacket(ClientMessage message) {
        if (message.packet instanceof UserMessagePacket) {
            ChatMessage msg = new ChatMessage(message.descriptor, ((UserMessagePacket) message.packet).message.text);
            ServerEventBus.getInstance().post(new UserMessageEvent(msg));
        }
    }
}
