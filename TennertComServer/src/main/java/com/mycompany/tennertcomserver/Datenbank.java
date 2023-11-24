package com.mycompany.tennertcomserver;

import java.net.Socket;
import java.util.ArrayList;

public class Datenbank {
    
    public MainFrame mainFrame;
    public LoginThread loginThread;
    public HeartBeat heartBeat;
    
    private ArrayList<ClientInfo> accs = new ArrayList();
    private ArrayList<Room> rooms = new ArrayList();
    private ArrayList<ClientHandler> clientHandlers = new ArrayList();
    
    public Datenbank(){
        mainFrame = new MainFrame(this);
        loginThread = new LoginThread(this);
        heartBeat = new HeartBeat(this);
    }
    
    //Logindaten//
    public ClientInfo newAccount(String name, String password){
        if(checkForPassword(name) != null) return null;
        ClientInfo clientInfo = new ClientInfo(name.trim(), password.trim());
        accs.add(clientInfo);
        return clientInfo;
    }
    
    public ClientInfo checkForPassword(String name){
        for (ClientInfo acc : accs) {
            if(acc.name.equals(name)) return acc;
        }
        return null;
    }
    
    //Verbundene Clients
    public void ClientFound(Socket client) {
        ClientHandler clientHandler = new ClientHandler(this, client, clientHandlers.size()-1);
        clientHandlers.add(clientHandler);
        clientHandler.start();
    }
    
    public ClientHandler getClient(int index){
        return clientHandlers.get(index);
    }
    
    public void RemoveClient(int index){
        clientHandlers.remove(index);
    }
    
    public int getAnzClients(){
        return clientHandlers.size();
    }
}
