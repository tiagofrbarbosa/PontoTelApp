package io.github.tiagofrbarbosa.pontotelapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by tfbarbosa on 05/03/18.
 */

public class UserList {

    @SerializedName("data")
    private ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers(){
        return users;
    }

    public void setUsers(ArrayList<User> users){
        this.users = users;
    }
}
