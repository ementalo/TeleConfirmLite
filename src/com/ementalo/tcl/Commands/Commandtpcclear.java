package com.ementalo.tcl.Commands;

import com.ementalo.tcl.Config;
import com.ementalo.tcl.TeleConfirmLite;
import com.ementalo.tcl.TpAction;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandtpcclear implements ITclCommand {

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

        parent.tclUserHandler.pendingRequests.remove(req);
        player.sendMessage(Config.removeReq);
    }

    @Override
    public void help(CommandSender sender, String commandLabel) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
