package me.zpandakst.commands;

import me.zpandakst.Main;
import me.zpandakst.accountmanagment.GeneralGroups;
import me.zpandakst.sql.GroupManager;
import me.zpandakst.sql.HistoricGroupsManager;
import me.zpandakst.sql.PlayerGroupList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SetRankCMD implements CommandExecutor, Listener {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;
            if (!(sender.hasPermission("magicmc.usecmd.setrank"))) {
                sender.sendMessage(Main.noPerm);
                return false;
            }

            if (args.length == 1) {

                String nomeCargo = args[1];
                Player player = Bukkit.getPlayer(args[0]);
                PlayerGroupList cargo = GroupManager.pegarCargo(player.getName());

                try {
                    GeneralGroups cargoTipo = GeneralGroups.valueOf(nomeCargo);

                    if (cargo == null) {
                        GroupManager.setarPrimeiroCargo(player.getName(), p.getName(), player.getAddress().getHostName(), cargoTipo);
                        HistoricGroupsManager.registerCargo(player.getName(), p.getName(), player.getAddress().getHostName(), cargoTipo);
                        p.sendMessage("§3§lGROUP §fVocê setou o cargo do jogador (a)§a: " + player.getName() + " §7para: " + nomeCargo.toUpperCase());
                    } else {
                        GroupManager.mudarCargo(cargo, cargoTipo);
                        p.sendMessage("§3§lGROUP §fVocê alterou o cargo do jogador (a)§a: " + player.getName() + " §7para: " + nomeCargo.toUpperCase());
                    }

                } catch (Exception ex) {
                    p.sendMessage("§c§lERROR §cCargo invalido!");
                }

            } else {
                p.sendMessage("§3§lRANK §fUtilize /setrank <nick> <cargo>");
                return false;
            }
        return false;
    }
}