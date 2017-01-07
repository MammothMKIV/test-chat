package net.mammothmkiv.testchat.client.handlers;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import net.mammothmkiv.testchat.client.events.LoginFailedEvent;
import net.mammothmkiv.testchat.client.events.LoginSuccessEvent;
import net.mammothmkiv.testchat.client.events.MemberListLoadEvent;
import net.mammothmkiv.testchat.common.events.UserLoginEvent;
import net.mammothmkiv.testchat.common.events.UserLogoutEvent;
import net.mammothmkiv.testchat.common.events.UserMessageEvent;
import net.mammothmkiv.testchat.common.packets.*;

public class ServerPacketHandler {

    private EventBus chatBus;

    public ServerPacketHandler(EventBus chatBus) {
        this.chatBus = chatBus;
    }

    @Subscribe public void handleLoginResponsePacket(LoginResponsePacket e) {
        switch (e.getResult()) {
            case LOGIN_RESULT_FAIL:
                chatBus.post(new LoginFailedEvent(e.getMessage()));
                break;
            case LOGIN_RESULT_SUCCESS:
                chatBus.post(new LoginSuccessEvent(e.getDescriptor()));
                break;
            default:
                System.out.println("Invalid server login status response");
        }
    }

    @Subscribe public void handleMemberListResponsePacket(MemberListResponsePacket e) {
        chatBus.post(new MemberListLoadEvent(e.getMembers()));
    }

    @Subscribe public void handleUserLoginNotificationPacket(UserLoginNotificationPacket e) {
        chatBus.post(new UserLoginEvent(e.getDescriptor()));
    }

    @Subscribe public void handleUserLogoutNotificationPacket(UserLogoutNotificationPacket e) {
        chatBus.post(new UserLogoutEvent(e.getDescriptor()));
    }

    @Subscribe public void handleUserMessagePacket(UserMessagePacket e) {
        chatBus.post(new UserMessageEvent(e.getMessage()));
    }

}
