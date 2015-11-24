package net.mammothmkiv.testchat.common.packets;

import net.mammothmkiv.testchat.common.UserDescriptor;

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
