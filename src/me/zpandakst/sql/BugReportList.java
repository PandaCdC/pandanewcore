package me.zpandakst.sql;

import me.zpandakst.accountmanagment.Estados;
import me.zpandakst.accountmanagment.Groups;

public class BugReportList {

    private String id;
    private String nickname;
    private Groups bug;
    private long data;
    private Estados estado;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


    public String getId() {
        return id;
    }

    public String getNickname() {
        return nickname
                ;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
