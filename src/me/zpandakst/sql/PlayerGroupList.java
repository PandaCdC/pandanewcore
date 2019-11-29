package me.zpandakst.sql;

import me.zpandakst.accountmanagment.Estados;
import me.zpandakst.accountmanagment.Groups;

public class PlayerGroupList {

    private String ip;
    private String jogador;
    private String author;
    private String id;
    private Groups group;
    private Estados estado;

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

    public Groups getCargo() {
        return group;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setCargo(Groups groups) {
        this.group = groups;
    }

    public void setEstado(Estados estados) {
        this.estado = estados;
    }

    private int registerId;

    public int getRegisterId() {

        return registerId;
    }

    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }

}
