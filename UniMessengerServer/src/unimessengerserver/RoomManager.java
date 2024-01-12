package unimessengerserver;

import java.util.ArrayList;

public class RoomManager {
    
    private Datenbank db;
    
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
    
    public int indexOfRoom(Room room){
        return rooms.indexOf(room);
    }
    
    public void AddRoom(String roomName){
        rooms.add(new Room(db, roomName));
        db.getMainFrame().AddRoom(roomName);
        db.getClientManager().SendMessageToAllClients("NRC" + roomName);
        db.getLogHandler().RaumErstellt(roomName);
    }
    
    public void CurrRoomChangeName(String roomName){
        int selectedRoom = db.getMainFrame().getSelectedRoom();
        if(selectedRoom < 0){
            db.getMainFrame().DisplayError("Kein Raum ausgewählt!");
            return;
        }
        db.getLogHandler().RaumUmbenannt(rooms.get(selectedRoom).getName(), roomName);
        rooms.get(selectedRoom).ChangeName(roomName);
        db.getMainFrame().ChangeRoomName(selectedRoom, rooms.get(selectedRoom).getAnzUsers(), roomName);
        db.getClientManager().SendMessageToAllClientsInRoom(rooms.get(selectedRoom), "RNC" + selectedRoom + "%SPLIT%1%SPLIT%" + roomName);
        db.getClientManager().SendMessageToAllClientsNotInRoom(rooms.get(selectedRoom), "RNC" + selectedRoom + "%SPLIT%0%SPLIT%" + roomName);
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
        Room roomToDelete = rooms.get(selectedRoom);
        int neuerRaum = selectedRoom != 0? 0:1;
        for (int i = 0; i < roomToDelete.getAnzUsers(); i++) {
            ChangeUserRoom(roomToDelete, roomToDelete.getUser(i), neuerRaum);
        }
        rooms.remove(selectedRoom);
        db.getMainFrame().DeleteRoom(selectedRoom);
        db.getClientManager().SendMessageToAllClients("RDL" + selectedRoom);
        db.getLogHandler().RaumGeloescht(roomToDelete.getName());
    }
    
    public void RemoveUserFromRoom(Room currentRoom, ClientHandler client){
        currentRoom.RemoveUser(client);
        db.getMainFrame().ChangeRoomName(rooms.indexOf(currentRoom), currentRoom.getAnzUsers(), currentRoom.getName());
        db.getClientManager().SendMessageToAllClientsInRoom(currentRoom, "ULR" + client.getClientName());
        db.getLogHandler().ClientLeavtRaum(client.getClientName(), currentRoom.getName());
        client.setRoom(-1);
    }
    
    public void AddUserToRoom(ClientHandler client, int newRoom){
        rooms.get(newRoom).AddUser(client);
        client.setRoom(newRoom);
        db.getMainFrame().ChangeName(db.getClientManager().indexOfClient(client), client.getClientName(), rooms.get(newRoom).getName());
        db.getMainFrame().ChangeRoomName(newRoom, rooms.get(newRoom).getAnzUsers(), rooms.get(newRoom).getName());
        
        db.getClientManager().SendMessageToAllClientsInRoomExcept(rooms.get(newRoom), client, "UJR" + client.getClientName());
        
        String msg = "RRC" + rooms.get(newRoom).getName() + "%SPLIT%FILL" + rooms.get(newRoom).getChatInhalt() + "%SPLIT%";
        for (int i = 0; i < rooms.get(newRoom).getAnzUsers(); i++) {
            if(rooms.get(newRoom).getUser(i).isEqualTo(client)) continue;
            msg += rooms.get(newRoom).getUser(i).getClientName() + "%SPLIT2%";
        }
        client.SendMsg(msg);
        db.getLogHandler().ClientBetrittRaum(client.getClientName(), rooms.get(newRoom).getName());
    }
    
    public void ChangeUserRoom(Room currentRoom, ClientHandler client, int newRoom){
        RemoveUserFromRoom(currentRoom, client);
        AddUserToRoom(client, newRoom);
    }
    
    private boolean isLastRoom(){
        return rooms.size() < 2;
    }
}
