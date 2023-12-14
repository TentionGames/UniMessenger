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
        } catch (IOException e) {}
    } 
<<<<<<< Updated upstream

    void receiveMsg() throws IOException {
        String input = in.readUTF();
        String code = input.substring(0, 3);
        switch (code) {
            case "ACL" :{
                mainFrame.ChangePanel(2);
                String[] nutzerNamen = input.substring(3).split("%SPLIT%");
                if(nutzerNamen[0].isEmpty()) break;
                MainFrame.mainFrame.DisplayNutzerList(nutzerNamen);
            }
            case "ERR" :{
                mainFrame.DisplayLoginError(input.substring(3));
            }
            case "HBT" :{
                MainFrame.heartBeat.ReceivedBeat();
            }
            case "NCL" :{
                mainFrame.DisplayNewNutzer(input.substring(3));
            }
            case "CLD" :{
                mainFrame.RemoveName(input.substring(3));
            }
            case "MSG" :{
                String[] data = input.substring(3).split("%SPLIT%");
                mainFrame.DisplayMSG(data[0], data[1]);
            }
            case "UCR":{
                
            }
            case "NRC":{
                
            }
            case "RDL":{
                
            }
        }
    }
=======
>>>>>>> Stashed changes
    
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

    void receiveMsg() throws IOException {
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
                ReceivedGeneralServerInfo(input.substring(3).split("%SPLIT_2%"));
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
                ReceiveRoomChat(input.substring(3));
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
        String[] nutzerNamen = data[0].split("%SPLIT%");
        String[] rooms = data[1].split("%SPLIT%");
        if(nutzerNamen.length > 0){
            db.getMainFrame().DisplayNutzerList(nutzerNamen);
        }
        db.getMainFrame().DisplayNewRoomList(rooms);
    }
    
    void ReceivedLoginAccept(){
        db.getMainFrame().ChangePanel(2);
    }
    
    void ReceivedNewCLient(String clientName){
        db.getMainFrame().DisplayNewNutzer(clientName);
    }
    
    void ReceivedClientDisconnect(String clientName){
        db.getMainFrame().RemoveName(clientName);
    }
    
    void ReceivedMessage(String[] data){
        db.getMainFrame().DisplayMSG(data[0], data[1]);
    }
    
    void ReceivedNewRoomCreated(String roomName){
        db.getMainFrame().AddRoom(roomName);
    }
    
    void ReceivedRoomNameChanged(String[] data){
        db.getMainFrame().ChangeRoomName(Integer.parseInt(data[0]), data[1]);
    }
    
    void ReceivedRoomDeleted(int roomIndex){
        db.getMainFrame().DeleteRoom(roomIndex);
    }
    
    void ReceiveRoomChat(String roomChat){
        db.getMainFrame().DisplayNewRoomChat(roomChat);
    }
            
}