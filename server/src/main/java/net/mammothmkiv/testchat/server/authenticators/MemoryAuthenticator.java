package net.mammothmkiv.testchat.server.authenticators;

import net.mammothmkiv.testchat.common.AuthenticationCredentials;

import java.util.ArrayList;

/**
 * Created by n.rogovoy on 11/11/2015.
 */
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
