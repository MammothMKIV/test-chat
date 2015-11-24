package net.mammothmkiv.testchat.server;

import net.mammothmkiv.testchat.common.*;
import net.mammothmkiv.testchat.common.events.UserLogoutEvent;
import net.mammothmkiv.testchat.common.packets.LoginRequestPacket;
import net.mammothmkiv.testchat.common.packets.LoginResponsePacket;
import net.mammothmkiv.testchat.server.authenticators.IAuthenticator;
import net.mammothmkiv.testchat.server.exceptions.ConcurrentConnectionException;
import net.mammothmkiv.testchat.server.exceptions.IncorrectPacketSequenceException;
import net.mammothmkiv.testchat.common.UserAuthenticationException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerClientHandler extends Thread {

    private UserConnection connection;
    private IAuthenticator authenticator;
    private ObjectOutputStream os;

    public ServerClientHandler(UserConnection connection, IAuthenticator authenticator)
    {
        this.connection = connection;
        this.authenticator = authenticator;
    }

    public void run()
    {
        try {
            Socket client = connection.socket;

            client.setSoTimeout(2000);

            ObjectInputStream is = new ObjectInputStream(client.getInputStream());
            os = new ObjectOutputStream(client.getOutputStream());

            Object loginRequest = is.readObject();

            if (!(loginRequest instanceof LoginRequestPacket)) {
                client.close();
                throw new IncorrectPacketSequenceException("Got wrong packet. Expected LoginRequestPacket.");
            }

            if (!authenticator.authenticate(new AuthenticationCredentials(((LoginRequestPacket)loginRequest).nickname))) {
                os.writeObject(new LoginResponsePacket("Incorrect login"));
                client.close();
                throw new UserAuthenticationException("Incorrect user login: " + ((LoginRequestPacket)loginRequest).nickname);
            }

            this.connection.signedIn = true;
            this.connection.id = ((LoginRequestPacket)loginRequest).nickname;

            try {
                ActiveUserRegistry.getInstance().register(this.connection);
            } catch (ConcurrentConnectionException e) {
                os.writeObject(new LoginResponsePacket("User already connected"));
                client.close();
                throw e;
            }

            os.writeObject(new LoginResponsePacket(new UserDescriptor(this.connection.id, ((LoginRequestPacket)loginRequest).nickname), LoginResult.LOGIN_RESULT_SUCCESS, "Welcome"));

            client.setSoTimeout(0);

            try {
                while (true) {
                    Object obj = is.readObject();

                    ServerPacketBus.getInstance().post(new ClientMessage(obj, this, new UserDescriptor(connection.id, connection.id)));
                }
            } catch (Exception e) {
                ActiveUserRegistry.getInstance().unregister(this.connection.id);

            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        if (connection.isReady) {
            ServerEventBus.getInstance().post(new UserLogoutEvent(new UserDescriptor(connection.id, connection.id)));
        }

        System.out.println("Connection closed");
    }

    public void send(Object obj) throws IOException {
        os.writeObject(obj);
    }

}
