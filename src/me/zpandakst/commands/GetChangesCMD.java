package me.zpandakst.commands;

import me.zpandakst.Main;
import me.zpandakst.sql.GeneralGroupsManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetChangesCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("getchanges")) {
            if (!(sender.hasPermission("gearmc.cmd.getchanges"))) {
                sender.sendMessage(Main.noPerm);
                return false;
            }

            if (args.length == 0) {

                String key = args[0];
                if (key == null) {
                    p.sendMessage("§aAqui está os dados da alteração: §2" + key + "\n §aNickname: §2" + GeneralGroupsManager.pegarCargoKEY(key).getJogador() + "\n §aAutor: §2" + GeneralGroupsManager.pegarCargoKEY(key).getAuthor() + "\n §aCargo: §2" + GeneralGroupsManager.pegarCargoKEY(key).getCargo() + "\n §aEstado: §2" + GeneralGroupsManager.pegarCargoKEY(key).getEstado());
                } else {
                    p.sendMessage("§3§lGRUPO §fUtilize /getchanges <key>!");
                    return false;
                }
                return false;
            }
        }
        return false;
    }
}