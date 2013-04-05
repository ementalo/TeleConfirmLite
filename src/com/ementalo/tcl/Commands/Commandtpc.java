package com.ementalo.tcl.Commands;

import com.ementalo.tcl.*;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class Commandtpc implements ITclCommand {

    public void execute(Player player, Command command, String commandLabel, String[] args, TeleConfirmLite parent) {
        TpAction req = null;
        Player other = null;

        if (args.length != 1) {
            help(player, commandLabel);
            return;
        } else {
            List<Player> targets = parent.getMatchedPlayers(args[0]);

            if (targets.size() >= 1) {
                other = targets.get(0);
            } else {
                player.sendMessage(Config.playerNotFound.replace("%p", args[0]));
                return;
            }
        }

        if (Config.preventCrossWorldTp && !parent.tclUserHandler.worldCompare(player.getWorld(), other.getWorld())) {
            player.sendMessage(Config.requestWorlds);
            return;
        }

        if (!Config.isDebug) {
            if (other.getName().equalsIgnoreCase((player.getName()))) {
                player.sendMessage(Config.selfTp);
                return;
            }
        }
        if (parent.tclUserHandler.playerHasPendingRequest(other)) {
            player.sendMessage(Config.playerHasPendingReq);
            return;
        }

        if (parent.tclUserHandler.hasToggled(other)) {
            player.sendMessage(Config.toggledMsg.replace("%p", other.getDisplayName()));
            return;
        }

        req = new TpAction(player, other, player, TpAction.Actions.TELEPORT_TO_PLAYER, parent);
        parent.tclUserHandler.processRequest(player, req);
    }

    public void execute(CommandSender sender, Command command, String commandLabel, String[] args, TeleConfirmLite parent) {

        sender.sendMessage(Config.playerCommand);
    }

    public void help(CommandSender sender, String commandLabel) {

        sender.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + " playername");
    }
}