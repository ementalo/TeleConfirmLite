package com.ementalo.tcl.Commands;

import com.ementalo.tcl.Config;
import com.ementalo.tcl.TeleConfirmLite;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandtpctoggle implements ITclCommand{


    public void execute(CommandSender sender, Command command, String commandLabel, String[] args, TeleConfirmLite parent)
    {
        sender.sendMessage(Config.playerCommand);
    }

    public void execute(Player player, Command command, String commandLabel, String[] args, TeleConfirmLite parent)
    {
        parent.tclUserHandler.toggleTp(player);
        player.sendMessage(Config.teleportation + ( parent.tclUserHandler.hasToggled(player) ? Config.disabled : Config.allowed));
    }

    public void help(CommandSender sender, String commandLabel)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
