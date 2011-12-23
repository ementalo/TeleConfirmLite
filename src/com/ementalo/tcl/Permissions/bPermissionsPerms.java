package com.ementalo.tcl.Permissions;

import de.bananaco.permissions.Permissions;
import de.bananaco.permissions.interfaces.PermissionSet;
import de.bananaco.permissions.worlds.HasPermission;
import org.bukkit.entity.Player;

public class bPermissionsPerms extends PermissionsBase{

    @Override
    public boolean hasPermission(Player player, String node) {
        PermissionSet set = Permissions.getWorldPermissionsManager().getPermissionSet(player.getWorld());
        if (set == null)
            return false;
        return HasPermission.has(player, node);
    }
}
