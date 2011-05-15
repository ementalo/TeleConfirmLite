package com.ementalo.tcl;

import org.bukkit.ChatColor;
import org.bukkit.entity.*;

public class TpAction {

	public TeleConfirmLite parent;
	public enum Actions {
		TELEPORT_TO_PLAYER(TeleConfirmLite.tpToThemMsg), TELEPORT_PLAYER_TO(
				TeleConfirmLite.tpThemToYouMsg);

		private String action;

		Actions(String action) {
			this.action = action;
		}

		public String getAction() {
			return action;
		}
	}

	private final String sender;

	/**
	 * The player that is being teleported
	 */
	private final String from;

	/**
	 * The player that is being teleported to
	 */
	private final String to;

	/**
	 * The action to use
	 */
	private final Actions action;

	/**
	 * The time the action was made (to time out expired actions)
	 */
	private final long time;

	public TpAction(String sender, String to, String from, Actions action, TeleConfirmLite parent) {
		this.parent = parent;
		this.sender = sender;
		this.to = to;
		this.from = from;
		this.action = action;
		time = System.currentTimeMillis();
		
		
	}

	
	/**
	 * @return the action for the teleport command
	 */
	public Actions getAction() {
		return action;
	}

	/**
	 * @return the time the request was made
	 */
	public long getCreationTime() {
		return time;
	}

	/**
	 * @return the player being teleported
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @return the player that initiated the request
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * @return the player being teleported to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param player
	 *            the player to check
	 * @return true if the player is active in this request
	 */
	public boolean hasPlayer(String player) {
		return to.equals(player) || from.equals(player);
	}

	/**
	 * Send the request to the player
	 */
	public void sendRequest() {
		Player from = null;
		Player to = null;

		if (sender.equals(this.to)) {
			from = parent.getServer().getPlayer(this.from);
			to = parent.getServer().getPlayer(this.to);
		} else {
			from = parent.getServer().getPlayer(this.to);
			to = parent.getServer().getPlayer(this.from);
		}
		
		from.sendMessage(TeleConfirmLite.msgPositiveColor +  TeleConfirmLite.fromMsg.replace("%p", to.getName()).replace("%t", action.getAction()));
		from.sendMessage(TeleConfirmLite.msgPositiveColor + TeleConfirmLite.acceptDenyPrompt.replace("%a", "tpca").replace("%d", "tpcd"));	
		
		
	}

	/**
	 * Initiate the teleport
	 */
	public void teleport() {
		
		{
		final Player to = parent.getServer().getPlayer(this.to);
		final Player from = parent.getServer().getPlayer(this.from);

		if (to == null || from == null) {
			return;
		}

		from.teleport(to);
		}
	}

}
