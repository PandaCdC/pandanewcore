package me.zpandakst.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import me.zpandakst.accountmanagment.GeneralGroups;
import net.eduard.api.lib.Mine;
import net.eduard.api.lib.manager.DBManager;

public class GeneralGroupManager {

    private static ArrayList<GeneralGroupList> cargos = new ArrayList<>();

    private static DBManager database;

    public static void primeiroRegistro(String nickname, String autor, String ip, GeneralGroups tipo) {
        GeneralGroupList group = new GeneralGroupList();
        group.setNickname(nickname);
        group.setAutor(autor);
        group.setIp(ip);
        group.setCargo(tipo);
        cargos.add(group);
        int id = database.insert("groupmanager_geral", group.getNickname(), group.getAutor(), group.getIp(), group.getCargo());
        group.setRegisterId(id);
        cargos.add(group);
    }

    public static void mudarCargo(GeneralGroupList group, GeneralGroups tipo) {
        group.setCargo(tipo);
        database.change("groupmanager_geral", "group =?", "nickname = ?", tipo, group.getCargo());
    }


    public static GeneralGroupList pegarCargo(String jogador) {
        for (GeneralGroupList cargo : cargos) {
            if (cargo.getNickname().equalsIgnoreCase(jogador)) {
                return cargo;
            }

        }
        return null;
    }

    public static void reload() {
        ResultSet query = database.select("SELECT * FROM `groupmanager_geral`");
        try {
            while (query.next()) {
                try {
                    GeneralGroupList group = new GeneralGroupList();
                    group.setRegisterId(query.getInt("id"));
                    group.setNickname(query.getString("nickname"));
                    group.setAutor(query.getString("autor"));
                    group.setIp(query.getString("autor_ip"));
                    group.setCargo(GeneralGroups.valueOf(query.getString("group").toUpperCase()));
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
        GeneralGroupManager.database = database;
    }

    public static ArrayList<GeneralGroupList> getCargos() {
        return cargos;
    }

    public static void setCargos(ArrayList<GeneralGroupList> cargos) {
        GeneralGroupManager.cargos = cargos;
    }

}