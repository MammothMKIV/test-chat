package net.mammothmkiv.testchat.common.packets;

import net.mammothmkiv.testchat.common.UserDescriptor;

import java.io.Serializable;
import java.util.Hashtable;

public class MemberListResponsePacket implements Serializable {
    private Hashtable<String, UserDescriptor> members;

    public MemberListResponsePacket(Hashtable<String, UserDescriptor> members) {
        this.members = members;
    }

    public Hashtable<String, UserDescriptor> getMembers() {
        return members;
    }

    public void setMembers(Hashtable<String, UserDescriptor> members) {
        this.members = members;
    }
}
