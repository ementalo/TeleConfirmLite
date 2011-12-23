package com.ementalo.tcl.Permissions;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


public class P3Perms extends PermissionsBase{

    public P3Perms(Plugin perms)
    {
        this.permissions = (Permissions)perms;
    }

    @Override
    public boolean hasPermission(Player player, String node) {
        PermissionHandler handler = permissions.getHandler();
        return handler.permission(player, node);
    }
}
