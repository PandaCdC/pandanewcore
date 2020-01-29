package me.zpandakst.commands;

import me.zpandakst.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.TimeZone;

public class GetConfigOptionCMD implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(!p.getName().equals("zPandaKST_")) {
            p.sendMessage(Main.noPanda);
        }
        if (args[0].equalsIgnoreCase("host") || args[0].equalsIgnoreCase("provedorh")) {
            p.sendMessage("§aNosso atual provedor: §2OVH");
            return false;
        }
        if(args[0].equalsIgnoreCase("provedord")) {
            p.sendMessage("§aNosso atual provedor de dominio: §2GoDaddy");
            return false;
        }
        if(args[0].equalsIgnoreCase("dominio") || args[0].equalsIgnoreCase("domain")) {
            p.sendMessage("§aNosso atual dominio: §2magicmc.xyz");
            return false;
        }
        if(args[0].equalsIgnoreCase("machinetime")) {
            p.sendMessage("§aHorario atual da máquina: §2" + System.nanoTime());
            return false;
        }
        if(args[0].equalsIgnoreCase("zonetime")) {
            p.sendMessage("§aHorario atual em SP: §2" + TimeZone.getTimeZone("America/Sao_Paulo").toString());
            return false;
        }
        if(args[0].equalsIgnoreCase("os") || args[0].equalsIgnoreCase("system")) {
            p.sendMessage("§aNosso atual sistema operacional: §2" + System.getProperty("os.name"));
            return false;
        }
        if(args[0].equalsIgnoreCase("os_version")) {
            p.sendMessage("§aVersão do sistema operacional: §2" + System.getProperty("os.version"));
            return false;
        }
        if(args[0].equalsIgnoreCase("os_arch")) {
            p.sendMessage("§aNão identificado: §2" + System.getProperty("os.arch"));
            return false;
        }
        if(args[0].equalsIgnoreCase("java_version")) {
            p.sendMessage("§aVersão atual do java: §2" + System.getProperty("java.version"));
            return false;
        }
        if(args[0].equalsIgnoreCase("all")) {
            p.sendMessage("§aAs atuais configurações da máquina são: \n\n §aProvedorH: §2OVH \n §aProvedorD: §2GoDaddy \n §aDominio: §2magicmc.xyz \n §aHorario na máquina: §2" + System.currentTimeMillis() + " \n §aHorario de São Paulo: §2" + TimeZone.getTimeZone("America/Sao_Paulo") + " \n §aOS: §2" + System.getProperty("os.name") + " \n §aVersão do OS: §2" + System.getProperty("os.version"));
        }
        return false;
    }
}
