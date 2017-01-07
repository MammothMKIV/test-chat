package net.mammothmkiv.testchat.server;

import java.net.Socket;

public class UserConnection {
    private Socket socket = null;
    private String id = "";
    private Boolean signedIn = false;
    private Boolean isReady = false;
    private ServerClientHandler clientHandler;

    public UserConnection(Socket socket, String id, Boolean signedIn, Boolean isReady) {
        this.socket = socket;
        this.id = id;
        this.signedIn = signedIn;
        this.isReady = isReady;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getSignedIn() {
        return signedIn;
    }

    public void setSignedIn(Boolean signedIn) {
        this.signedIn = signedIn;
    }

    public Boolean getReady() {
        return isReady;
    }

    public void setReady(Boolean ready) {
        isReady = ready;
    }

    public ServerClientHandler getClientHandler() {
        return clientHandler;
    }

    public void setClientHandler(ServerClientHandler clientHandler) {
        this.clientHandler = clientHandler;
    }
}
