package com.ementalo.tcl;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;


public class TeleConfirmLiteUserHandler {
    public ArrayList<TpAction> pendingRequests;
    public static HashMap<Player, Boolean> tpToggle;
    public static HashMap<Player, Location> tpBack;

    public TeleConfirmLiteUserHandler() {
        pendingRequests = new ArrayList<TpAction>();
        tpToggle = new HashMap<Player, Boolean>();
        tpBack = new HashMap<Player, Location>();
    }


    public TpAction getReceivingActionRequest(Player player) {
        for (final TpAction req : pendingRequests) {
            if (!req.getSender().equals(player)
                    && req.hasPlayer(player)) {
                return req;
            }
        }
        return null;
    }

    public boolean playerHasPendingRequest(Player player) {
        for (final TpAction action : pendingRequests) {
            if (action.getTo().equals(player)) {
                return true;
            }
        }
        return false;
    }

    public void processRequest(Player player, TpAction req) {
        req.sendRequest();
        player.sendMessage(Config.requestSent);
        pendingRequests.add(req);
    }

    public void addBackLocation(Player player, Location location) {
        tpBack.put(player, location);
    }

    public Location getBackLocation(Player player) {
        if (tpBack.get(player) == null) {
            return null;
        }
        return tpBack.get(player);
    }

    public void toggleTp(Player player) {

        if (tpToggle.get(player) == null) {
            tpToggle.put(player, false);
        } else {
            if (tpToggle.get(player) ? tpToggle.put(player, false) : tpToggle.put(player, true)) ;
        }
    }

    public Boolean hasToggled(Player player) {
        try {
            return !tpToggle.isEmpty() && !tpToggle.get(player);
        } catch (NullPointerException np) {
            return false;
        }
    }
    
    public boolean worldCompare(World compare, World compare2)
    {
        return compare.equals(compare2);
    }
}
