package com.mycompany.tennertcomserver;

import java.util.ArrayList;

public class Room {
    
    private Datenbank db;
    
    private String roomName;
<<<<<<< Updated upstream
    private ArrayList<String> connectedUsers;
=======
    private ArrayList<ClientHandler> connectedUsers = new ArrayList();
    private String chatInhalt = "";
>>>>>>> Stashed changes
    
    public Room(Datenbank db, String roomName){
        this.db = db;
        this.roomName = roomName;
    }
    
    public void ChangeName(String roomName){
        this.roomName = roomName;
        //Tell Clients
    }
    
    public String getName(){
        return roomName;
    }
    
    public void AddUser(String userName){
        connectedUsers.add(userName);
        //Tell Clients
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