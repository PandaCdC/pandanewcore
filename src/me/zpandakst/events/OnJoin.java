package me.zpandakst.events;

import me.zpandakst.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.chat("/spawn");
    }

    @EventHandler
    public void autoMusic(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.chat("/playsound ppp.bad zPandaKST_");
    }

    @EventHandler
    public void autoMsg(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§c               " + Main.prefix + "§c        ");
        p.sendMessage("§f§m------------------------------");
        p.sendMessage("§eOlá, " + p.getName() + ", sejá bem vindo ao GearMC");
        p.sendMessage("§cLembre-se, estamos em §1BETA§c, caso encontre algum bug, digite: §a/bugreport.");
        p.sendMessage("§aMuito obrigado, pela sua presença em nossos servidores.");
        p.sendMessage("§f§m-------------------------------");
        e.setJoinMessage("§f[§2+§f] §7" + p.getName());
    }

    @EventHandler
    public void autoTag(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.chat("/tag membro");
    }

    @EventHandler
    public void onPandaJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(!(p.getName().equals("zPandaKST_"))) {
        }

        Bukkit.broadcastMessage("§3§lSTAFF §7O §4§lCEO §4zPandaKST_ §7entrou nesse lobby.");
    }
}
