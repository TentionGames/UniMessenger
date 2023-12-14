package com.mycompany.tennertcomserver;

import java.net.Socket;
import java.util.ArrayList;

public class Datenbank {
    
    private final MainFrame mainFrame;
    private final LoginThread loginThread;
    private final HeartBeat heartBeat;
    private final RoomManager roomManager;
    private final ClientManager clientManager;
    
    private final ArrayList<ClientInfo> accs = new ArrayList();
    
    public Datenbank(){
        mainFrame = new MainFrame(this);
        loginThread = new LoginThread(this);
        heartBeat = new HeartBeat(this);
        roomManager = new RoomManager(this);
        clientManager = new ClientManager(this);
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
    }

    public RoomManager getRoomManager(){
        return roomManager;
    }
    
    public ClientManager getClientManager(){
        return clientManager;
    }
    // </editor-fold> 

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
}