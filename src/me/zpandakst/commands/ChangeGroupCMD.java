package me.zpandakst.commands;

import me.zpandakst.Main;
import me.zpandakst.accountmanagment.Estados;
import me.zpandakst.accountmanagment.Groups;
import me.zpandakst.sql.GroupManager;
import me.zpandakst.sql.PlayerGroupList;
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

                try {
                    Groups cargoTipo = Groups.valueOf(nomeCargo);
                    Estados estadosTipo = Estados.valueOf(nomeEstado);

                    if (cargo == null) {
                        GroupManager.setarPrimeiroCargo(player.getName(), p.getName(), player.getAddress().getHostName(), cargoTipo, estadosTipo);
                        p.sendMessage("§3§lGROUP §fVocê alterou o cargo do jogador (a)§a: " + player.getName() + " §7para: " + nomeCargo.toUpperCase());
                    } else {
                        GroupManager.mudarEstado(estado, estadosTipo);
                        GroupManager.mudarCargo(cargo, cargoTipo);
                        p.sendMessage("§3§lGROUP §fVocê alterou o cargo do jogador (a)§a: " + player.getName() + " §7para: " + nomeCargo.toUpperCase());
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