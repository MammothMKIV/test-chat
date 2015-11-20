package net.mammothmkiv.testchat.common;

import java.io.Serializable;
import java.util.Hashtable;

/**
 * Created by n.rogovoy on 11/12/2015.
 */
public class MemberListResponsePacket implements Serializable {
    public Hashtable<String, UserDescriptor> members;

    public MemberListResponsePacket(Hashtable<String, UserDescriptor> members) {
        this.members = members;
    }
}
