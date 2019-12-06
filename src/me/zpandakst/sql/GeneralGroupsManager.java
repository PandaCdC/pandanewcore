package me.zpandakst.sql;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import me.zpandakst.accountmanagment.Estados;
import me.zpandakst.accountmanagment.GeneralGroups;
import net.eduard.api.lib.Mine;
import net.eduard.api.lib.manager.DBManager;
import net.eduard.api.lib.modules.Extra;

public class GeneralGroupsManager {

    private static ArrayList<GeneralGroupsList> cargos = new ArrayList<>();

    private static DBManager database;

    public static void registerCargo(String nickname, String author, String ip, GeneralGroups tipo, Estados tipo2) {
        GeneralGroupsList group = new GeneralGroupsList();
        group.setJogador(nickname);
        group.setAuthor(author);
        group.setIp(ip);
        group.setCargo(tipo);
        group.setEstado(tipo2);
        group.setDate(System.currentTimeMillis());
        group.setKey(Extra.newKey(Extra.KeyType.ALPHANUMERIC, 8));
        cargos.add(group);
        int id = database.insert("groupmanager_general", group.getJogador(), group.getAuthor(), group.getIp(), group.getCargo(), group.getEstado(), new Date(group.getDate()), group.getKey());
        group.setRegisterId(id);
        cargos.add(group);
    }

    public static GeneralGroupsList pegarCargo(String jogador) {
        for (GeneralGroupsList cargo : cargos) {
            if (cargo.getJogador().equalsIgnoreCase(jogador)) {
                return cargo;
            }

        }
        return null;
    }

    public static GeneralGroupsList pegarCargoKEY(String id) {
        for(GeneralGroupsList cargo : cargos) {
            if(cargo.getKey().equalsIgnoreCase(id)) {
            return cargo;
        }

    }
        return null;
}

    public static void reload() {
        ResultSet query = database.select("SELECT * FROM `groupmanager_general`");
        try {
            while (query.next()) {
                try {
                    GeneralGroupsList group = new GeneralGroupsList();
                    group.setRegisterId(query.getInt("id"));
                    group.setJogador(query.getString("jogador"));
                    group.setAuthor(query.getString("author"));
                    group.setIp(query.getString("ip"));
                    group.setCargo(GeneralGroups.valueOf(query.getString("group").toUpperCase()));
                    group.setEstado(Estados.valueOf(query.getString("estado").toUpperCase()));
                    group.setDate(query.getTimestamp("data").getTime());
                    group.setKey(query.getString("group_key"));
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
        GeneralGroupsManager.database = database;
    }

    public static ArrayList<GeneralGroupsList> getCargos() {
        return cargos;
    }

    public static void setCargos(ArrayList<GeneralGroupsList> cargos) {
        GeneralGroupsManager.cargos = cargos;
    }

}