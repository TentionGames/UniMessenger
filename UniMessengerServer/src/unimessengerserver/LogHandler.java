package unimessengerserver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogHandler {
    
    private Datenbank db;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm");
    
    public LogHandler(Datenbank db){
        this.db = db;
    }
    
    private void AddLog(String log){
        log = "[" + dtf.format(LocalDateTime.now()) + "] " + log;
        db.getMainFrame().AddLog(log);
    }
    
    public void ServerGestartet(){
        AddLog("----- Der Server wurde gestartet -----");
    }
    
    public void NachrichtEmpfangen(ClientHandler client, String msg){
        AddLog("Von \"" + client.getClientName() + "\" wurde die Nachricht \"" + msg + "\" im Raum \"" + client.getRoom().getName() + "\" empfangen.");
    }
    
    public void NachrichtGesendetAnRaum(Room room, String clientGesendetName, String msg){
        for (int i = 0; i < room.getAnzUsers(); i++) {
            NachrichtGesendet(room.getUser(i), clientGesendetName, msg);
        }
    }
    
    void NachrichtGesendet(ClientHandler clientEmpfangen, String clientGesendetName, String msg){
        AddLog("An \"" + clientEmpfangen.getClientName() + "\" im Raum \"" + clientEmpfangen.getRoom().getName() + "\" wurde die Nachricht \"" + msg + "\" von \"" + clientGesendetName + "\" gesendet.");
    }
    
    public void ClientJoined(String clientName){
        AddLog("\"" + clientName + "\" ist dem Server beigetreten.");
    }
    
    public void ClientDisconnected(String clientName){
        AddLog("\"" + clientName + "\" hat den Server verlassen.");
    }
    
    public void ClientVerwarnt(String clientName, String nachricht){
        AddLog("\"" + clientName + "\" wurde mit der Nachricht: \"" + nachricht + "\" verwarnt.");
    }
    
    public void ClientGekickt(String clientName){
        AddLog("\"" + clientName + "\" wurde vom Server geworfen.");
    }
    
    public void ClientGebannt(String clientName){
        AddLog("\"" + clientName + "\" wurde vom Server gebannt.");
    }
    
    public void ClientBetrittRaum(String clientName, String raumName){
        AddLog("\"" + clientName + "\" ist dem Raum \"" + raumName + "\" beigetreten.");
    }
    
    public void ClientLeavtRaum(String clientName, String raumName){
        AddLog("\"" + clientName + "\" hat den Raum \"" + raumName + "\" verlassen.");
    }
    
    public void RaumGeloescht(String raumName){
        AddLog("Der Raum \"" + raumName + "\" wurde gelöscht.");
    }
    
    public void RaumErstellt(String raumName){
        AddLog("Der Raum \"" + raumName + "\" wurde erstellt.");
    }
    
    public void RaumUmbenannt(String raumNameAlt, String raumNameNeu){
        AddLog("Der Raum \"" + raumNameAlt + "\" wurde in \"" + raumNameNeu + "\" umbennant.");
    }
    
    public void FileEmpfangen(ClientHandler client, String fileName){
        AddLog("Von \"" + client.getClientName() + "\" wurde das File \"" + fileName + "\" im Raum \"" + client.getRoom().getName() + "\" empfangen.");
    }
    
    public void FileGesendetAnRaum(Room room, String clientGesendetName, String fileName){
        for (int i = 0; i < room.getAnzUsers(); i++) {
            FileGesendet(room.getUser(i), clientGesendetName, fileName);
        }
    }
    
    public void FileGesendet(ClientHandler clientEmpfangen, String clientGesendetName, String fileName){
        AddLog("An \"" + clientEmpfangen.getClientName() + "\" im Raum \"" + clientEmpfangen.getRoom().getName() + "\" wurde das File \"" + fileName + "\" von \"" + clientGesendetName + "\" gesendet.");
    }
}
