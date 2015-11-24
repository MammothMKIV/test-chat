package net.mammothmkiv.testchat.common.packets;

import net.mammothmkiv.testchat.common.LoginResult;
import net.mammothmkiv.testchat.common.UserDescriptor;

import java.io.Serializable;

/**
 * Created by n.rogovoy on 11/10/2015.
 */
public class LoginResponsePacket implements Serializable {
    public LoginResult result;
    public String message = "";
    public UserDescriptor descriptor;

    public LoginResponsePacket(UserDescriptor descriptor, LoginResult result, String message) {
        this.descriptor = descriptor;
        this.result = result;
        this.message = message;
    }

    public LoginResponsePacket(UserDescriptor descriptor, LoginResult result) {
        this.descriptor = descriptor;
        this.result = result;
    }

    public LoginResponsePacket(String message) {
        this.message = message;
        this.result = LoginResult.LOGIN_RESULT_FAIL;
    }
}
