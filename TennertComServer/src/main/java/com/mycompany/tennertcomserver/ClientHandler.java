/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tennertcomserver;

import java.net.*;
import java.io.*;

public class ClientHandler extends Thread {

    Socket client;
    int index;
    ClientInfo info;

    ClientHandler(Socket client, int index) {
        this.client = client;
        this.index = index;
    }

    DataInputStream in;
    DataOutputStream out;

    @Override
    public void run() { // Bearbeitung einer aufgebauten Verbindung
        try {
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {}
        
        while (true) {
            try {
                ReceiveMsg();
            } catch (IOException e) {}
        }
    }

    void ReceiveMsg() throws IOException {
        String input = in.readUTF();
        String code = input.substring(0, 3);
        switch (code) {
            case "LOG" -> {
                CheckLogin(input.substring(3));
            }
            case "REG" -> {
                Register(input.substring(3));
            }
            default -> {
            }
        }
    }

    void CheckLogin(String loginData) {
        String[] data = loginData.split("%SPLIT%");
        ClientInfo clientInfo = Datenbank.checkForPassword(data[0]);
        if (clientInfo == null) {
            SendMsg("ERRBenutzername existiert nicht!");
        } else if (clientInfo.password.equals(data[1])) {
            SendMsg("ACC");
            this.info = clientInfo;
        } else {
            SendMsg("ERRFalsches Passwort!");
        }
    }

    void Register(String registerData) {
        String[] data = registerData.split("%SPLIT%");
        ClientInfo clientInfo = Datenbank.newAccount(data[0], data[1]);
        if (clientInfo != null) {
            SendMsg("ACC");
            this.info = clientInfo;
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
}
