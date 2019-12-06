package me.zpandakst.events;

import me.zpandakst.Main;
import me.zpandakst.sql.GeneralGroupManager;
import me.zpandakst.sql.GroupManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.teleport(Main.config.getLocation("spawn"));
    }

    @EventHandler
    public void autoMsg(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage("§f[§2+§f] §7" + p.getName());
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
    }

    @EventHandler
    public void autoTag(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.chat("/tag " + GroupManager.pegarCargo(p.getName()).getCargo());
    }

    @EventHandler
    public void onJoinRegister(PlayerJoinEvent e) {
        Player p = e.getPlayer();
    }
}
