package com.mycompany.tennertcomserver;

public class LogHandler {
    
    private Datenbank db;
    
    public LogHandler(Datenbank db){
        this.db = db;
    }
    
    private void AddLog(String log){
        db.getMainFrame().AddLog(log);
    }
    
    public void NachrichtEmpfangen(ClientHandler client, String msg){
        AddLog("Von " + client.getClientName() + " wurde die Nachricht \"" + msg + "\" im Raum \"" + client.getRoom().getName() + "\" empfangen.");
    }
    
    public void NachrichtGesendetAnRaum(Room room, ClientHandler clientGesendet, String msg){
        for (int i = 0; i < room.getAnzUsers(); i++) {
            NachrichtGesendet(room.getUser(i), clientGesendet, msg);
        }
    }
    
    void NachrichtGesendet(ClientHandler clientEmpfangen, ClientHandler clientGesendet, String msg){
        AddLog("An " + clientEmpfangen.getClientName() + " im Raum \"" + clientEmpfangen.getRoom().getName() + "\" wurde die Nachricht \"" + msg + "\" von " + clientGesendet.getClientName() + " gesendet.");
    }
}
