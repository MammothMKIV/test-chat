package net.mammothmkiv.testchat.server.authenticators;

import net.mammothmkiv.testchat.common.AuthenticationCredentials;

import java.util.ArrayList;

public class MemoryAuthenticator implements IAuthenticator {
    public void authenticate(AuthenticationCredentials credentials) throws AuthenticationException {
        ArrayList<String> allowedNicknames = new ArrayList() {{
            add("MammothMKIV");
            add("tester");
            add("admin");
        }};

        if (!allowedNicknames.contains(credentials.getNickname())) {
            throw new AuthenticationException("Invalid credentials");
        }
    }
}
