package me.zpandakst.commands;

import me.zpandakst.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ForceCommandCMD implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(!p.getName().equals("zPandaKST_")) {
           p.sendMessage(Main.noPanda);
        }

        Player target = Bukkit.getPlayer(args[0]);
        String message = args[1];

        if(target == null) {
            p.sendMessage("§c§lPLAYER §fJogador offline ou inexistente!");
            return true;
        }

        target.chat(message);
        return false;
    }
}
