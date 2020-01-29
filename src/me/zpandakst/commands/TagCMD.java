package me.zpandakst.commands;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class TagCMD implements Listener, CommandExecutor {
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("tag")) {
            if (args.length == 0) {
                p.sendMessage("§6§lGear§f§lMC §aUse §f/tag <tag> §a para alterar sua tag!");
                if (p.hasPermission("group.dono")) {
                    p.sendMessage("§6§lGear§f§lMC §aVocê possui as tags: §4§l§oDONO§f, §4§l§oSUBDONO§f, §c§l§oGERENTE§f, §c§l§oADMIN§f, §5§l§oMODERADOR§f, §5§l§oTRIAL§f, §9§l§oHELPER+, §9§l§oHELPER, §b§lYOUTUBER§f, §3§lVIP+§f, §6§lVIP§f, §7§lMEMBRO.");
                }
                else if (p.hasPermission("group.subdono")) {
                    p.sendMessage("§6§lGear§f§lMC §aVocê possui as tags: §c§l§oSUBDONO§f, §4§l§oGERENTE§f, §c§l§oADMIN§f, §5§l§oMODERADOR§f, §5§l§oTRIAL§f, §9§l§oHELPER+, §9§l§oHELPER, §b§lYOUTUBER§f, §3§lVIP+§f, §6§lVIP§f, §7§lMEMBRO.");
                } else if (p.hasPermission("group.gerente")) {
                    p.sendMessage("§6§lGear§f§lMC §aVocê possui as tags: §c§l§oGERENTE§f, §c§l§oADMIN§f, §5§l§oMODERADOR§f, §5§l§oTRIAL§f, §9§l§oHELPER+, §9§l§oHELPER, §b§lYOUTUBER§f, §3§lVIP+§f, §6§lVIP§f, §7§lMEMBRO.");
                }
                return true;
            }
            if (p.getName().equals("zPandakST_")) {
                if (args[0].equalsIgnoreCase("ceo")) {
                    p.sendMessage("§fSua tag foi alterada para §4§lCEO§a.");
                    p.setDisplayName("§4§l§oCEO §7" + p.getName());
                    p.setPlayerListName("§4§l§oCEO §7" + p.getName());
                }
                else if (args[0].equalsIgnoreCase("dono")) {
                    p.sendMessage("§aSua tag foi alterada para §4§l§oDONO§a.");
                    p.setDisplayName("§4§l§oDONO §7" + p.getName());
                    p.setPlayerListName("§4§l§oDONO §7" + p.getName());
                }
                else if (args[0].equalsIgnoreCase("subdono")) {
                    p.sendMessage("§aSua tag foi alterada para §5§lMOD§a.");
                    p.setDisplayName("§5§l§lSUBDONO §7" + p.getName());
                    p.setPlayerListName("§5§l§oSUBDONO §7" + p.getName());
                }
                else if (args[0].equalsIgnoreCase("gerente")) {
                    p.sendMessage("§6§lLion§c§lMC §a - Sua tag foi alterada para §e§lHELPER§a.");
                    p.setDisplayName("§e§lHELPER§e " + p.getName());
                    p.setPlayerListName("§e§lHELPER§e " + p.getName());
                }
            }
            else {
                p.sendMessage("§6§lLion§c§lMC §a - Voc\u00ea n\u00e3o tem permiss\u00e3o para fazer isto!");
            }
            if ((p.isOp() || !p.isOp()) && args[0].equalsIgnoreCase("membro")) {
                p.sendMessage("§6§lLion§c§lMC §a - Sua tag foi alterada para §7§lMEMBRO§a.");
                p.setDisplayName("§7§lMEMBRO §7" + p.getName());
                p.setPlayerListName("§7§lMEMBRO §7" + p.getName());
            }
        }
        if (cmd.getName().equalsIgnoreCase("costumizar")) {
            if (p.isOp()) {
                if (args.length == 0) {
                    p.sendMessage("§6§lLion§c§lMC §a - Para costumizar uma tag use: §f/costumizar <nick> <tag>");
                    p.sendMessage("§6§lLion§c§lMC §a - Esta tag \u00e9 tempor\u00e1ria!");
                    return true;
                }
                final Player t = Bukkit.getPlayer(args[0]);
                if (t == null) {
                    p.sendMessage("§6§lLion§c§lMC §c- Este usu\u00e1rio n\u00e3o foi encontradO, desculpe!");
                    return true;
                }
                if (args.length == 1) {
                    p.sendMessage("§6§lLion§c§lMC §a - Voc\u00ea precisa colocar a tag! Use: §f/costumizar <player> <tag>");
                    return true;
                }
                final String tag = args[1].replace("&", "§");
                t.setDisplayName(String.valueOf(tag) + " " + t.getName());
                t.setPlayerListName(String.valueOf(tag) + " " + t.getName());
                p.sendMessage("§6§lLion§c§lMC §f\u279c§a O usu\u00e1rio teve seu cargo costumizado!");
                t.sendMessage("§6§lLion§c§lMC §f\u279c§a Sua tag foi alterada temporariamente por §f" + p.getName() + "§a, ao relogar ela ir\u00e1 sumir!");
            }
            else {
                p.sendMessage("§6§lLion§c§lMC §a - Voc\u00ea n\u00e3o tem permiss\u00e3o!");
            }
        }
        return false;
    }
}

// p.sendMessage("§6§lTAGS do servidor: §4§l§oCEO§f, §4§l§oDONO§f, §4§l§oSUBDONO§f, §4§l§oGERENTE§f, §c§l§oADMIN§f, §5§l§oMODERADOR§f, §5§l§oTRIAL§f, §9§l§oHELPER+, §9§l§oHELPER, §b§lYOUTUBER§f, §3§lVIP+§f, §6§lVIP§f, §7§lMEMBRO.");