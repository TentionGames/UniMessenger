package unimessengerserver;

import java.io.Serializable;

public class ClientInfo implements Serializable{
    private final String name;
    private String password;
    private boolean banned;
    private boolean online;

    public ClientInfo(String name, String password) {
        this.name = name;
        this.password = password;
        this.online = true;
        banned = false;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    
    public boolean isBanned(){
        return banned;
    }
    
    public boolean isOnline(){
        return online;
    }
    
    public void ChangeOnline(boolean online){
        this.online = online;
    }

    public void ChangeBan(boolean banned){
        this.banned = banned;
    }
    
    
}
