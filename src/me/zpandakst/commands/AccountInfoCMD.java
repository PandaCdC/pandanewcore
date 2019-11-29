package me.zpandakst.commands;

import me.zpandakst.Main;
import me.zpandakst.sql.GroupManager;
import me.zpandakst.sql.VipManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AccountInfoCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;
        Player player = Bukkit.getPlayer(args[0]);

        if(!p.hasPermission("gearmc.cmd.accinfo")) {
            p.sendMessage(Main.noPerm);
        }

        if(args.length == 0) {
            p.sendMessage("§3§lACCOUNT §fVocê precisa utilizar corretamente: /accountinfo <nickname>");
        }

        p.sendMessage("§Status da conta: ");
        p.sendMessage("§3Nickname: §a" + player.getName());
        p.sendMessage("§3Cargo: §a" + GroupManager.pegarCargo(player.getName()));
        p.sendMessage("");
        if (player.isOp()) {
            sender.sendMessage("§3OP: §aAtivo");
        } else {
            p.sendMessage("§3OP: §cDesativado");
        }
        sender.sendMessage("");

        return false;
    }
}
