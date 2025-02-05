package org.example;

public class Admin {
    private String username;
    private String password;

    void setUsername(String username){
        this.username = username;
    }

    void setPassword(String password){
        this.password = password;
    }

    String getUsername(){
        return username;
    }

    String getPassword(){
        return password;
    }
}
