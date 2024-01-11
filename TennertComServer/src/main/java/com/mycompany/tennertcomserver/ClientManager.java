package com.mycompany.tennertcomserver;

import java.net.Socket;
import java.util.ArrayList;

public class ClientManager {
    
   private Datenbank db;
   
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
    
    public int indexOfClient(ClientHandler client){
        return clientHandlers.indexOf(client);
    }

    public void SendMessageToClient(int index, String msg){
        getClientHandler(index).SendMsg(msg);
    }
    
    public void SendBytesToClient(int index, byte[] file, int count){
        getClientHandler(index).SendBytes(file, count);
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
            if(!room.isEqualTo(getClientHandler(i).getRoom())) continue;
            SendMessageToClient(i, msg);
        }
    }
    
    public void SendBytesToAllClientsInRoom(Room room, byte[] file, int count){
        for (int i = 0; i < getAnzClients(); i++) {
            if(!room.isEqualTo(getClientHandler(i).getRoom())) continue;
            SendBytesToClient(i, file, count);
        }
    }
    
    public void SendMessageToAllClientsInRoomExcept(Room room, ClientHandler exceptionClient, String msg){
        for (int i = 0; i < getAnzClients(); i++) {
            if(!room.isEqualTo(getClientHandler(i).getRoom()) || getClientHandler(i).isEqualTo(exceptionClient)) continue;
            SendMessageToClient(i, msg);
        }
    }
    
    public void SendMessageToAllClientsNotInRoom(Room room, String msg){
        for (int i = 0; i < getAnzClients(); i++) {
            if(room.isEqualTo(getClientHandler(i).getRoom())) continue;
            SendMessageToClient(i, msg);
        }
    }
    
    public void RemoveClient(ClientHandler client){
        if(!client.isClientInfoNull()){
            db.getMainFrame().RemoveName(clientHandlers.indexOf(client));
            SendMessageToAllClientsInRoomExcept(client.getRoom(),client,"ULR" + client.getClientName());
            db.getLogHandler().ClientDisconnected(client.getClientName());
            db.getRoomManager().RemoveUserFromRoom(client.getRoom(), client);
        }
        clientHandlers.remove(client);
    }
    
    public void RemoveClient(int clientIndex){
        RemoveClient(clientHandlers.get(clientIndex));
    }
    
    public void ClientVerwarnen(int clientIndex, String warnung){
        SendMessageToClient(clientIndex, "VWA" + warnung);
        db.getLogHandler().ClientVerwarnt(clientHandlers.get(clientIndex).getClientName(), warnung);
    }
    
    public void ClientKick(int clientIndex){
        SendMessageToClient(clientIndex, "KCK");
        db.getLogHandler().ClientGekickt(clientHandlers.get(clientIndex).getClientName());
        RemoveClient(clientIndex);
    }
    
    public void ClientBann(int clientIndex){
        ClientInfo info = clientHandlers.get(clientIndex).getClientInfo();
        info.ChangeBan(true);
        db.ChangeClientInfo(info);
        db.getSaveSystem().SaveClientInfo(info);
        db.getLogHandler().ClientGebannt(info.getName());
        ClientKick(clientIndex);
    }
}
