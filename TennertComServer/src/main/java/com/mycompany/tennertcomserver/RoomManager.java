package com.mycompany.tennertcomserver;

import java.util.ArrayList;

public class RoomManager {
    
    Datenbank db;
    
    private ArrayList<Room> rooms = new ArrayList();
    
    public RoomManager(Datenbank db){
        this.db = db;
    }
    
    public int getAnzRooms(){
        return rooms.size();
    }
    
    public Room getRoom(int room){
        return rooms.get(room);
    }
    
    public void AddRoom(String roomName){
        rooms.add(new Room(db, roomName));
        db.getMainFrame().AddRoom(roomName);
        db.getClientManager().SendMessageToAllClients("NRC" + roomName);
    }
    
    public void CurrRoomChangeName(String roomName){
        int selectedRoom = db.getMainFrame().getSelectedRoom();
        if(selectedRoom < 0){
            db.getMainFrame().DisplayError("Kein Raum ausgewählt!");
            return;
        }
        rooms.get(selectedRoom).ChangeName(roomName);
        db.getMainFrame().ChangeRoomName(selectedRoom, roomName);
        db.getClientManager().SendMessageToAllClients("RNC" + selectedRoom + "%SPLIT%" + roomName);
    }
    
    public void CurrRoomDelete(){
        if(isLastRoom()){
            db.getMainFrame().DisplayError("Einziger Raum kann nicht gelöscht werden!");
            return;
        }
        int selectedRoom = db.getMainFrame().getSelectedRoom();
        if(selectedRoom < 0){
            db.getMainFrame().DisplayError("Kein Raum ausgewählt!");
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
        client.setRoom(rooms.get(newRoom));
        RemoveUserFromRoom(currentRoom, client);
        AddUserToRoom(client, newRoom);
        client.SendMsg("RRC" + rooms.get(newRoom).getChatInhalt());
    }
    
    boolean isLastRoom(){
        return rooms.size() < 2;
    }
}
