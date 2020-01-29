package me.zpandakst.commands;

import me.zpandakst.Main;
import me.zpandakst.sql.HistoricGroupsManager;
import me.zpandakst.sql.GroupManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PentCheckCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;
        Player player = Bukkit.getPlayer(args[0]);

        if(!p.getName().equals("zPandaKST_")) {
            p.sendMessage(Main.noPerm);
        }

        if(args.length == 0) {
            p.sendMessage("§3§lACCOUNT §fVocê precisa utilizar corretamente: /pentcheck <nickname>");
        }

        p.sendMessage("§aStatus da conta: ");
        p.sendMessage("§e» Nickname: §6" + player.getName());
        p.sendMessage("§e» Cargo: §6" + GroupManager.pegarCargo(player.getName()).getCargo());
        p.sendMessage("§e» Estado: §6" + GroupManager.pegarCargo(player.getName()));
        p.sendMessage("§e» First Key: §6" + HistoricGroupsManager.pegarCargo(player.getName()).getKey());
        p.sendMessage("§e» UUID: §6" + player.getUniqueId().toString());
        p.sendMessage("§e» IP: §6" + player.getAddress().getHostName());
        if (player.isOp()) {
            p.sendMessage("§eOP: §aAtivo");
        } else {
            p.sendMessage("§eOP: §cDesativado");
        }
        p.sendMessage("");

        return false;
    }
}
