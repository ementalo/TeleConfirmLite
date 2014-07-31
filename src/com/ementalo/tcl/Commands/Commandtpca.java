package com.ementalo.tcl.Commands;

import com.ementalo.tcl.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandtpca implements ITclCommand {

    @Override
    public void execute(CommandSender sender, Command command, String commandLabel, String[] args, TeleConfirmLite parent) {
        sender.sendMessage(Config.playerCommand);
    }

    @Override
    public void execute(Player player, Command command, String commandLabel, String[] args, TeleConfirmLite parent) {

        final TpAction req = parent.tclUserHandler.getReceivingActionRequest(player);

        if (req == null) {
            player.sendMessage(Config.noPendingRequests);
            return;
        }
        final Player to = req.getTo();
        final Player from = req.getFrom();

        if (to == null || from == null) {
            return;
        }

        switch (req.getAction()) {
            case TELEPORT_TO_PLAYER:
                from.sendMessage(Config.accepterMsg);
                to.sendMessage(Config.accepteeMsg);
                req.teleport();
                break;
            case TELEPORT_PLAYER_TO:
                to.sendMessage(Config.accepterMsg);
                from.sendMessage(Config.accepteeMsg);
                req.teleport();
                break;
        }
        parent.tclUserHandler.pendingRequests.remove(req);
    }

    @Override
    public void help(CommandSender sender, String commandLabel) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
