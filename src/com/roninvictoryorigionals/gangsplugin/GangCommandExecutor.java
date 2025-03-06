package com.roninvictoryorigionals.gangsplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GangCommandExecutor implements CommandExecutor {

    private final GangsPlugin plugin;

    public GangCommandExecutor(GangsPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return false;
        }

        Player player = (Player) sender;

        // /gang create [name] - Create a new gang
        if (cmd.getName().equalsIgnoreCase("gang") && args.length == 2 && args[0].equalsIgnoreCase("create")) {
            String gangName = args[1];
            plugin.createGang(player, gangName);
            return true;
        }

        // /gang invite [player] - Only the gang owner can invite
        if (cmd.getName().equalsIgnoreCase("gang") && args.length == 2 && args[0].equalsIgnoreCase("invite")) {
            String inviteeName = args[1];
            Player invitee = player.getServer().getPlayer(inviteeName);

            if (invitee == null) {
                player.sendMessage("Player " + inviteeName + " is not online.");
                return false;
            }

            String gangName = "GangName"; // Replace with actual gang name retrieval logic
            if (plugin.isGangOwner(player, gangName)) {
                return plugin.invitePlayerToGang(player, invitee, gangName);
            } else {
                player.sendMessage("You must be the owner of the gang to invite players.");
                return false;
            }
        }

        // /gang accept [gang] - Accept a gang invite
        if (args.length == 2 && args[0].equalsIgnoreCase("accept")) {
            String gangName = args[1];
            return plugin.acceptInvite(player);
        }

        // /gang deny [gang] - Deny a gang invite
        if (args.length == 2 && args[0].equalsIgnoreCase("deny")) {
            String gangName = args[1];
            return plugin.denyInvite(player);
        }

        return false;
    }
}
