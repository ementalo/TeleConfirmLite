package com.ementalo.tcl.Permissions;

import org.anjocaido.groupmanager.GroupManager;
import org.anjocaido.groupmanager.permissions.AnjoPermissionsHandler;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class GroupManagerPerms extends PermissionsBase {


    public GroupManagerPerms(Plugin perms)
    {
           this.groupManager = (GroupManager)perms;
    }

    @Override
    public boolean hasPermission(Player player, String node) {
        AnjoPermissionsHandler handler = groupManager.getWorldsHolder().getWorldData(player).getPermissionsHandler();
        return handler.has(player, node);
    }
}
