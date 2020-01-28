package me.zpandakst.commands;

        import me.zpandakst.Main;
        import me.zpandakst.sql.HistoricGroupsManager;
        import org.bukkit.command.Command;
        import org.bukkit.command.CommandExecutor;
        import org.bukkit.command.CommandSender;
        import org.bukkit.entity.Player;

public class GetChangesCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("checkkey")) {
            if (!(sender.hasPermission("gearmc.cmd.getchanges"))) {
                sender.sendMessage(Main.noPerm);
                return false;
            }

            if(args.length >= 0) {
                p.sendMessage("Opa amigo... Falta colocar a KEY!");
            }

            String key = args[0];
            p.sendMessage("§e======== §6CHANGES §e======== \n §e» Nickname: §6" + HistoricGroupsManager.pegarCargoKEY(key).getJogador() + "\n §e» Autor: §6" + HistoricGroupsManager.pegarCargoKEY(key).getAuthor() + "\n §e» Cargo: §6" + HistoricGroupsManager.pegarCargoKEY(key).getCargo() + "\n §e» Estado: §6" + HistoricGroupsManager.pegarCargoKEY(key).getEstado() + "\n §e» Key: §6" + key + "\n\n §cOBS: §7Isso é uma alteração salva em nosso historico, não é o cargo atual do jogador e não é possível ser alterada ou deletada! Para verificar o cargo atual do jogador digite: /accountinfo <nickname>!");

            return false;
        }
        return false;
    }
}