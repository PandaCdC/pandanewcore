package me.zpandakst.commands;

import me.zpandakst.Main;
import me.zpandakst.accountmanagment.Estados;
import me.zpandakst.accountmanagment.GeneralGroups;
import me.zpandakst.accountmanagment.GroupsVips;
import me.zpandakst.sql.*;
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

            if (args.length == 3) {

                String nomeEstado = args[2];
                String nomeVip = args[1];
                Player player = Bukkit.getPlayer(args[0]);
                PlayerVipList vip = VipManager.pegarVip(player.getName());
                GeneralGroupList vip2 = GeneralGroupManager.pegarCargo(player.getName());

                try {
                    GeneralGroups vipSet = GeneralGroups.valueOf(nomeVip);
                    Estados estadosTipo = Estados.valueOf(nomeEstado);
                    GroupsVips vipTipo = GroupsVips.valueOf(nomeVip);

                    if (vip == null) {
                        GeneralGroupManager.primeiroRegistro(player.getName(), p.getName(), p.getAddress().getHostName(), vipSet, estadosTipo);
                        HistoricGroupsManager.registerCargo(p.getName(), player.getName(), player.getAddress().getHostName(), vipSet, estadosTipo);
                        VipManager.setarPrimeiroVip(player.getName(), p.getName(), player.getAddress().getHostName(), vipTipo);
                        p.sendMessage("§3§lGROUP §fVocê alterou o cargo do jogador (a)§a: " + player.getName() + " §7para: " + nomeVip.toUpperCase());
                    } else {
                        GeneralGroupManager.mudarCargo(vip2, vipSet);
                        HistoricGroupsManager.registerCargo(player.getName(), p.getName(), p.getAddress().getHostName(), vipSet, estadosTipo);
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