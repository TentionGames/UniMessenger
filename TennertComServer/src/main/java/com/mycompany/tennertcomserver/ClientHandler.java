package com.mycompany.tennertcomserver;

import java.net.*;
import java.io.*;

public class ClientHandler extends Thread {

    private Datenbank db;

    private ClientInfo info;

    private Socket client;
    private DataInputStream in;
    private DataOutputStream out;
    private int currentRoom;

    private long lastBeatReceived = System.currentTimeMillis();

    public long getLastBeatReceived() {
        return lastBeatReceived;
    }
    
    public String getClientName(){
        return info.getName();
    }
    
    public Room getRoom(){
        return db.getRoomManager().getRoom(currentRoom);
    }
    
    public void setRoom(int roomIdx){
        this.currentRoom = roomIdx;
    }
    
    public boolean isClientInfoNull(){
        return info == null;
    }
    
    public ClientInfo getClientInfo(){
        return info;
    }
    
    public boolean isEqualTo(ClientHandler other){
        if(info.getName().equals(other.getClientName())) return true;
        return false;
    }

    public ClientHandler(Datenbank db, Socket client) {
        this.db = db;
        this.client = client;
    }

    @Override
    public void run() {
        while (true) {
            try {
                ReceiveMsg();
            } catch (IOException e) {}
        }
    }

    public void TryStream() {
        try {
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
        }
    }
    
    public void SendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException ex) {
        }
    }
    
    private void SendError(String errorMsg){
        SendMsg("ERR"+ errorMsg);
    }

    private void ReceiveMsg() throws IOException {
        String input = in.readUTF();
        String code = input.substring(0, 3);
        switch (code) {
            case "LOG" :{
                ReceivedLogin(input.substring(3).split("%SPLIT%"));
                break;
            }
            case "REG" :{
                ReceivedRegister(input.substring(3).split("%SPLIT%"));
                break;
            }
            case "HBT" :{
                ReceivedHeartBeat();
                break;
            }
            case "MSG" :{
                ReceivedTextChat(input.substring(3));
                break;
            }
            case "JRR" :{
                ReceivedJoinRoomRequest(Integer.parseInt(input.substring(3)));
                break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Login und Registrieren">
    private void ReceivedLogin(String[] data) {
        ClientInfo clientInfo = db.getClientInfo(data[0]);
        
        if (clientInfo == null) {
            SendError("Benutzername existiert nicht!");
        } else if (clientInfo.isBanned()){
            SendError("Sie sind gebannt!");
        } else if (clientInfo.getPassword().equals(data[1])) {
            SuccesfullLogin(clientInfo);
        } else {
            SendError("Falsches Passwort!");
        }
    }

    private void ReceivedRegister(String[] data) {
        ClientInfo clientInfo = db.newAccount(data[0], data[1]);
        
        if (clientInfo != null) {
            SuccesfullLogin(clientInfo);
        } else {
            SendError("Benutzer existiert schon!");
        }
    }
    
    private void SuccesfullLogin(ClientInfo clientInfo) {
        this.info = clientInfo;
        db.getMainFrame().AddName(clientInfo.getName(), db.getRoomManager().getRoom(0).getName());
        db.getRoomManager().AddUserToRoom(this, 0);
        SendMsg("ACL");
    }

    public void SendGeneralServerInfo(){
        String msg = "GSI%SPLIT_2%";
        for (int i = 0; i < db.getClientManager().getAnzClients(); i++) {
            ClientInfo curClientInfo = db.getClientManager().getClientHandler(i).info;
            if (curClientInfo != null) {
                msg += curClientInfo.getName() + "%SPLIT_2%";
            }
        }
        msg += "%SPLIT%";
        for (int i = 0; i < db.getRoomManager().getAnzRooms(); i++) {
            msg += db.getRoomManager().getRoom(i).getName() + "%SPLIT_2%";
        }
        SendMsg(msg);
    }
    // </editor-fold> 

    private void ReceivedHeartBeat() {
        lastBeatReceived = System.currentTimeMillis();
    }

    private void ReceivedTextChat(String nachricht) {
        db.getLogHandler().NachrichtEmpfangen(this, nachricht);
        getRoom().AddMsg(info.getName(), nachricht);
        db.getClientManager().SendMessageToAllClientsInRoom(getRoom(), "MSG" + info.getName() + "%SPLIT%" + nachricht);
        db.getLogHandler().NachrichtGesendetAnRaum(getRoom(), this, nachricht);
    }  
    
    private void ReceivedJoinRoomRequest(int roomIndex){
        if(db.getRoomManager().getRoom(roomIndex).equals(currentRoom)) return;
        db.getRoomManager().ChangeUserRoom(getRoom(), this, roomIndex);
    }

    
}
