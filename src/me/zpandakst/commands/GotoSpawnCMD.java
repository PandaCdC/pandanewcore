package me.zpandakst.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.zpandakst.Main;

import java.io.File;

public class GotoSpawnCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            p.teleport(Main.config.getLocation("spawn"));
            p.sendMessage("§3§lSPAWN §fVocê foi teleportado ao SPAWN!");
        }
        return false;
    }

}
