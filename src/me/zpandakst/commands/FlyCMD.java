package me.zpandakst.commands;

import me.zpandakst.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.consoleBlock);
            return true;
        }
        if (args.length > 1) {
            sender.sendMessage(("§c§lERRO §fUtilize: /fly ou /fly <nick>"));
            return true;
        } else {
            if (!p.hasPermission("gearmc.cmd.fly")) {
                p.sendMessage(Main.noPerm);
                return true;
            } else {
                if (args.length == 0) {
                    if (!p.getAllowFlight()) {
                        p.setAllowFlight(true);
                        p.setFlying(true);
                        sender.sendMessage("§3§lFLY §fVocê habilitou o modo voar.");
                    } else {
                        p.setAllowFlight(false);
                        p.setFlying(false);
                        sender.sendMessage("§3§lFLY §fVocê desabilitou o modo voar.");
                    }
                } else {
                    Player t = sender.getServer().getPlayer(args[0]);
                    if (t == null) {
                        sender.sendMessage("§c§lERRO §fJogador offline.");
                        return true;
                    } else {
                        if (!t.getAllowFlight()) {
                            t.setAllowFlight(true);
                            t.setFlying(true);
                            t.sendMessage(
                                    "§a§lFLY §fO staffer §a" + p.getDisplayName() + " §fhabilitou seu modo voar.");
                            p.sendMessage("§a§lFLY §fVocê habilitou o modo voar de §a" + t.getDisplayName());
                        } else {
                            t.setAllowFlight(false);
                            t.setAllowFlight(false);
                            t.setFlying(false);
                            t.sendMessage(
                                    "§3§lFLY §fO staffer §a" + p.getDisplayName() + " §fdesabilitou seu modo voar.");
                            sender.sendMessage("§3§lFLY §fVocê desabilitou o modo voar de §a" + t.getDisplayName());
                        }
                    }
                }
            }

        }

        return false;
    }
}