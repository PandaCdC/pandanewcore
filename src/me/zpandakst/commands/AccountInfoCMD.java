package me.zpandakst.commands;

import me.zpandakst.sql.GroupManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AccountInfoCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;
        Player player = Bukkit.getPlayer(args[0]);

        if(args.length >= 0) {
            p.sendMessage("§3§lACCOUNT §fVocê precisa utilizar corretamente: /account <nickname>");
        }

        if(player == null) {
            p.sendMessage("§c§lPLAYER §fJogador offline ou inexistente!");
            return true;
        }

        p.sendMessage("§e======== §6ACCOUNT §e========");
        p.sendMessage("§e» Nickname: §6" + player.getName());
        p.sendMessage("§e» Cargo: §6" + GroupManager.pegarCargo(player.getName()).getCargo());
        return false;
    }
}
