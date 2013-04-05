package com.ementalo.tcl.Commands;


import com.ementalo.tcl.TeleConfirmLite;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public interface ITclCommand {

    void execute(CommandSender sender, Command command, String commandLabel, String[]args, TeleConfirmLite parent);
    void execute(Player player, Command command, String commandLabel, String[] args, TeleConfirmLite parent);
    void help(CommandSender sender, String commandLabel);
}
