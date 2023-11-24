package com.mycompany.tennertcomserver;

import java.net.*;
import java.io.*;

public class ClientHandler extends Thread {

    Datenbank db;
    
    Socket client;
    int index;
    ClientInfo info;

    public long lastBeatReceived = System.currentTimeMillis();
    
    ClientHandler(Datenbank db, Socket client, int index) {
        this.db = db;
        this.client = client;
        this.index = index;
    }

    DataInputStream in;
    DataOutputStream out;

    @Override
    public void run() {
        try {
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
        }
        
        while (true) {
            try {
                ReceiveMsg();
            } catch (IOException e) {
            }
        }
    }

    void ReceiveMsg() throws IOException {
        String input = in.readUTF();
        String code = input.substring(0, 3);
        switch (code) {
            case "LOG" ->{
                CheckLogin(input.substring(3));
            }
            case "REG" -> {
                Register(input.substring(3));
            }
            case "HBT" -> {
                lastBeatReceived = System.currentTimeMillis();
            }
            case "MSG" -> {
                for (int i = 0; i < db.getAnzClients(); i++) {
                    ClientInfo curClientInfo = db.getClient(i).info;
                    if (curClientInfo != null) {
                        db.getClient(i).SendMsg("MSG" + info.name + "%SPLIT%" + input.substring(3));
                    }
                }
            }
            default -> {
            }
        }
    }

    void CheckLogin(String loginData) {
        String[] data = loginData.split("%SPLIT%");
        ClientInfo clientInfo = db.checkForPassword(data[0]);
        if (clientInfo == null) {
            SendMsg("ERRBenutzername existiert nicht!");
        } else if (clientInfo.password.equals(data[1])) {
            SuccesfullLogin(clientInfo);
        } else {
            SendMsg("ERRFalsches Passwort!");
        }
    }

    void Register(String registerData) {
        String[] data = registerData.split("%SPLIT%");
        ClientInfo clientInfo = db.newAccount(data[0], data[1]);
        if (clientInfo != null) {
            SuccesfullLogin(clientInfo);
        } else {
            SendMsg("ERRBenutzer existiert schon!");
        }
    }

    void SendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException ex) {
        }
    }

    void SuccesfullLogin(ClientInfo clientInfo) {
        this.info = clientInfo;
        String msg = "ACL";
        for (int i = 0; i < db.getAnzClients(); i++) {
            ClientInfo curClientInfo = db.getClient(i).info;
            if (curClientInfo != null && !curClientInfo.name.equals(info.name)) {
                db.getClient(i).SendMsg("NCL" + info.name);
                msg += curClientInfo.name + "%SPLIT%";
            }
        }
        SendMsg(msg);
        db.mainFrame.AddName(clientInfo.name);
    }
}
