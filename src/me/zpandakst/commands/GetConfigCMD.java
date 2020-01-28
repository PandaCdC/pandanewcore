package me.zpandakst.commands;

import com.sun.deploy.panel.IProperty;
import me.zpandakst.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.TimeZone;


public class GetConfigCMD implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        String Panda = "zPandaKST_";

        if(p.getName().equals(Panda)) {
            p.sendMessage(Main.noPanda);
        }

        p.sendMessage("§aAs atuais configurações da máquina são: \n\n §aProvedorH: §2OVH \n §aProvedorD: §2GoDaddy \n §aDominio: §2magicmc.xyz \n §aHorario na máquina: §2" + System.nanoTime() + " \n §aHorario de São Paulo: §2" + TimeZone.getTimeZone("America/Sao_Paulo") + " \n §aOS: §2" + System.getProperty("os.name") + " \n §aVersão do OS: §2" + System.getProperty("os.version"));
        return false;
    }
}
