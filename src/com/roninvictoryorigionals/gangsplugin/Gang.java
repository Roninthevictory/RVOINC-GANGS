package com.roninvictoryorigionals.gangsplugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Gang {

    private final String name;
    private final UUID owner;
    private final Map<UUID, String> members; // Map of UUID to role (owner, officer, member)

    public Gang(String name, UUID owner) {
        this.name = name;
        this.owner = owner;
        this.members = new HashMap<>();
        this.members.put(owner, "owner"); // Add owner by default
    }

    public String getName() {
        return name;
    }

    public UUID getOwner() {
        return owner;
    }

    public Map<UUID, String> getMembers() {
        return members;
    }

    public boolean isMember(UUID playerUUID) {
        return members.containsKey(playerUUID);
    }

    public boolean isOwner(UUID playerUUID) {
        return owner.equals(playerUUID);
    }

    public void addMember(UUID playerUUID, String role) {
        members.put(playerUUID, role);
    }

    public void removeMember(UUID playerUUID) {
        members.remove(playerUUID);
    }
}
