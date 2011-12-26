package com.ementalo.tcl.Commands;

import com.ementalo.tcl.Config;
import com.ementalo.tcl.TeleConfirmLite;
import com.ementalo.tcl.TpAction;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandtpcd implements ITclCommand {

    public void execute(CommandSender sender, Command command, String commandLabel, String[] args, TeleConfirmLite parent) {
        sender.sendMessage(Config.playerCommand);
    }

    public void execute(Player player, Command command, String commandLabel, String[] args, TeleConfirmLite parent) {
        final TpAction req = parent.tclUserHandler.getReceivingActionRequest(player);
        if(req == null)
        {
             player.sendMessage(Config.noPendingRequests);
        }
        final Player to = parent.getServer().getPlayer(req.getTo());
        final Player from = parent.getServer().getPlayer(req.getFrom());


        switch (req.getAction()) {
            case TELEPORT_TO_PLAYER:
                from.sendMessage(Config.denierMsg);
                to.sendMessage(Config.denyeeMsg);
                break;
            case TELEPORT_PLAYER_TO:
                to.sendMessage(Config.accepterMsg);
                from.sendMessage(Config.accepteeMsg);
                break;
        }
        parent.tclUserHandler.pendingRequests.remove(req);
    }

    public void help(CommandSender sender, String commandLabel) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
