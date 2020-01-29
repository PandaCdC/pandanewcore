package me.zpandakst.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.zpandakst.Main;

public class SetSpawnCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if(!p.hasPermission("gearmc.buildmanager.setspawn")) {
                Main.config.set("spawn", p.getLocation());
                Main.config.saveConfig();
                p.sendMessage("§a§lSPAWN §aVocê setou o Spawn!");
            } else {
                p.sendMessage(Main.noPerm);
            }
        }
        return false;
    }

}