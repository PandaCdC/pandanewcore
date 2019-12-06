package me.zpandakst.commands;

import me.zpandakst.Main;
import me.zpandakst.accountmanagment.Estados;
import me.zpandakst.accountmanagment.GeneralGroups;
import me.zpandakst.accountmanagment.Groups;
import me.zpandakst.sql.*;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class ChangeGroupCMD implements CommandExecutor, Listener {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("setcargo") || cmd.getName().equalsIgnoreCase("changegroup")) {
            if (!(sender.hasPermission("gearmc.cmd.changegroup"))) {
                sender.sendMessage(Main.noPerm);
                return false;
            }

            if (args.length == 3) {

                String nomeCargo = args[1];
                String nomeEstado = args[2];
                Player player = Bukkit.getPlayer(args[0]);
                PlayerGroupList cargo = GroupManager.pegarCargo(player.getName());
                PlayerGroupList estado = GroupManager.pegarCargo(player.getName());
                GeneralGroupList cargo2 = GeneralGroupManager.pegarCargo(player.getName());
                GeneralGroupList estado2 = GeneralGroupManager.pegarCargo(player.getName());

                try {
                    GeneralGroups cargoSet = GeneralGroups.valueOf(nomeCargo);
                    Groups cargoTipo = Groups.valueOf(nomeCargo);
                    Estados estadosTipo = Estados.valueOf(nomeEstado);

                    if(cargo == null) {
                        GeneralGroupManager.primeiroRegistro(player.getName(), p.getName(), p.getAddress().getHostName(), cargoSet, estadosTipo);
                        GroupManager.setarPrimeiroCargo(player.getName(), p.getName(), player.getAddress().getHostName(), cargoTipo, estadosTipo);
                        HistoricGroupsManager.registerCargo(p.getName(), player.getName(), player.getAddress().getHostName(), cargoSet, estadosTipo);
                        p.sendMessage("§3§lGROUP §fVocê setou o cargo do jogador: §a" + player.getName() + " §7para: " + nomeCargo.toUpperCase());
                        p.chat("/tag " + cargoTipo);
                    } else {
                        HistoricGroupsManager.registerCargo(p.getName(), player.getName(), p.getAddress().getHostName(), cargoSet, estadosTipo);
                        GroupManager.mudarEstado(estado, estadosTipo);
                        GroupManager.mudarCargo(cargo, cargoTipo);
                        GeneralGroupManager.mudarCargo(cargo2, cargoSet);
                        GeneralGroupManager.mudarEstado(estado2, estadosTipo);
                        p.sendMessage("§3§lGROUP §fVocê alterou o cargo do jogador: §a" + player.getName() + " §7para: " + nomeCargo.toUpperCase());
                        p.chat("/tag " + cargoTipo);
                    }

                } catch (Exception ex) {
                    p.sendMessage("§c§lERROR §cCargo ou estado invalidos!");
                }

            } else {
                p.sendMessage("§3§lGRUPO §fUtilize /setcargo <nick> <cargo> <estado>");
                return false;
            }
        }
        return false;
    }
}