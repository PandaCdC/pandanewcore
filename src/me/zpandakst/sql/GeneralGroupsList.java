package me.zpandakst.sql;

import me.zpandakst.accountmanagment.Estados;
import me.zpandakst.accountmanagment.GeneralGroups;

public class GeneralGroupsList {

    private String id;
    private String jogador;
    private String author;
    private String ip;
    private GeneralGroups group;
    private Estados estado;
    private long date;
    private String key;

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

    public GeneralGroups getCargo() {
        return group;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setCargo(GeneralGroups groups) {
        this.group = groups;
    }

    public void setEstado(Estados estados) {
        this.estado = estados;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    private int registerId;

    public int getRegisterId() {

        return registerId;
    }

    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }

}
