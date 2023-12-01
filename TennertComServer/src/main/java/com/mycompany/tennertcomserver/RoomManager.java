package com.mycompany.tennertcomserver;

import java.util.ArrayList;

public class RoomManager {
    
    Datenbank db;
    
    int selectedRoom;
    
    private ArrayList<Room> rooms = new ArrayList();
    
    public RoomManager(Datenbank db){
        this.db = db;
        AddRoom("default");
    }
    
    public void AddRoom(String roomName){
        rooms.add(new Room(db, roomName));
        db.getMainFrame().AddRoom(roomName);
        db.getClientManager().SendMessageToAllClients("NRC" + roomName);
    }
    
    public void CurrRoomChangeName(String roomName){
        rooms.get(selectedRoom).ChangeName(roomName);
        db.getMainFrame().ChangeRoomName(selectedRoom, roomName);
        db.getClientManager().SendMessageToAllClients("RNC" + selectedRoom + "%SPLIT%" + roomName);
    }
    
    public void CurrRoomDelete(){
        if(isLastRoom()){
            db.getMainFrame().DisplayError("Einziger Raum kann nicht gelöscht werden!");
            return;
        }
        rooms.remove(selectedRoom);
        db.getMainFrame().DeleteRoom(selectedRoom);
        db.getClientManager().SendMessageToAllClients("RDL" + selectedRoom);
    }
    
    public void RemoveUserFromRoom(Room currentRoom, ClientHandler client){
        currentRoom.RemoveUser(client);
    }
    
    public void AddUserToRoom(ClientHandler client, int newRoom){
        rooms.get(newRoom).AddUser(client);
    }
    
    public void ChangeUserRoom(Room currentRoom, ClientHandler client, int newRoom){
        RemoveUserFromRoom(currentRoom, client);
        AddUserToRoom(client, newRoom);
    }
    
    boolean isLastRoom(){
        return rooms.size() < 2;
    }
}
