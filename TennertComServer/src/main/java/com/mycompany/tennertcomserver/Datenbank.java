/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tennertcomserver;

import java.util.ArrayList;

/**
 *
 * @author marbu
 */
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
