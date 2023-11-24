package com.mycompany.tennertcomserver;

import java.net.Socket;
import java.util.ArrayList;

public class Datenbank {
    
    private MainFrame mainFrame;
    private LoginThread loginThread;
    private HeartBeat heartBeat;
    
    private ArrayList<ClientHandler> clientHandlers = new ArrayList();
    private ArrayList<ClientInfo> accs = new ArrayList();
    private ArrayList<Room> rooms = new ArrayList();
    
    public Datenbank(){
        mainFrame = new MainFrame(this);
        loginThread = new LoginThread(this);
        heartBeat = new HeartBeat(this);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Manager Verwaltung"> 
    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public LoginThread getLoginThread() {
        return loginThread;
    }

    public HeartBeat getHeartBeat() {
        return heartBeat;
    }// </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="LoginDaten Verwaltung">    
    public ClientInfo newAccount(String name, String password){
        if(getClientInfo(name) != null) return null;
        ClientInfo clientInfo = new ClientInfo(name.trim(), password.trim());
        accs.add(clientInfo);
        return clientInfo;
    }
    
    public ClientInfo getClientInfo(String name){
        for (ClientInfo acc : accs) {
            if(acc.getName().equals(name)) return acc;
        }
        return null;
    }// </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Client Verwaltung">
    public void ClientFound(Socket client) {
        ClientHandler clientHandler = new ClientHandler(this, client);
        clientHandlers.add(clientHandler);
        clientHandler.start();
    }
    
    public ClientHandler getClientHandler(int index){
        return clientHandlers.get(index);
    }
    
    public void RemoveClient(int index){
        clientHandlers.remove(index);
    }
    
    public int getAnzClients(){
        return clientHandlers.size();
    }// </editor-fold> 
}