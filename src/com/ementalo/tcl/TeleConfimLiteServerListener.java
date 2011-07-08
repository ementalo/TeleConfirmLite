package com.ementalo.tcl;

import java.util.logging.Level;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.event.server.ServerListener;


public class TeleConfimLiteServerListener extends ServerListener
{
	TeleConfirmLite parent = null;

	public TeleConfimLiteServerListener(TeleConfirmLite parent)
	{
		this.parent = parent;
	}

	@Override
	public void onPluginEnable(PluginEnableEvent event)
	{
		if (parent.permPlugin != null) return;

		String pluginName = event.getPlugin().getDescription().getName();
		if (pluginName.equalsIgnoreCase("Permissions"))
		{
			parent.permPlugin = event.getPlugin();
			TeleConfirmLite.log.log(Level.INFO, "[TeleConfirmLite] Found " + pluginName + ". Using it for permissions");
		}
	}

	@Override
	public void onPluginDisable(PluginDisableEvent event)
	{
		if (parent.permPlugin == null) return;
		String pluginName = event.getPlugin().getDescription().getName();
		if (pluginName.equalsIgnoreCase("Permissions"))
		{
			parent.permPlugin = null;
			TeleConfirmLite.log.log(Level.INFO, "[TeleConfirmLite] " + pluginName + " disabled commands are available to all");
		}
	}
}
