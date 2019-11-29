package me.zpandakst.commands;

import me.zpandakst.Main;
import me.zpandakst.sql.GroupManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class ResetAccountCMD implements CommandExecutor, Listener {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("resetaccount")) {
            if (!(sender.hasPermission("gearmc.cmd.accountreset"))) {
                sender.sendMessage(Main.noPerm);
                return false;
            }

            if (args.length == 1) {

                Player player = Bukkit.getPlayer(args[0]);

                try {
                        GroupManager.resetAccount(player.getName());
                        p.sendMessage("§4§lRESET §fVocê acabou de §4§lRESETAR §fa conta do usuário (a): " + player.getName());

                } catch (Exception ex) {
                    p.sendMessage("§c§lERROR §cUsuário não encontrado!");
                }

            } else {
                p.sendMessage("§3§lGRUPO §fUtilize /resetaccount <nick>");
                return false;
            }
        }
        return false;
    }
}