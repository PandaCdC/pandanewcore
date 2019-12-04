package me.zpandakst.commands;

import me.zpandakst.Main;
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

        if(!(p.getName().equals("zPandaKST_"))) {
            p.sendMessage(Main.noPerm);
        }

        if(args.length == 0) {
            p.sendMessage("§3§lACCOUNT §fVocê precisa utilizar corretamente: /pentcheck <nickname>");
        }

        p.sendMessage("§aStatus da conta: ");
        p.sendMessage("§3Nickname: §a" + player.getName());
        p.sendMessage("§3Cargo: §a" + GroupManager.pegarCargo(player.getName()).getCargo());
        p.sendMessage("§3UUID: §a" + player.getUniqueId().toString());
        p.sendMessage("§3IP: §a" + player.getAddress().getHostName());
        if (player.isOp()) {
            sender.sendMessage("§3OP: §aAtivo");
        } else {
            p.sendMessage("§3OP: §cDesativado");
        }
        sender.sendMessage("");

        return false;
    }
}
