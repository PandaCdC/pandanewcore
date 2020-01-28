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
import org.bukkit.event.Listener;

public class PManagerCMD
        implements CommandExecutor, Listener {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("pmanager")) {
            if (!sender.hasPermission("magicmc.cmduse.pmanager")) {
                sender.sendMessage(Main.noPerm);
                return true;
            }
            if (args.length == 2) {
                String mType = args[0];
                Player target = Bukkit.getPlayer(args[1]);
                if (mType.equalsIgnoreCase("setrank")) {
                    String nomeCargo = args[2];
                    PlayerGroupList cargo = GroupManager.pegarCargo(target.getName());
                    GeneralGroupList cargo2 = GeneralGroupManager.pegarCargo(target.getName());

                    try {
                        GeneralGroups cargoSet = GeneralGroups.valueOf(nomeCargo);
                        Groups cargoTipo = Groups.valueOf(nomeCargo);

                        if (cargo == null) {
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
                    return false;
                }
                if (mType.equalsIgnoreCase("setvip")) {
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
                    return false;
                }
                if (mType.equalsIgnoreCase("resetallccounts")) {
                    if(p.getName().equals("zPandaKST_")) {
                        p.sendMessage(Main.noPanda);
                    }
                    GroupManager.resetAllAccounts();
                    VipManager.resetAllAccounts();
                    p.sendMessage("§4§lACCOUNT §fTodas as contas do banco de dados acabaram de ser apagadas!");
                }
                if (mType.equalsIgnoreCase("resetaccount")) {
                    GroupManager.resetAccount(target.getName());
                    VipManager.resetAccount(target.getName());
                    p.sendMessage("§4§lRESET §fVocê resetou a conta do jogador §a: " + target.getName() + "§f.");
                    return false;
                }
            } else {
                p.sendMessage("Usage: /pmanager <setrank/setvip/resetallaccounts/resetaccount> <player> <rank>.");
                return true;
            }
        }
        return false;
    }
}