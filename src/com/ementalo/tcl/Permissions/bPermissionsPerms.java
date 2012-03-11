package com.ementalo.tcl.Permissions;

import de.bananaco.bpermissions.api.ApiLayer;
import de.bananaco.bpermissions.api.util.CalculableType;
import org.bukkit.entity.Player;

public class bPermissionsPerms extends PermissionsBase{

    @Override
    public boolean hasPermission(Player player, String node) {
        return ApiLayer.hasPermission(player.getWorld().getName(), CalculableType.USER, player.getName(), node);
     }
}
