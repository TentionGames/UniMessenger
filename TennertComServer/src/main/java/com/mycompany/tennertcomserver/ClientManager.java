package com.mycompany.tennertcomserver;

import java.net.Socket;
import java.util.ArrayList;

public class ClientManager {
    
   Datenbank db;
   
   private final ArrayList<ClientHandler> clientHandlers = new ArrayList();
   
   public ClientManager(Datenbank db){
       this.db = db;
   }
   
   public void ClientFound(Socket client) {
        ClientHandler clientHandler = new ClientHandler(db, client);
        clientHandler.TryStream();
        clientHandler.SendGeneralServerInfo();
        clientHandlers.add(clientHandler);
        clientHandler.start();
    }
    
    public ClientHandler getClientHandler(int index){
        return clientHandlers.get(index);
    }
    
    public int getAnzClients(){
        return clientHandlers.size();
    }

    public void SendMessageToClient(int index, String msg){
        getClientHandler(index).SendMsg(msg);
    }
    
    public void SendMessageToAllClients(String msg){
        for (int i = 0; i < getAnzClients(); i++) {
            SendMessageToClient(i, msg);
        }
    }
    
    public void SendMessageToAllClientsExcept(String msg, ClientHandler exceptionClient){
        for (int i = 0; i < getAnzClients(); i++) {
            if(clientHandlers.get(i).equals(exceptionClient)) continue;
            SendMessageToClient(i, msg);
        }
    }
    
    public void SendMessageToAllClientsInRoom(Room room, String msg){
        for (int i = 0; i < getAnzClients(); i++) {
            if(!room.equals(getClientHandler(i).getRoom())) continue;
            SendMessageToClient(i, msg);
        }
    }
    
    public void SendMessageToAllClientsNotInRoom(Room room, String msg){
        for (int i = 0; i < getAnzClients(); i++) {
            if(room.equals(getClientHandler(i).getRoom())) continue;
            SendMessageToClient(i, msg);
        }
    }
    
    public void RemoveClient(ClientHandler client){
        if(client.info != null){
            db.getRoomManager().RemoveUserFromRoom(client.getRoom(), client);
            db.getMainFrame().RemoveName(client.getName());
        }
        clientHandlers.remove(client);
    }
}
