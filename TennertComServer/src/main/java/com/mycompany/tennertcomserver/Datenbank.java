package com.mycompany.tennertcomserver;

import java.net.Socket;
import java.util.ArrayList;

public class Datenbank {
    
    private final MainFrame mainFrame;
    private final LoginThread loginThread;
    private final HeartBeat heartBeat;
    private final RoomManager roomManager;
    private final ClientManager clientManager;
    private final LogHandler logHandler;
    private final SaveSystem saveSystem;
    
    private final ArrayList<ClientInfo> accs = new ArrayList();
    
    public Datenbank(){
        mainFrame = new MainFrame(this);
        loginThread = new LoginThread(this);
        heartBeat = new HeartBeat(this);
        roomManager = new RoomManager(this);
        clientManager = new ClientManager(this);
        logHandler = new LogHandler(this);
        saveSystem = new SaveSystem(this);
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
    
    public LogHandler getLogHandler(){
        return logHandler;
    }
    
    public SaveSystem getSaveSystem(){
        return saveSystem;
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="LoginDaten Verwaltung">    
    public ClientInfo newAccount(String name, String password){
        if(getClientInfo(name) != null) return null;
        ClientInfo clientInfo = new ClientInfo(name.trim(), password.trim());
        accs.add(clientInfo);
        saveSystem.SaveClientInfo(clientInfo);
        return clientInfo;
    }
    
    public ClientInfo getClientInfo(String name){
        for (ClientInfo acc : accs) {
            if(acc.getName().equals(name)) return acc;
        }
        return null;
    }

    public void ChangeClientInfo(ClientInfo clientInfo){
        for (ClientInfo acc : accs) {
            if(acc.getName().equals(clientInfo.getName())){
                acc = clientInfo;
                return;
            }
        }
    }
    
    public void AddClientInfo(ClientInfo client){
        accs.add(client);
    }
    // </editor-fold> 
}