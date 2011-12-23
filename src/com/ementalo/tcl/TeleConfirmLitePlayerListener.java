package com.ementalo.tcl;

import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerChangedWorldEvent;


public class TeleConfirmLitePlayerListener extends PlayerListener {

    TeleConfirmLite parent;

    public TeleConfirmLitePlayerListener(TeleConfirmLite parent) {
        this.parent = parent;
    }

    @Override
    public void onPlayerChangedWorld(PlayerChangedWorldEvent event) {

        if (Config.clearRequestsOnWorldChange) {
            TpAction req = parent.tclUserHandler.getReceivingActionRequest(event.getPlayer());
            parent.tclUserHandler.pendingRequests.remove(req);
        }
    }
}
