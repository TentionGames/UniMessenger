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
    
    public void RemoveClient(int index){
        clientHandlers.remove(index);
    }

    public void SendMessageToClient(int index, String msg){
        getClientHandler(index).SendMsg(msg);
    }
    
    public void SendMessageToAllClients(String msg){
        for (int i = 0; i < getAnzClients(); i++) {
            SendMessageToClient(i, msg);
        }
    }
    
    public void SendMessageToAllClientsInRoom(Room room, String msg){
        for (int i = 0; i < getAnzClients(); i++) {
            if(room != getClientHandler(i).getRoom()) continue;
            SendMessageToClient(i, msg);
        }
    }
}
