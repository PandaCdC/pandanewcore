package me.zpandakst.commands;

import me.zpandakst.Main;
import me.zpandakst.accountmanagment.GeneralGroups;
import me.zpandakst.accountmanagment.Groups;
import me.zpandakst.accountmanagment.GroupsVips;
import me.zpandakst.sql.*;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerManageCMD implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        Player target = Bukkit.getPlayer(args[1]);
        if(!p.hasPermission("magicmc.cmduse.playermanage")) {
            p.sendMessage(Main.noPerm);
        }
        if(args[0].equalsIgnoreCase("rank")) {
            String nomeCargo = args[2];
            PlayerGroupList cargo = GroupManager.pegarCargo(target.getName());
            GeneralGroupList cargo2 = GeneralGroupManager.pegarCargo(target.getName());

            try {
                GeneralGroups cargoSet = GeneralGroups.valueOf(nomeCargo);
                Groups cargoTipo = Groups.valueOf(nomeCargo);

                if(cargo == null) {
                    GeneralGroupManager.primeiroRegistro(target.getName(), p.getName(), p.getAddress().getHostName(), cargoSet);
                    GroupManager.setarPrimeiroCargo(target.getName(), p.getName(), target.getAddress().getHostName(), cargoTipo);
                    HistoricGroupsManager.registerCargo(p.getName(), target.getName(), target.getAddress().getHostName(), cargoSet);
                    p.sendMessage("§3§lGROUP §fVocê setou o cargo do jogador: §a" + target.getName() + " §7para: " + nomeCargo.toUpperCase());
                    p.chat("/tag " + cargoTipo);
                } else {
                    HistoricGroupsManager.registerCargo(p.getName(), target.getName(), p.getAddress().getHostName(), cargoSet);
                    GroupManager.mudarCargo(cargo, cargoTipo);
                    GeneralGroupManager.mudarCargo(cargo2, cargoSet);
                    p.sendMessage("§3§lGROUP §fVocê alterou o cargo do jogador: §a" + target.getName() + " §7para: " + nomeCargo.toUpperCase());
                    p.chat("/tag " + cargoTipo);
                }

            } catch (Exception ex) {
                p.sendMessage("§c§lERROR §cCargo ou estado invalidos!");
            }
        } else if(args[0].equalsIgnoreCase("resetallaccounts")) {
            if(p.getName().equals("zPandaKST_")) {
              p.sendMessage(Main.noPanda);
            }
            GroupManager.resetAllAccounts();
            VipManager.resetAllAccounts();
            p.sendMessage("§4§lACCOUNT §fTodas as contas do banco de dados acabaram de ser apagadas!");
        } else if(args[0].equalsIgnoreCase("resetaccount")) {
            GroupManager.resetAccount(target.getName());
        } else if (args[0].equalsIgnoreCase("setvip")) {
            String nomeVip = args[2];
            PlayerVipList vip = VipManager.pegarVip(target.getName());
            GeneralGroupList vip2 = GeneralGroupManager.pegarCargo(target.getName());

            try {
                GeneralGroups vipSet = GeneralGroups.valueOf(nomeVip);
                GroupsVips vipTipo = GroupsVips.valueOf(nomeVip);

                if (vip == null) {
                    GeneralGroupManager.primeiroRegistro(target.getName(), p.getName(), p.getAddress().getHostName(), vipSet);
                    HistoricGroupsManager.registerCargo(p.getName(), target.getName(), target.getAddress().getHostName(), vipSet);
                    VipManager.setarPrimeiroVip(target.getName(), p.getName(), target.getAddress().getHostName(), vipTipo);
                    p.sendMessage("§3§lGROUP §fVocê alterou o cargo do jogador (a)§a: " + target.getName() + " §7para: " + nomeVip.toUpperCase());
                } else {
                    GeneralGroupManager.mudarCargo(vip2, vipSet);
                    HistoricGroupsManager.registerCargo(target.getName(), p.getName(), p.getAddress().getHostName(), vipSet);
                    VipManager.mudarVip(vip, vipTipo);
                    p.sendMessage("§3§lGROUP §fVocê alterou o cargo do jogador (a)§a: " + target.getName() + " §7para: " + nomeVip.toUpperCase());
                }

            } catch (Exception ex) {
                p.sendMessage("§c§lERROR §cVIP invalido!");
            }
        }
        return false;
    }
}


// USAGE: /pmanager <setrank/resetallaccounts/resetaccount> <target> <rank>