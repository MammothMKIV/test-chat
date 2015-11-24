package net.mammothmkiv.testchat.server;

import net.mammothmkiv.testchat.common.UserDescriptor;

/**
 * Created by n.rogovoy on 11/12/2015.
 */
public class ClientMessage {
    private Object packet;
    private ServerClientHandler clientHandler;
    private UserDescriptor descriptor;

    public ClientMessage(Object packet, ServerClientHandler clientHandler, UserDescriptor descriptor) {
        this.packet = packet;
        this.clientHandler = clientHandler;
        this.descriptor = descriptor;
    }

    public Object getPacket() {
        return packet;
    }

    public void setPacket(Object packet) {
        this.packet = packet;
    }

    public ServerClientHandler getClientHandler() {
        return clientHandler;
    }

    public void setClientHandler(ServerClientHandler clientHandler) {
        this.clientHandler = clientHandler;
    }

    public UserDescriptor getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(UserDescriptor descriptor) {
        this.descriptor = descriptor;
    }
}
