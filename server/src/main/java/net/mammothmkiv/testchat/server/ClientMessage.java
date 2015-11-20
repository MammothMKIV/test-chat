package net.mammothmkiv.testchat.server;

import net.mammothmkiv.testchat.common.UserDescriptor;

/**
 * Created by n.rogovoy on 11/12/2015.
 */
public class ClientMessage {
    public Object packet;
    public ServerClientHandler clientHandler;
    public UserDescriptor descriptor;

    public ClientMessage(Object packet, ServerClientHandler clientHandler, UserDescriptor descriptor) {
        this.packet = packet;
        this.clientHandler = clientHandler;
        this.descriptor = descriptor;
    }
}
