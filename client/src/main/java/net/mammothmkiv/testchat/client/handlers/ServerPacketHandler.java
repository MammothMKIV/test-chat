package net.mammothmkiv.testchat.client.handlers;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import net.mammothmkiv.testchat.client.events.LoginFailedEvent;
import net.mammothmkiv.testchat.client.events.LoginSuccessEvent;
import net.mammothmkiv.testchat.client.events.MemberListLoadEvent;
import net.mammothmkiv.testchat.common.*;

/**
 * Created by n.rogovoy on 11/11/2015.
 */
public class ServerPacketHandler {

    private EventBus chatBus;

    public ServerPacketHandler(EventBus chatBus) {
        this.chatBus = chatBus;
    }

    @Subscribe public void handleLoginResponsePacket(LoginResponsePacket e) {
        switch (e.result) {
            case LOGIN_RESULT_FAIL:
                chatBus.post(new LoginFailedEvent(e.message));
                break;
            case LOGIN_RESULT_SUCCESS:
                chatBus.post(new LoginSuccessEvent(e.descriptor));
                break;
            default:
                System.out.println("Invalid server login status response");
        }
    }

    @Subscribe public void handleMemberListResponsePacket(MemberListResponsePacket e) {
        chatBus.post(new MemberListLoadEvent(e.members));
    }

    @Subscribe public void handleUserLoginNotificationPacket(UserLoginNotificationPacket e) {
        chatBus.post(new UserLoginEvent(e.descriptor));
    }

    @Subscribe public void handleUserLogoutNotificationPacket(UserLogoutNotificationPacket e) {
        chatBus.post(new UserLogoutEvent(e.descriptor));
    }

    @Subscribe public void handleUserMessagePacket(UserMessagePacket e) {
        chatBus.post(new UserMessageEvent(e.message));
    }

}
