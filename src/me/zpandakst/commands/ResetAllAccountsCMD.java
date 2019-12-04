package me.zpandakst.commands;

import me.zpandakst.Main;
import me.zpandakst.sql.GroupManager;
import me.zpandakst.sql.VipManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetAllAccountsCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("resetallaccounts")) {
            if (!(sender.getName().equals("zPandaKST_"))) {
                sender.sendMessage(Main.noPanda);
                return false;
            }

            if (args.length == 0) {

                try {
                    GroupManager.resetAllAccounts();
                    VipManager.resetAllAccounts();
                    p.sendMessage("§4§lRESET §fVocê acabou de §4§lRESETAR TODAS AS CONTAS §f presentes no banco de dados!");

                } catch (Exception ex) {
                    p.sendMessage("§c§lERROR §cErro encontrado!");
                }

            } else {
                p.sendMessage("§3§lRESET §fUtilize /resetallaccounts");
                return false;
            }
        }
        return false;
    }
}