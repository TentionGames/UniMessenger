package com.mycompany.tennertcomclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerHandler extends Thread {

    Socket server;
    DataInputStream in;
    DataOutputStream out;
    Datenbank db;

    public ServerHandler(Datenbank db){this.db = db;}

    @Override
    public void run() {
        TryConnect();
        
        while (true) {
            try {
                receiveMsg();
            } catch (IOException e) {}
        }
    }
    
    public void TryConnect(){
        try {
            server = new Socket("localhost", 3141);
            in = new DataInputStream(server.getInputStream());
            out = new DataOutputStream(server.getOutputStream());
            db.getMainFrame().ChangePanel(1);
            db.getHeartBeat().start();
        } 
        catch (IOException e) {}
    } 
    
    void SendMsg(String msg){
        try {
            out.writeUTF(msg);
        } catch (IOException ex) {}
    }
    
    public void SendLogin(String name, String password){
        name = name.trim();
        password = password.trim();
        if(name.contains("%SPLIT%") || password.contains("%SPLIT%") || name.isEmpty() || password.isEmpty()){
            db.getMainFrame().DisplayLoginError("Name oder Passwort sind ungültig!");
            return;
        }
        SendMsg("LOG"+name+"%SPLIT%"+password);
    } 
    
    public void SendRegister(String name, String password){
        name = name.trim();
        password = password.trim();
        if(name.contains("%SPLIT%") || password.contains("%SPLIT%") || name.isEmpty() || password.isEmpty()){
            db.getMainFrame().DisplayLoginError("Name oder Passwort sind ungültig!");
            return;
        }
        SendMsg("REG"+name+"%SPLIT%"+password);
    }

    void receiveMsg() throws IOException{
        if(in == null) return;
        String input = in.readUTF();
        String code = input.substring(0, 3);
        switch (code) {
            case "HBT" :{ //Rceived Heartbeat
                ReceivedHeartBeat();
                break;
            }
            case "ERR" :{ //Received Error
                ReceivedError(input.substring(3));
                break;
            }
            case "GSI":{//General Server Info
                ReceivedGeneralServerInfo(input.substring(3).split("%SPLIT%"));
                break;
            }
            case "ACL" :{ //Accepted Client Login
                ReceivedLoginAccept();
                break;
            }
            case "NCL" :{ //New Client 
                ReceivedNewCLient(input.substring(3));
                break;
            }
            case "CLD" :{ //Client Disconnected
                ReceivedClientDisconnect(input.substring(3));
                break;
            }
            case "MSG" :{ //Message Received
                ReceivedMessage(input.substring(3).split("%SPLIT%"));
                break;
            }
            case "UJR":{ //User Joined Room
                UserJoinedRoom(input.substring(3));
                break;
            }
            case "ULR":{ //User Joined Room
                UserLeftRoom(input.substring(3));
                break;
            }
            case "NRC":{ //New Room Created
                ReceivedNewRoomCreated(input.substring(3));
                break;
            }
            case "RNC":{ //Room Name Change
                ReceivedRoomNameChanged(input.substring(3).split("%SPLIT%"));
                break;
            }
            case "RDL":{ //Room Deleted
                ReceivedRoomDeleted(Integer.parseInt(input.substring(3)));
                break;
            }
            case "RRC":{ //Receive Room Chat
                ReceiveRoomChat(input.substring(3).split("%SPLIT%"));
                break;
            }
            case "VWA":{ //Verwarnung erhalten
                ReceiveVerwarnung(input.substring(3));
                break;
            }
            case "KCK":{
                ReceiveKick();
                break;
            }
        }
    }
    
    void ReceivedHeartBeat(){
        db.getHeartBeat().ReceivedBeat();
    }
    
    void ReceivedError(String errorMsg){
        db.getMainFrame().DisplayLoginError(errorMsg);
    }
    
    void ReceivedGeneralServerInfo(String[] data){
        String[] nutzerNamen = data[0].split("%SPLIT_2%");
        String[] rooms = data[1].split("%SPLIT_2%");
        if(nutzerNamen.length > 0){
            db.getMainFrame().DisplayNutzerList(nutzerNamen);
        }
        db.getMainFrame().DisplayNewRoomList(rooms);
    }
    
    void ReceivedLoginAccept(){
        db.getMainFrame().ChangePanel(2);
    }
    
    void ReceivedNewCLient(String clientName){
        
    }
    
    void ReceivedClientDisconnect(String clientName){
        
    }
    
    void ReceivedMessage(String[] data){
        db.getMainFrame().DisplayMSG(data[0], data[1]);
    }
    
    void ReceivedNewRoomCreated(String roomName){
        db.getMainFrame().AddRoom(roomName);
    }
    
    void ReceivedRoomNameChanged(String[] data){
        db.getMainFrame().ChangeRoomName(Integer.parseInt(data[0]), Integer.parseInt(data[1]) > 0, data[2]);
    }
    
    void ReceivedRoomDeleted(int roomIndex){
        db.getMainFrame().DeleteRoom(roomIndex);
    }
    
    void ReceiveRoomChat(String[] data){
        db.getMainFrame().DisplayNewRoomChat(data[0], data[1]);
        if(data.length < 3) {
            db.getMainFrame().DisplayNutzerList(new String[0]);
            return;
        }
        String[] nutzer = data[2].split("%SPLIT2%");
        db.getMainFrame().DisplayNutzerList(nutzer);
    }
    
    void ReceiveVerwarnung(String warnung){
        db.getMainFrame().DisplayErrorFrame(warnung);
    }
    
    void ReceiveKick(){
        db.getMainFrame().ChangePanel(0);
    }
    
    void UserJoinedRoom(String clientName){
        db.getMainFrame().DisplayNewNutzer(clientName);
    }
    
    void UserLeftRoom(String clientName){
        db.getMainFrame().RemoveName(clientName);
    }
}