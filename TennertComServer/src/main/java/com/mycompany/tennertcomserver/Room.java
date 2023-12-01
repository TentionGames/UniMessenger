package com.mycompany.tennertcomserver;

import java.util.ArrayList;

public class Room {
    
    private Datenbank db;
    
    private String roomName;
    private ArrayList<ClientHandler> connectedUsers;
    private String chatInhalt;
    
    public Room(Datenbank db, String roomName){
        this.db = db;
        this.roomName = roomName;
    }
    
    public void ChangeName(String roomName){
        this.roomName = roomName;
    }
    
    public String getName(){
        return roomName;
    }
    
    public void AddUser(ClientHandler client){
        connectedUsers.add(client);
    }
    
    public void RemoveUser(ClientHandler client){
        connectedUsers.remove(client);
    }
    
    public String[] getUsers(){
        String[] ausgabe = new String[connectedUsers.size()];
        for (int i = 0; i < ausgabe.length; i++) {
            ausgabe[i] = connectedUsers.get(i).info.getName();
        }
        return ausgabe;
    }
}
