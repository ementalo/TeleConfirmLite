package com.ementalo.tcl.Permissions;

import org.bukkit.entity.Player;
import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PexPerms extends PermissionsBase {

    @Override
    public boolean hasPermission(Player player, String node) {
        PermissionManager pex = PermissionsEx.getPermissionManager();
        return pex.getUser(player).has(node);
    }
}
