package com.ementalo.tcl;

import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;

public class Config {

    public Configuration config = null;
    TeleConfirmLite parent = null;
    public static String accepteeMsg, denyeeMsg, accepterMsg, denierMsg;
    public static String fromMsg, tpToThemMsg, tpThemToYouMsg, acceptDenyPrompt;
    public static String playerHasPendingReq, requestSent, playerNotFound;
    public static String playerCommand, selfTp, toggledMsg, backUsage, requestWorlds;
    public static String noBackLocation, removeReq, teleportation, allowed, disabled;

    public static boolean isDebug;
    public static String permissionDenied, noPendingRequests;
    public static boolean clearRequestsOnWorldChange, preventCrossWorldTp, allowMetrics;
    public static int requestTimeout;

    public Config(TeleConfirmLite parent) {
        this.parent = parent;
        config = parent.getConfig();
    }

    public void loadSettings() throws Exception {
        config.options().copyDefaults(true);

        parent.saveConfig();
        parent.reloadConfig();
    }

    public void AssignSettings() {
        accepteeMsg         = colorize(config.getString("messages.accepteeMsg", "Accepted request."));
        denyeeMsg           = colorize(config.getString("messages.denyeeMsg", "Denied request."));
        accepterMsg         = colorize(config.getString("messages.accepterMsg", "Request to teleport accepted."));
        denierMsg           = colorize(config.getString("messages.denierMsg", "Request to teleport denied."));
        fromMsg             = colorize(config.getString("messages.fromMsg", "%p would like to %t"));
        tpToThemMsg         = colorize(config.getString("messages.tpToThemMsg", "teleport to you"));
        tpThemToYouMsg      = colorize(config.getString("messages.tpThemToYouMsg", "teleport you to them"));
        acceptDenyPrompt    = colorize(config.getString("messages.acceptDenyPrompt", "To accept this, type /%a. To deny, type /%d"));
        playerHasPendingReq = colorize(config.getString("messages.playerHasPendingReq", "That player already has a pending request!"));
        requestSent         = colorize(config.getString("messages.requestSent", "Request sent"));
        playerNotFound      = colorize(config.getString("messages.playerNotFound", "&cPlayer %p not found"));
        playerCommand       = colorize(config.getString("messages.playerCommand", "&cThis command is only available in game to players"));
        selfTp              = colorize(config.getString("messages.selfTp", "&cYou cannot tp to yourself"));
        toggledMsg          = colorize(config.getString("messages.toggledMsg", "&c%p &7 is not accepting requests"));
        backUsage           = colorize(config.getString("messages.backUsage", "&7Teleporting you to your previous location"));
        noBackLocation      = colorize(config.getString("messages.noBackLocation", "&7No previous location"));
        removeReq           = colorize(config.getString("messages.removeReq", "&7Requests removed"));
        teleportation       = colorize(config.getString("messages.teleportation", "Teleportation"));
        allowed             = colorize(config.getString("messages.allowed", "Allowed"));
        disabled            = colorize(config.getString("messages.disabled", "Disabled"));
        permissionDenied    = colorize(config.getString("messages.permission", "&7You do not have permission for that command"));
        requestWorlds       = colorize(config.getString("messages.requestWorlds", "&7You cannot request to teleport from different worlds"));
        noPendingRequests   = colorize(config.getString("messages.noCurrentRequest", "&7You do not have any pending requests"));

        //settings
        clearRequestsOnWorldChange = config.getBoolean("settings.clearRequestsOnWorldChange", false);
        requestTimeout             = config.getInt    ("settings.requestTimeout", 30);
        isDebug                    = config.getBoolean("settings.isDebug", false);
        preventCrossWorldTp        = config.getBoolean("settings.preventCrossWorldTp", false);
        allowMetrics               = config.getBoolean("settings.allowMetrics", true);

    }
    
    private String colorize(String message)
    {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
