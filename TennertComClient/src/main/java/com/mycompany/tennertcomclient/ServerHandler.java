/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tennertcomclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author marbu
 */
public class ServerHandler extends Thread {

    Socket server;
    DataInputStream in;
    DataOutputStream out;
    MainFrame mainFrame;
    
    public ServerHandler(MainFrame mainFrame){this.mainFrame = mainFrame;}

    @Override
    public void run() { // Bearbeitung einer aufgebauten Verbindung
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
            mainFrame.ChangePanel(1);
        } catch (IOException e) {}
    } 

    void receiveMsg() throws IOException {
        String input = in.readUTF();
        String code = input.substring(0, 3);
        switch (code) {
            case "ACL" -> {
                mainFrame.ChangePanel(2);
            }
            case "ERR" -> {
                mainFrame.DisplayLoginError(input.substring(3));
            }
            default -> {
                System.out.println("");
            }
        }
    }
    
    void SendMsg(String msg){
        try {
            out.writeUTF(msg);
        } catch (IOException ex) {}
    }
    
    public void SendLogin(String name, String password){
        name = name.trim();
        password = password.trim();
        if(name.contains("%SPLIT%") || password.contains("%SPLIT%")) return;
        SendMsg("LOG"+name+"%SPLIT%"+password);
    } 
    
    public void SendRegister(String name, String password){
        name = name.trim();
        password = password.trim();
        if(name.contains("%SPLIT%") || password.contains("%SPLIT%")) return;
        SendMsg("REG"+name+"%SPLIT%"+password);
    }
}
