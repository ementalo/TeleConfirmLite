package com.ementalo.tcl.Commands;

import com.ementalo.tcl.Config;
import com.ementalo.tcl.TeleConfirmLite;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by IntelliJ IDEA.
 * User: devhome
 * Date: 20/12/11
 * Time: 15:49
 * To change this template use File | Settings | File Templates.
 */
public class Commandtpcback implements ITclCommand {

    public void execute(Player player, Command command, String commandLabel, String[] args, TeleConfirmLite parent) {


        Location l = parent.tclUserHandler.getBackLocation(player);
        if (l == null) {
            player.sendMessage(Config.noBackLocation);
            return;
        }
        player.sendMessage(Config.backUsage);
        player.teleport(l);
        return;
    }


    public void execute(CommandSender sender, Command command, String commandLabel, String[] args, TeleConfirmLite parent) {
        sender.sendMessage(Config.playerCommand);
    }

    public void help(CommandSender sender, String commandLabel) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
