package com.mycompany.tennertcomserver;

import java.net.*;
import java.io.*;

public class ClientHandler extends Thread {

    Datenbank db;

    ClientInfo info;

    Socket client;
    private DataInputStream in;
    private DataOutputStream out;

    private long lastBeatReceived = System.currentTimeMillis();

    public long getLastBeatReceived() {
        return lastBeatReceived;
    }

    ClientHandler(Datenbank db, Socket client) {
        this.db = db;
        this.client = client;
    }

    @Override
    public void run() {
        TryStream();

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
                ReceivedLogin(input.substring(3));
            }
            case "REG" :{
                ReceivedRegister(input.substring(3));
            }
            case "HBT" :{
                ReceivedHeartBeat();
            }
            case "MSG" :{
                ReceivedTextChat(input.substring(3));
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Login und Registrieren">
    void ReceivedLogin(String loginData) {
        String[] data = loginData.split("%SPLIT%");
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

    void ReceivedRegister(String registerData) {
        String[] data = registerData.split("%SPLIT%");
        ClientInfo clientInfo = db.newAccount(data[0], data[1]);
        
        if (clientInfo != null) {
            SuccesfullLogin(clientInfo);
        } else {
            SendError("ERRBenutzer existiert schon!");
        }
    }
    
    void SuccesfullLogin(ClientInfo clientInfo) {
        this.info = clientInfo;
        String msg = "ACL";
        for (int i = 0; i < db.getAnzClients(); i++) {
            ClientInfo curClientInfo = db.getClientHandler(i).info;
            if (curClientInfo != null && !curClientInfo.getName().equals(info.getName())) {
                db.getClientHandler(i).SendMsg("NCL" + info.getName());
                msg += curClientInfo.getName() + "%SPLIT%";
            }
        }
        SendMsg(msg);
        db.getMainFrame().AddName(clientInfo.getName());
    }// </editor-fold> 

    void ReceivedHeartBeat() {
        lastBeatReceived = System.currentTimeMillis();
    }

    void ReceivedTextChat(String nachricht) {
        for (int i = 0; i < db.getAnzClients(); i++) {
            ClientInfo curClientInfo = db.getClientHandler(i).info;
            if (curClientInfo != null) {
                db.getClientHandler(i).SendMsg("MSG" + info.getName() + "%SPLIT%" + nachricht);
            }
        }
    }

    
}
