package net.mammothmkiv.testchat.client;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import net.mammothmkiv.testchat.client.events.LoginSuccessEvent;
import net.mammothmkiv.testchat.client.handlers.ServerPacketHandler;
import net.mammothmkiv.testchat.common.*;
import net.mammothmkiv.testchat.common.events.UserMessageEvent;
import net.mammothmkiv.testchat.common.packets.LoginRequestPacket;
import net.mammothmkiv.testchat.common.packets.MemberListRequestPacket;
import net.mammothmkiv.testchat.common.packets.UserMessagePacket;

import java.io.IOException;

/**
 * Created by n.rogovoy on 11/11/2015.
 */
public class ChatCore {
    private static ChatCore instance = new ChatCore();

    public static ChatCore getInstance() {
        return instance;
    }

    private EventBus chatBus = new EventBus();
    private ContactList contactList = new ContactList(chatBus);
    private UserDescriptor currentUser;
    private MessageLog globalChatLog = new MessageLog();

    private ServerConnectionHandler connectionHandler = new ServerConnectionHandler();

    private ChatCore() {
        connectionHandler.registerPacketHandler(new ServerPacketHandler(chatBus));
        registerEventHandler(this);
        registerEventHandler(contactList);
    }

    public void registerEventHandler(Object obj) {
        chatBus.register(obj);
    }

    public void unregisterEventHandler(Object obj) {
        chatBus.unregister(obj);
    }

    public void login(AuthenticationCredentials credentials) throws UserAuthenticationException {
        try {
            connectionHandler.connect();
            connectionHandler.send(new LoginRequestPacket(credentials.getNickname()));
        } catch (Exception e) {
            throw new UserAuthenticationException("Failed to establish connection with server.");
        }
    }

    public void sendChatMessage(String message) {
        ChatMessage msg = new ChatMessage(currentUser, message);

        try {
            connectionHandler.send(new UserMessagePacket(msg));
        } catch (IOException e) {
            System.out.println("Failed to send user message");
        }
    }

    public Boolean isLoggedIn() {
        return this.currentUser != null;
    }

    @Subscribe public void onLoginSuccess(LoginSuccessEvent e) {
        this.currentUser = e.getDescriptor();
    }

    public void requestMemberList() {
        try {
            connectionHandler.send(new MemberListRequestPacket());
        } catch (IOException ex) {
            System.out.println("Failed to request member list");
        }
    }

    @Subscribe public void handleUserMessageEvent(UserMessageEvent e) {
        globalChatLog.pushMessage(e.getMessage());
    }
}
