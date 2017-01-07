package net.mammothmkiv.testchat.server;

import net.mammothmkiv.testchat.common.UserDescriptor;
import net.mammothmkiv.testchat.server.exceptions.ConcurrentConnectionException;

import java.util.Hashtable;
import java.util.Map;
import java.util.stream.Collectors;

public class ActiveUserRegistry {
    private static Hashtable<String, UserConnection> connections = new Hashtable<>();
    private static ActiveUserRegistry instance = new ActiveUserRegistry();

    private ActiveUserRegistry() {

    }

    public static ActiveUserRegistry getInstance() {
        return instance;
    }

    public void register(UserConnection connection) throws ConcurrentConnectionException
    {
        if (connections.containsKey(connection.getId())) {
            throw new ConcurrentConnectionException("User already connected");
        }

        connections.put(connection.getId(), connection);
    }

    public void unregister(String id)
    {
        connections.remove(id);
    }

    public Hashtable<String, UserDescriptor> getActiveUserDescriptors() {
        Hashtable<String, UserDescriptor> users = new Hashtable<>();

        connections.forEach((id, connection) -> {
            if (connection.getSignedIn()) {
                users.put(id, new UserDescriptor(id, id));
            }
        });

        return users;
    }

    public Map<String, UserConnection> getActiveUsers() {
        return connections.entrySet()
                .stream()
                .filter((item) -> item.getValue().getReady() )
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public UserConnection getUserConnection(String id) {
        return connections.get(id);
    }
}
