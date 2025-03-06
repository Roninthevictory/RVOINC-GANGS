package com.roninvictoryorigionals.gangsplugin;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GangsPlugin extends JavaPlugin {

    private final Map<String, Gang> gangs = new HashMap<>(); // Store gangs by name
    private final HashMap<UUID, String> pendingInvites = new HashMap<>(); // Pending invites

    @Override
    public void onEnable() {
        // Register the command executor
        getCommand("gang").setExecutor(new GangCommandExecutor(this));
    }

    public void createGang(Player player, String gangName) {
        if (gangs.containsKey(gangName)) {
            player.sendMessage("A gang with this name already exists.");
        } else {
            Gang newGang = new Gang(gangName, player.getUniqueId());
            gangs.put(gangName, newGang);
            player.sendMessage("You have created the gang: " + gangName);
        }
    }

    public boolean isGangOwner(Player player, String gangName) {
        Gang gang = gangs.get(gangName);
        return gang != null && gang.isOwner(player.getUniqueId());
    }

    public boolean invitePlayerToGang(Player inviter, Player invitee, String gangName) {
        Gang gang = gangs.get(gangName);
        if (gang == null) {
            inviter.sendMessage("This gang does not exist.");
            return false;
        }

        if (!isGangOwner(inviter, gangName)) {
            inviter.sendMessage("You must be the owner to invite players.");
            return false;
        }

        // Store the invite and send a message to the invitee
        pendingInvites.put(invitee.getUniqueId(), gangName);
        invitee.sendMessage("You have been invited to join the gang " + gangName + ". Use /gang accept " + gangName + " to join, or /gang deny to reject.");
        return true;
    }

    public boolean acceptInvite(Player player) {
        String gangName = pendingInvites.get(player.getUniqueId());
        if (gangName != null) {
            Gang gang = gangs.get(gangName);
            if (gang != null) {
                gang.addMember(player.getUniqueId(), "member"); // Add player to the gang as a member
                pendingInvites.remove(player.getUniqueId());
                player.sendMessage("You have successfully joined the gang " + gangName + ".");
                return true;
            }
        }
        player.sendMessage("You do not have any pending invites.");
        return false;
    }

    public boolean denyInvite(Player player) {
        String gangName = pendingInvites.remove(player.getUniqueId());
        if (gangName != null) {
            player.sendMessage("You have denied the invitation to join the gang " + gangName + ".");
            return true;
        }
        player.sendMessage("You do not have any pending invites.");
        return false;
    }
}
