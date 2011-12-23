package com.ementalo.tcl.Commands;


import com.ementalo.tcl.TeleConfirmLite;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by IntelliJ IDEA.
 * User: devhome
 * Date: 20/12/11
 * Time: 17:12
 * To change this template use File | Settings | File Templates.
 */
public interface ITclCommand {

    void execute(CommandSender sender, Command command, String commandLabel, String[]args, TeleConfirmLite parent);
    void execute(Player player, Command command, String commandLabel, String[] args, TeleConfirmLite parent);
    void help(CommandSender sender, String commandLabel);
}
