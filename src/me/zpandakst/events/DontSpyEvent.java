package me.zpandakst.events;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class DontSpyEvent implements Listener {
    @EventHandler(priority=EventPriority.HIGHEST)
    public void onCommandPreProcess(PlayerCommandPreprocessEvent e) {
        String[] msg = e.getMessage().split(" ");
        List<String> plugins = new ArrayList();

        // Basic
        plugins.add("pl");
        plugins.add("plugin");
        plugins.add("ver" + msg);
        plugins.add("help" + msg);
        plugins.add("?");
        plugins.add("about" + msg);
        plugins.add("me");
        plugins.add("plugins");
        plugins.add("icanhasbukkit" + msg);
        plugins.add("icanhasbukkit");

        // PermissionsEX
        plugins.add("pex" + msg);
        plugins.add("peermissionex" + msg);
        plugins.add("peermissionsex" + msg);

        // Bukkit
        plugins.add("bukkit:help");
        plugins.add("bukkit:about" + msg);
        plugins.add("bukkit:?" + msg);
        plugins.add("bukkit:pl");
        plugins.add("bukkit:ver" + msg);
        plugins.add("bukkit:icanhasbukkit" + msg);
        plugins.add("bukkit:plugins");
        plugins.add("bukkit:plugin");

        // Gear
        plugins.add("Gear_Lobby" + msg);

        // Minecraft
        plugins.add("minecraft:ver");
        plugins.add("minecraft:me");
        plugins.add("minecraft:tell");
        plugins.add("minecraft:?");
        plugins.add("minecraft:help");
        plugins.add("minecraft:about");
        plugins.add("minecraft:op");


        for (String Loop : plugins) {
            if (msg[0].equalsIgnoreCase("/" + Loop))
            {
                e.getPlayer().sendMessage("§cUnknown command. Try /help for a list of commands");
                e.setCancelled(true);
            }
        }
    }
}
