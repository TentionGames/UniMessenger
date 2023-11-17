package com.mycompany.tennertcomserver;

import java.util.ArrayList;

public class Datenbank {
    static ArrayList<ClientInfo> accs = new ArrayList();
    
    public static ClientInfo newAccount(String name, String password){
        if(checkForPassword(name) != null) return null;
        ClientInfo clientInfo = new ClientInfo(name.trim(), password.trim());
        accs.add(clientInfo);
        return clientInfo;
    }
    
    public static ClientInfo checkForPassword(String name){
        for (ClientInfo acc : accs) {
            if(acc.name.equals(name)) return acc;
        }
        return null;
    }
}
