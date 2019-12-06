package me.zpandakst.sql;

import me.zpandakst.accountmanagment.Estados;
import me.zpandakst.accountmanagment.GeneralGroups;

public class GeneralGroupList {

    private String id;
    private String nickname;
    private String autor;
    private String ip;
    private GeneralGroups group;
    private Estados estado;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAutor() {
        return autor;
    }

    public String getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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

    private int registerId;

    public int getRegisterId() {

        return registerId;
    }

    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }

}