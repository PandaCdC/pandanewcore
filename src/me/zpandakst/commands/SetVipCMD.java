package me.zpandakst.commands;

import me.zpandakst.Main;
import me.zpandakst.accountmanagment.GroupsVips;
import me.zpandakst.sql.PlayerVipList;
import me.zpandakst.sql.VipManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetVipCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("setvip") || cmd.getName().equalsIgnoreCase("vipset")) {
            if (!(sender.hasPermission("gearmc.cmd.setvip"))) {
                sender.sendMessage(Main.noPerm);
                return false;
            }

            if (args.length == 2) {

                String nomeVip = args[1];
                Player player = Bukkit.getPlayer(args[0]);
                PlayerVipList vip = VipManager.pegarVip(player.getName());

                try {
                    GroupsVips vipTipo = GroupsVips.valueOf(nomeVip);

                    if (vip == null) {
                        VipManager.setarPrimeiroVip(player.getName(), p.getName(), player.getAddress().getHostName(), vipTipo);
                        p.sendMessage("§3§lGROUP §fVocê alterou o cargo do jogador (a)§a: " + player.getName() + " §7para: " + nomeVip.toUpperCase());
                    } else {
                        VipManager.mudarVip(vip, vipTipo);
                        p.sendMessage("§3§lGROUP §fVocê alterou o cargo do jogador (a)§a: " + player.getName() + " §7para: " + nomeVip.toUpperCase());
                    }

                } catch (Exception ex) {
                    p.sendMessage("§c§lERROR §cVIP invalido!");
                }

            } else {
                p.sendMessage("§3§lGRUPO §fUtilize /setvip <nick> <vip>");
                return false;
            }
        }
        return false;
    }
}