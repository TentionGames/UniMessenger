package com.mycompany.tennertcomserver;

import java.util.ArrayList;

public class Room {
    
    private Datenbank db;
    
    private String roomName;
    private ArrayList<ClientHandler> connectedUsers = new ArrayList();
    private String chatInhalt = "";
    
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
    
    public void AddUser(ClientHandler userName){
        connectedUsers.add(userName);
    }
    
    public String[] getUsers(){
        return (String[]) connectedUsers.toArray();
    }

    public String getChatInhalt() {
        return chatInhalt;
    }
    
    public void AddMsg(String nutzer, String msg){
        chatInhalt += nutzer + ":\t" + msg + "\n";
    }
}
