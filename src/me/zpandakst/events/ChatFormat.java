package me.zpandakst.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class ChatFormat implements Listener {
    @EventHandler
    public void modificarChat(AsyncPlayerChatEvent e) {
        Player jogador = e.getPlayer();
        if (jogador.hasPermission("gearmc.falarcolorido")) {
            e.setFormat(jogador.getDisplayName() + " §7» " + e.getMessage().replace("&", "§").replace("%", " Porcento(s)".replace("<3", "§4❤")));
        } else {
            e.setFormat(jogador.getDisplayName() + " §7» " + e.getMessage());
        }
        if (jogador.hasPermission("gearmc.falarcolorido")) {
            e.setFormat(jogador.getDisplayName() + " §6»§f " + e.getMessage().replace("&", "§").replace("%", "Porcento(s)").replace("<3", "§4❤"));
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        e.getPlayer().chat("/tag membro");
    }
}