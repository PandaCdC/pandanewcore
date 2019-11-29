package me.zpandakst.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import me.zpandakst.accountmanagment.Estados;
import me.zpandakst.accountmanagment.Groups;
import net.eduard.api.lib.Mine;
import net.eduard.api.lib.manager.DBManager;

public class BugReportManager {

    private static ArrayList<PlayerGroupList> cargos = new ArrayList<>();

    private static DBManager database;

    public static void setarPrimeiroCargo(String nickname, String author, String ip, Groups tipo, Estados tipo2) {
        PlayerGroupList group = new PlayerGroupList();
        group.setJogador(nickname);
        group.setAuthor(author);
        group.setIp(ip);
        group.setCargo(tipo);
        group.setEstado(tipo2);
        cargos.add(group);
        int id = database.insert("bugreport", group.getJogador(), group.getAuthor(), group.getIp(), group.getCargo(), group.getEstado());
        group.setRegisterId(id);
        cargos.add(group);
    }

    public static void mudarCargo(PlayerGroupList group, Groups tipo) {
        group.setCargo(tipo);
        database.change("bugreport", "cargo =?", "nickname = ?", tipo, group.getJogador());
    }

    public static void mudarEstado(PlayerGroupList group, Estados estado) {
        group.setEstado(estado);
        database.change("groupmanager_staff", "estado =?", "nickname =?", estado, group.getJogador());
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
        database.delete("bugreport", "nickname =?", "nickname");
    }

    public static void resetAllAccounts() {
        database.clearTable("groupmanager_staff");
    }

    public static void reload() {
        ResultSet query = database.select("SELECT * FROM `bugreport`");
        try {
            while (query.next()) {
                try {
                    PlayerGroupList group = new PlayerGroupList();
                    group.setRegisterId(query.getInt("id"));
                    group.setJogador(query.getString("nickname"));
                    group.setAuthor(query.getString("author"));
                    group.setIp(query.getString("ip"));
                    group.setCargo(Groups.valueOf(query.getString("cargo").toUpperCase()));
                    group.setEstado(Estados.valueOf(query.getString("estado").toUpperCase()));
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
        BugReportManager.database = database;
    }

    public static ArrayList<PlayerGroupList> getCargos() {
        return cargos;
    }

    public static void setCargos(ArrayList<PlayerGroupList> cargos) {
        GroupManager.cargos = cargos;
    }

}