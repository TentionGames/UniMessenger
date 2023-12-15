package com.mycompany.tennertcomserver;

import java.net.*;
import java.io.*;

public class ClientHandler extends Thread {

    Datenbank db;

    ClientInfo info;

    Socket client;
    private DataInputStream in;
    private DataOutputStream out;
    Room currentRoom;

    private long lastBeatReceived = System.currentTimeMillis();

    public long getLastBeatReceived() {
        return lastBeatReceived;
    }
    
    public Room getRoom(){
        return currentRoom;
    }
    
    public void setRoom(Room room){
        this.currentRoom = room;
    }

    ClientHandler(Datenbank db, Socket client) {
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

    void TryStream() {
        try {
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
        }
    }
    
    void SendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException ex) {
        }
    }
    
    void SendError(String errorMsg){
        SendMsg("ERR"+ errorMsg);
    }

    void ReceiveMsg() throws IOException {
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
    void ReceivedLogin(String[] data) {
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

    void ReceivedRegister(String[] data) {
        ClientInfo clientInfo = db.newAccount(data[0], data[1]);
        
        if (clientInfo != null) {
            SuccesfullLogin(clientInfo);
        } else {
            SendError("ERRBenutzer existiert schon!");
        }
    }
    
    void SuccesfullLogin(ClientInfo clientInfo) {
        this.info = clientInfo;
        db.getRoomManager().AddUserToRoom(this, 0);
        db.getMainFrame().AddName(clientInfo.getName());
        db.getClientManager().SendMessageToAllClientsExcept("NCL" + info.getName(), this);
        SendMsg("ACL");
    }

    void SendGeneralServerInfo(){
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

    void ReceivedHeartBeat() {
        lastBeatReceived = System.currentTimeMillis();
    }

    void ReceivedTextChat(String nachricht) {
        currentRoom.AddMsg(info.getName(), nachricht);
        db.getClientManager().SendMessageToAllClientsInRoom(currentRoom, "MSG" + info.getName() + "%SPLIT%" + nachricht);
    }  
    
    void ReceivedJoinRoomRequest(int roomIndex){
        if(db.getRoomManager().getRoom(roomIndex).equals(currentRoom)) return;
        db.getRoomManager().ChangeUserRoom(currentRoom, this, roomIndex);
    }

    
}
