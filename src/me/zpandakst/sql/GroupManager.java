package me.zpandakst.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import me.zpandakst.accountmanagment.Groups;
import net.eduard.api.lib.Mine;
import net.eduard.api.lib.manager.DBManager;

public class GroupManager {

    private static ArrayList<PlayerGroupList> cargos = new ArrayList<>();

    private static DBManager database;

    public static void setarPrimeiroCargo(String nickname, String author, String ip, Groups tipo) {
        PlayerGroupList group = new PlayerGroupList();
        group.setJogador(nickname);
        group.setAuthor(author);
        group.setIp(ip);
        group.setCargo(tipo);
        cargos.add(group);
        int id = database.insert("groupmanager_staff", group.getJogador(), group.getAuthor(), group.getIp(), group.getCargo());
        group.setRegisterId(id);
        cargos.add(group);
    }

    public static void mudarCargo(PlayerGroupList group, Groups tipo) {
        group.setCargo(tipo);
        database.change("groupmanager_staff", "cargo =?", "nickname = ?", tipo, group.getJogador());
    }

    public static PlayerGroupList pegarCargo(String jogador) {
        for (PlayerGroupList cargo : cargos) {
            if (cargo.getJogador().equalsIgnoreCase(jogador)) {
                return cargo;
            }

        }
        return null;

    }

    public static void resetAccount(String nickname) {
        database.delete("groupmanager_staff", "nickname =?", "nickname");
    }

    public static void resetAllAccounts() {
        database.clearTable("groupmanager_staff");
    }

    public static void reload() {
        ResultSet query = database.select("SELECT * FROM `groupmanager_staff`");
        try {
            while (query.next()) {
                try {
                    PlayerGroupList group = new PlayerGroupList();
                    group.setRegisterId(query.getInt("id"));
                    group.setJogador(query.getString("nickname"));
                    group.setAuthor(query.getString("author"));
                    group.setIp(query.getString("ip"));
                    group.setCargo(Groups.valueOf(query.getString("cargo").toUpperCase()));
                    getCargos().add(group);

                } catch (Exception e) {
                    Mine.console("Erro ao puxar CARGO da tabela " + e);
                }

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static DBManager getDatabase() {
        return database;
    }

    public static void setDatabase(DBManager database) {
        GroupManager.database = database;
    }

    public static ArrayList<PlayerGroupList> getCargos() {
        return cargos;
    }

    public static void setCargos(ArrayList<PlayerGroupList> cargos) {
        GroupManager.cargos = cargos;
    }

}