package me.zpandakst;

import me.zpandakst.commands.*;
import me.zpandakst.sql.*;
import me.zpandakst.events.*;
import net.eduard.api.lib.BukkitConfig;
import net.eduard.api.lib.manager.DBManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    // Strings
    public static String noPerm;
    public static String noPanda;
    public static String prefix;
    public static String consoleBlock;

    // Instance

    public static Main plugin;

    public static Plugin getPlugin() {
        return (Plugin) plugin;
    }

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    public static BukkitConfig config;

    public void onEnable() {
        // STRINGS
        prefix = "§5§lMagic§f§lMC";
        noPanda = "§c§lERRO §7Você precisa ser o Panda para executar esse comando!";
        noPerm = "§c§lERRO §7Você não tem permissão para isso!";
        consoleBlock = "Você não pode fazer isso no CLIENT!";

        // Plugin ENABLE
        Bukkit.getConsoleSender().sendMessage("§ePLUGIN §fInstanciando a MAIN...");
        instance = this;
        Bukkit.getConsoleSender().sendMessage("§aPLUGIN §fMain instanciada!");
        Bukkit.getConsoleSender().sendMessage("§ePLUGIN §fGerando configs...");
        config = new BukkitConfig("config.yml", this);
        Bukkit.getConsoleSender().sendMessage("§aPLUGIN §fConfigs geradas com sucesso!");
        Bukkit.getConsoleSender().sendMessage("§ePLUGIN §fCarregando comandos...");
        commands();
        Bukkit.getConsoleSender().sendMessage("§aPLUGIN §fComandos carregados!");
        Bukkit.getConsoleSender().sendMessage("§ePLUGIN §fCarregando eventos...");
        registerEvents();
        Bukkit.getConsoleSender().sendMessage("§aPLUGIN §fEventos carregados com sucesso!");
        Bukkit.getConsoleSender().sendMessage("§ePLUGIN §fFazendo §a§lDOWNLOAD §fda lista de procedimentos §a§lMySQL §4GEARMC §fpara continuar os processos...");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§ePLUGIN §fIniciando conexão MySQL...");

        // MySQL

        GroupManager.setDatabase(new DBManager("root", "Tornado135@", "localhost", "pandacore"));
        HistoricGroupsManager.setDatabase(new DBManager("root", "Tornado135@", "localhost", "pandacore"));
        GroupManager.getDatabase().openConnection();
        HistoricGroupsManager.getDatabase().openConnection();
        if (GroupManager.getDatabase().hasConnection()) {
            if (HistoricGroupsManager.getDatabase().hasConnection()) {
                HistoricGroupsManager.reload();
                GroupManager.reload();
            }
        }
        Bukkit.getConsoleSender().sendMessage("§aPLUGIN §fMySQL conectado!");
        Bukkit.getConsoleSender().sendMessage("§aPLUGIN §fPlugin ativado 100%!");
        Bukkit.broadcastMessage("§ePLUGIN §fPlugin das redes GearMC ativado!");

    }

    public void onDisable() {
        Bukkit.broadcastMessage("§ePLUGIN §fPlugin das redes GearMC em processo de desativação!");
        Bukkit.broadcastMessage("Bye...");
        Bukkit.getConsoleSender().sendMessage("Bye...");
    }

    public void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new ChatFormat(), this);
        Bukkit.getPluginManager().registerEvents(new DontRainEvent(), this);
        Bukkit.getPluginManager().registerEvents(new DontSpyEvent(), this);
        Bukkit.getPluginManager().registerEvents(new EmergencyKillServerEvent(), this);
        Bukkit.getPluginManager().registerEvents(new NoOpReloadEvent(), this);
        Bukkit.getPluginManager().registerEvents(new SecurityOpEvent(), this);
        Bukkit.getPluginManager().registerEvents(new OnJoin(), this);
    }

    public void commands() {
        getCommand("cc").setExecutor(new ChatClearCMD());
        getCommand("chatclear").setExecutor(new ChatClearCMD());
        // TAG
        getCommand("pentcheck").setExecutor(new PentCheckCMD());
        getCommand("account").setExecutor(new AccountInfoCMD());
        getCommand("fly").setExecutor(new FlyCMD());
        getCommand("voar").setExecutor(new FlyCMD());
        getCommand("forcechat").setExecutor(new ForceCommandCMD());
        getCommand("setspawn").setExecutor(new SetSpawnCMD());
        getCommand("spawn").setExecutor(new GotoSpawnCMD());
        getCommand("checkkey").setExecutor(new GetChangesCMD());
        getCommand("getconfig").setExecutor(new GetConfigOptionCMD());
        getCommand("setrank").setExecutor(new SetRankCMD());
    }
}
