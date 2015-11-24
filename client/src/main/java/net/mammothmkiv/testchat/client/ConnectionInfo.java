package net.mammothmkiv.testchat.client;

import java.net.Socket;

/**
 * Created by n.rogovoy on 11/11/2015.
 */
public class ConnectionInfo {
    private Socket connection = null;
    private Boolean isSignedIn = false;
    private Boolean isConnected = false;

    public Socket getConnection() {
        return connection;
    }

    public void setConnection(Socket connection) {
        this.connection = connection;
    }

    public Boolean getSignedIn() {
        return isSignedIn;
    }

    public void setSignedIn(Boolean signedIn) {
        isSignedIn = signedIn;
    }

    public Boolean getConnected() {
        return isConnected;
    }

    public void setConnected(Boolean connected) {
        isConnected = connected;
    }
}
