package me.zpandakst.commands;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class TagCMD implements CommandExecutor, Listener {
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§6§lGear§f§lMC §7> §cApenas jogadores podem usar isso.");
            return true;
        }
        Player p = (Player) sender;
            if (args.length == 0) {
                p.sendMessage("§6§lTAGS do servidor: §4§l§oCEO§f, §4§l§oDONO§f, §4§l§oSUBDONO§f, §4§l§oGERENTE§f, §c§l§oADMIN§f, §5§l§oMODERADOR§f, §5§l§oTRIAL§f, §9§l§oHELPER+, §9§l§oHELPER, §b§lYOUTUBER§f, §3§lVIP+§f, §6§lVIP§f, §7§lMEMBRO.");
                return true;
            }
            if (p.hasPermission("tag.ceo")) {
                if (args[0].equalsIgnoreCase("ceo")) {
                    p.sendMessage("Sua tag foi alterada para §4§l§oCEO§f.");
                    p.setDisplayName("§4§l§oCEO §7" + p.getName());
                    p.setPlayerListName("§4§l§oCEO §7" + p.getName());
                }
            } else {
                p.sendMessage("§7Você não tem permissão para usar essa tag " + p.getName());
            }
            if (p.hasPermission("tag.dono")) {
                if (args[0].equalsIgnoreCase("dono")) {
                    p.sendMessage("Sua tag foi alterada para §4§l§oDONO§f.");
                    p.setDisplayName("§4§l§oDONO §7" + p.getName());
                    p.setPlayerListName("§4§l§oDONO §7" + p.getName());
                }
            } else {
                p.sendMessage("§7Você não tem permissão para usar essa tag " + p.getName());
            }
            if (p.hasPermission("tag.subdono")) {
                if (args[0].equalsIgnoreCase("subdono")) {
                    p.sendMessage("Sua tag foi alterada para §4§l§oSUBDONO§f.");
                    p.setDisplayName("§4§l§oSUBDONO §7" + p.getName());
                    p.setPlayerListName("§4§l§oSUBDONO §7" + p.getName());
                }
            } else {
                p.sendMessage("§7Você não tem permissão para usar essa tag " + p.getName());
            }
            if (p.hasPermission("tag.gerente")) {
                if (args[0].equalsIgnoreCase("gerente")) {
                    p.sendMessage("Sua tag foi alterada para §4§l§oGERENTE§f.");
                    p.setDisplayName("§4§l§oGERENTE §7" + p.getName());
                    p.setPlayerListName("§4§l§oGERENTE §7" + p.getName());
                }
            } else {
                p.sendMessage("§7Você não tem permissão para usar essa tag " + p.getName());
            }
            if (p.hasPermission("tag.admin")) {
                if (args[0].equalsIgnoreCase("admin")) {
                    p.sendMessage("Sua tag foi alterada para §c§l§oADMIN§f.");
                    p.setDisplayName("§c§l§oADMINISTRADOR §7" + p.getName());
                    p.setPlayerListName("§c§l§oADMIN §7" + p.getName());
                }
            } else {
                p.sendMessage("§7Você não tem permissão para usar essa tag " + p.getName());
            }
            if (p.hasPermission("tag.mod")) {
                if (args[0].equalsIgnoreCase("mod") || args[0].equalsIgnoreCase("moderador")) {
                    p.sendMessage("Sua tag foi alterada para §5§l§oMOD§f.");
                    p.setDisplayName("§5§l§oMODERADOR §7" + p.getName());
                    p.setPlayerListName("§5§l§oMOD §7" + p.getName());
                }
            } else {
                p.sendMessage("§7Você não tem permissão para usar essa tag " + p.getName());
            }
            if (p.hasPermission("tag.trial")) {
                if (args[0].equalsIgnoreCase("trial")) {
                    p.sendMessage("Sua tag foi alterada para §5§lTRIAL§f.");
                    p.setDisplayName("§5§l§oTRIAL-MOD §7" + p.getName());
                    p.setPlayerListName("§5§l§oTRIALMOD §7" + p.getName());
                }
            } else {
                p.sendMessage("§7Você não tem permissão para usar essa tag " + p.getName());
            }
            if (p.hasPermission("tag.helperplus")) {
                if (args[0].equalsIgnoreCase("helper+")) {
                    p.sendMessage("Sua tag foi alterada para §9§lHELPER+§f.");
                    p.setDisplayName("§9§l§oHELPER+ §7" + p.getName());
                    p.setPlayerListName("§9§l§olHELPER+ §7" + p.getName());
                }
            } else {
                p.sendMessage("§7Você não tem permissão para usar essa tag " + p.getName());
            }
            if (p.hasPermission("tag.helper")) {
                if (args[0].equalsIgnoreCase("helper")) {
                    p.sendMessage("Sua tag foi alterada para §9§lHELPER§f.");
                    p.setDisplayName("§9§l§oHELPER §7" + p.getName());
                    p.setPlayerListName("§9§l§olHELPER §7" + p.getName());
                }
            } else {
                p.sendMessage("§7Você não tem permissão para usar essa tag " + p.getName());
            }
            if (p.hasPermission("tag.youtuber")) {
                if (args[0].equalsIgnoreCase("youtuber")) {
                    p.sendMessage("Sua tag foi alterada para §b§lYOUTUBER§f.");
                    p.setDisplayName("§b§l§oYOUTUBER §7" + p.getName());
                    p.setPlayerListName("§b§l§oYOUTUBER §7" + p.getName());
                }
            } else {
                p.sendMessage("§7Você não tem permissão para usar essa tag " + p.getName());
            }
            if (p.hasPermission("tag.vip+")) {
                if (args[0].equalsIgnoreCase("vip+")) {
                    p.sendMessage("Sua tag foi alterada para §3§lVIP+§f.");
                    p.setDisplayName("§3§l§oVIP+ §7" + p.getName());
                    p.setPlayerListName("§3§l§oVIP+ §7" + p.getName());
                }
            } else {
                p.sendMessage("§7Você não tem permissão para usar essa tag " + p.getName());
            }
            if (p.hasPermission("tag.vip")) {
                if (args[0].equalsIgnoreCase("vip")) {
                    p.sendMessage("Sua tag foi alterada para §6§lVIP§f.");
                    p.setDisplayName("§6§l§oVIP §7" + p.getName());
                    p.setPlayerListName("§6§l§oVIP §7" + p.getName());
                }
            } else {
                p.sendMessage("§7Você não tem permissão para usar essa tag " + p.getName());
            }
            if (args[0].equalsIgnoreCase("membro")) {
                p.sendMessage("Sua tag foi alterada para §7§lMEMBRO");
                p.setDisplayName("§7§lMEMBRO §7" + p.getName());
                p.setPlayerListName("§7§lMEMBRO §7" + p.getName());
            }
        return false;
    }
}
