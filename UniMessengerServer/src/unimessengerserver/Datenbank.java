package unimessengerserver;

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
        mainFrame.AddNutzerNormal(name, password, true);
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
        if(client.isBanned()) mainFrame.AddNutzerBanned(client.getName(), client.getPassword());
        else mainFrame.AddNutzerNormal(client.getName(), client.getPassword(), false);
    }
    
    public int indexOfClientInfo(ClientInfo info, boolean banned){
        int bannedIdx = 0;
        int nutzerIdx = 0;
        for (int i = 0; i < accs.size(); i++) {
            if(accs.get(i).equals(info)){
                return banned?bannedIdx:nutzerIdx;
            }
            if(accs.get(i).isBanned()) bannedIdx++;
            else nutzerIdx++;
        }
        return -1;
    }
    
    public void NutzerBann(int nutzerIdx){
        int bannedIdx = 0;
        int nutzerIdxCount = 0;
        for (int i = 0; i < accs.size(); i++) {
            if(accs.get(i).isBanned()){
                bannedIdx++;
                continue;
            }
            if(nutzerIdxCount == nutzerIdx){
                accs.get(i).ChangeBan(true);
                int indexInClientHandlers = clientManager.indexOfClient(accs.get(i));
                if(indexInClientHandlers > -1) clientManager.ClientKick(indexInClientHandlers);
                logHandler.ClientGebannt(accs.get(i).getName());
                mainFrame.AddNutzerBanned(accs.get(i).getName(), accs.get(i).getPassword(), bannedIdx);
                mainFrame.RemoveNutzerNormal(nutzerIdx);
            }
            nutzerIdxCount++;
        }
    }
    
    public void NutzerEntbann(int bannedIdx){
        int nutzerIdx = 0;
        int bannedIdxCount = 0;
        for (int i = 0; i < accs.size(); i++) {
            if(!accs.get(i).isBanned()){
                nutzerIdx++;
                continue;
            }
            if(bannedIdxCount == bannedIdx){
                accs.get(i).ChangeBan(false);
                logHandler.ClientEntbannt(accs.get(i).getName());
                mainFrame.AddNutzerNormal(accs.get(i).getName(), accs.get(i).getPassword(), false, nutzerIdx);
                mainFrame.RemoveNutzerBanned(bannedIdx);
            }
            bannedIdxCount++;
        }
    }
    // </editor-fold> 
}