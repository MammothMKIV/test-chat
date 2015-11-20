package net.mammothmkiv.testchat.server;

import java.net.Socket;

/**
 * Created by n.rogovoy on 11/11/2015.
 */
public class UserConnection {
    public Socket socket = null;
    public String id = "";
    public Boolean signedIn = false;
    public Boolean isReady = false;
    public ServerClientHandler clientHandler;

    public UserConnection(Socket socket, String id, Boolean signedIn, Boolean isReady) {
        this.socket = socket;
        this.id = id;
        this.signedIn = signedIn;
        this.isReady = isReady;
    }
}
