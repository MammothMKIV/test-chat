package net.mammothmkiv.testchat.server;

import net.mammothmkiv.testchat.server.authenticators.IAuthenticator;
import net.mammothmkiv.testchat.server.authenticators.MemoryAuthenticator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnectionListener extends Thread {

    public ServerConnectionListener()
    {
        super();

        this.setDaemon(false);
    }

    public void run()
    {
        try {
            ServerSocket server = new ServerSocket(25565);
            System.out.println("Waiting for clients...");
            IAuthenticator authenticator = new MemoryAuthenticator();

            while (true) {
                Socket client = server.accept();

                UserConnection userConnection = new UserConnection(client, "", false, false);

                ServerClientHandler clientHandler = new ServerClientHandler(userConnection, authenticator);

                userConnection.clientHandler = clientHandler;

                clientHandler.start();

                System.out.println("Client connected");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
