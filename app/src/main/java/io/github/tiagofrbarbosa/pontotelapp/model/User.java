package io.github.tiagofrbarbosa.pontotelapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by tfbarbosa on 05/03/18.
 */

public class User implements Serializable{

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("pwd")
    private String pwd;

    public User() {
    }

    public User(String id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
