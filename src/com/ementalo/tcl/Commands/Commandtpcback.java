package com.ementalo.tcl.Commands;

import com.ementalo.tcl.Config;
import com.ementalo.tcl.TeleConfirmLite;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandtpcback implements ITclCommand {

    @Override
    public void execute(Player player, Command command, String commandLabel, String[] args, TeleConfirmLite parent) {


        Location l = parent.tclUserHandler.getBackLocation(player);
        if (l == null) {
            player.sendMessage(Config.noBackLocation);
            return;
        }
        player.sendMessage(Config.backUsage);
        player.teleport(l);
    }


    @Override
    public void execute(CommandSender sender, Command command, String commandLabel, String[] args, TeleConfirmLite parent) {
        sender.sendMessage(Config.playerCommand);
    }

    @Override
    public void help(CommandSender sender, String commandLabel) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
