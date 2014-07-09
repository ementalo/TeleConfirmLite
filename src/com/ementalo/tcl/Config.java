package com.ementalo.tcl;

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
        accepteeMsg = config.getString("messages.accepteeMsg", "Accepted request.");
        denyeeMsg = config.getString("messages.denyeeMsg", "Denied request.");
        accepterMsg = config.getString("messages.accepterMsg", "Request to teleport accepted.");
        denierMsg = config.getString("messages.denierMsg", "Request to teleport denied.");
        fromMsg = config.getString("messages.fromMsg", "%p would like to %t");
        tpToThemMsg = config.getString("messages.tpToThemMsg", "teleport to you");
        tpThemToYouMsg = config.getString("messages.tpThemToYouMsg", "teleport you to them");
        acceptDenyPrompt = config.getString("messages.acceptDenyPrompt", "To accept this, type /%a. To deny, type /%d");
        playerHasPendingReq = config.getString("messages.playerHasPendingReq", "That player already has a pending request!");
        requestSent = config.getString("messages.requestSent", "Request sent");
        playerNotFound = config.getString("messages.playerNotFound", "§cPlayer %p not found");
        playerCommand = config.getString("messages.playerCommand", "§cThis command is only available in game to players");
        selfTp = config.getString("messages.selfTp", "§cYou cannot tp to yourself");
        toggledMsg = config.getString("messages.toggledMsg", "§c%p §7 is not accepting requests");
        backUsage = config.getString("messages.backUsage", "§7Teleporting you to your previous location");
        noBackLocation = config.getString("messages.noBackLocation", "§7No previous location");
        removeReq = config.getString("messages.removeReq", "§7Requests removed");
        teleportation = config.getString("messages.teleportation", "Teleportation");
        allowed = config.getString("messages.allowed", "Allowed");
        disabled = config.getString("messages.disabled", "Disabled");
        permissionDenied = config.getString("messages.permission", "§7You do not have permission for that command");
        requestWorlds = config.getString("messages.requestWorlds", "§7You cannot request to teleport from different worlds");
        noPendingRequests = config.getString("messages.noCurrentRequest", "§7You do not have any pending requests");

        //settings
        clearRequestsOnWorldChange = config.getBoolean("settings.clearRequestsOnWorldChange", false);
        requestTimeout = config.getInt("settings.requestTimeout", 30);
        isDebug = config.getBoolean("settings.isDebug", false);
        preventCrossWorldTp = config.getBoolean("settings.preventCrossWorldTp", false);
        allowMetrics = config.getBoolean("settings.allowMetrics", true);

    }
}
