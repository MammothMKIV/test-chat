package net.mammothmkiv.testchat.server.authenticators;

import net.mammothmkiv.testchat.common.AuthenticationCredentials;

import java.util.ArrayList;

/**
 * Created by n.rogovoy on 11/11/2015.
 */
public class MemoryAuthenticator implements IAuthenticator {
    public Boolean authenticate(AuthenticationCredentials credentials) {
        ArrayList<String> allowedNicknames = new ArrayList() {{
            add("MammothMKIV");
            add("tester");
            add("admin");
        }};

        return allowedNicknames.contains(credentials.nickname);
    }
}
