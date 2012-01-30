package com.ementalo.tcl;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;


public class TeleConfirmLitePlayerListener implements Listener {

    TeleConfirmLite parent;

    public TeleConfirmLitePlayerListener(TeleConfirmLite parent) {
        this.parent = parent;
    }


    @EventHandler()
    public void onPlayerChangedWorld(PlayerChangedWorldEvent event) {

        if (Config.clearRequestsOnWorldChange) {
            TpAction req = parent.tclUserHandler.getReceivingActionRequest(event.getPlayer());
            parent.tclUserHandler.pendingRequests.remove(req);
        }
    }
}
