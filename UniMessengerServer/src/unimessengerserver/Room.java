package unimessengerserver;

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
        for (int i = 0; i < connectedUsers.size(); i++) {
            ClientHandler client = connectedUsers.get(i);
            db.getMainFrame().ChangeName(db.getClientManager().indexOfClient(client), client.getClientName(), roomName);
        }
    }
    
    public boolean isEqualTo(Room other){
        if(roomName.equals(other.getName()) && chatInhalt.equals(other.getChatInhalt())) return true;
        return false;
    }
    
    public String getName(){
        return roomName;
    }
    
    public void AddUser(ClientHandler userName){
        connectedUsers.add(userName);
    }
    
    public void RemoveUser(ClientHandler client){
        connectedUsers.remove(client);
    }
    
    public int getAnzUsers(){
        return connectedUsers.size();
    }
    
    public ClientHandler getUser(int i){
        return connectedUsers.get(i);
    }

    public String getChatInhalt() {
        return chatInhalt;
    }
    
    public void AddMsg(String nutzer, String msg){
        chatInhalt += nutzer + ":\t" + msg + "\n";
    }
}
