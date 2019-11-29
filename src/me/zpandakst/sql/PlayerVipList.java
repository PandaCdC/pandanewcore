package me.zpandakst.sql;

import me.zpandakst.accountmanagment.GroupsVips;

public class PlayerVipList {

    private String ip;
    private String jogador;
    private String author;
    private String id;
    private GroupsVips vip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAuthor() {
        return author;
    }

    public String getId() {
        return id;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GroupsVips getVip() {
        return vip;
    }

    public void setVip(GroupsVips vips) {
        this.vip = vips;
    }

    private int registerId;

    public int getRegisterId() {

        return registerId;
    }

    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }

}
