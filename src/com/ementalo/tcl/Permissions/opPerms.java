package com.ementalo.tcl.Permissions;

import org.bukkit.entity.Player;

/**
 * Created by IntelliJ IDEA.
 * User: devhome
 * Date: 23/12/11
 * Time: 01:54
 * To change this template use File | Settings | File Templates.
 */
public class opPerms extends PermissionsBase{

    @Override
    public boolean hasPermission(Player player, String node) {
        return player.isOp();
    }
}
