package com.mycompany.tennertcomserver;

import java.util.ArrayList;

public class Room {
    private String roomName;
    private ArrayList<String> connectedUsers;
    
    public Room(String roomName){
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
        //Tell CLients
    }
    
    public String[] getUsers(){
        return (String[]) connectedUsers.toArray();
    }
}
