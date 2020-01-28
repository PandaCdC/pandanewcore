package me.zpandakst.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import me.zpandakst.accountmanagment.GroupsVips;
import net.eduard.api.lib.Mine;
import net.eduard.api.lib.manager.DBManager;

public class VipManager {

    private static ArrayList<PlayerVipList> vips = new ArrayList<>();

    private static DBManager database;

    public static void setarPrimeiroVip(String nickname, String author, String ip, GroupsVips tipo) {
        PlayerVipList vip = new PlayerVipList();
        vip.setJogador(nickname);
        vip.setAuthor(author);
        vip.setIp(ip);
        vip.setVip(tipo);
        vips.add(vip);
        int id = database.insert("groupmanager_vip", vip.getJogador(), vip.getAuthor(), vip.getIp(), vip.getVip());
        vip.setRegisterId(id);
        vips.add(vip);
    }

    public static void mudarVip(PlayerVipList vip, GroupsVips tipo) {
        vip.setVip(tipo);
        database.change("groupmanager_vip", "vip =?", "nickname = ?", tipo, vip.getJogador());
    }

    public static PlayerVipList pegarVip(String jogador) {
        for (PlayerVipList vip : vips) {
            if (vip.getJogador().equalsIgnoreCase(jogador)) {
                return vip;
            }

        }
        return null;

    }

    public static void resetAccount(String nickname) {
        database.delete("groupmanager_vip", "nickname =?", "nickname");
    }

    public static void resetAllAccounts() {
    database.clearTable("groupmanager_vip");
    }

    public static void reload() {
        ResultSet query = database.select("SELECT * FROM `groupmanager_vip`");
        try {
            while (query.next()) {
                try {
                    PlayerVipList vip = new PlayerVipList();
                    vip.setRegisterId(query.getInt("id"));
                    vip.setJogador(query.getString("nickname"));
                    vip.setAuthor(query.getString("author"));
                    vip.setIp(query.getString("ip"));
                    vip.setVip(GroupsVips.valueOf(query.getString("vip").toUpperCase()));
                    getVips().add(vip);

                } catch (Exception e) {
                    Mine.console("Erro ao puxar VIP da tabela " + e);
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
        VipManager.database = database;
    }

    public static ArrayList<PlayerVipList> getVips() {
        return vips;
    }

    public static void setVips(ArrayList<PlayerVipList> vips) {
        VipManager.vips = vips;
    }

}