package com.ementalo.tcl;

import org.bukkit.entity.Player;

public class TpAction {

    public TeleConfirmLite parent;

    public enum Actions {
        TELEPORT_TO_PLAYER(Config.tpToThemMsg),
        TELEPORT_PLAYER_TO(Config.tpThemToYouMsg);

        private final String action;

        Actions(String action) {
            this.action = action;
        }

        public String getAction() {
            return action;
        }
    }

    private final Player sender;

    /**
     * The player that is being teleported
     */
    private final Player from;

    /**
     * The player that is being teleported to
     */
    private final Player to;

    /**
     * The action to use
     */
    private final Actions action;

    /**
     * The time the action was made (to time out expired actions)
     */
    private final long time;

    public TpAction(Player sender, Player to, Player from, Actions action, TeleConfirmLite parent) {
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
    public Player getFrom() {
        return from;
    }

    /**
     * @return the player that initiated the request
     */
    public Player getSender() {
        return sender;
    }

    /**
     * @return the player being teleported to
     */
    public Player getTo() {
        return to;
    }

    /**
     * @param player the player to check
     * @return true if the player is active in this request
     */
    public boolean hasPlayer(Player player) {
        return to.equals(player) || from.equals(player);
    }

    /**
     * Send the request to the player
     */
    public void sendRequest() {
        Player from = null;
        Player to = null;

        if (sender.equals(this.to)) {
            from = this.from;
            to = this.to;
        } else {
            from = this.to;
            to = this.from;
        }

        from.sendMessage(Config.fromMsg.replace("%p", to.getDisplayName()).replace("%t", action.getAction()));
        from.sendMessage(Config.acceptDenyPrompt.replace("%a", "tpca").replace("%d", "tpcd"));


    }

    /**
     * Initiate the teleport
     */
    public void teleport() {

        {
            final Player to = this.to;
            final Player from = this.from;

            if (to == null || from == null) {
                return;
            }
            parent.tclUserHandler.addBackLocation(from, from.getLocation());
            from.teleport(to);
        }
    }

}
