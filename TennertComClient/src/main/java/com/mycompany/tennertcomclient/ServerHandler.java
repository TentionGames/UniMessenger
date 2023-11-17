package com.mycompany.tennertcomclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerHandler extends Thread {

    Socket server;
    DataInputStream in;
    DataOutputStream out;
    MainFrame mainFrame;

    public ServerHandler(MainFrame mainFrame){this.mainFrame = mainFrame;}

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
            mainFrame.ChangePanel(1);
        } catch (IOException e) {}
    } 

    void receiveMsg() throws IOException {
        String input = in.readUTF();
        String code = input.substring(0, 3);
        switch (code) {
            case "ACL" -> {
                mainFrame.ChangePanel(2);
                String[] nutzerNamen = input.substring(3).split("%SPLIT%");
                if(nutzerNamen[0].isEmpty()) break;
                MainFrame.mainFrame.DisplayNutzerList(nutzerNamen);
            }
            case "ERR" -> {
                mainFrame.DisplayLoginError(input.substring(3));
            }
            case "HBT" -> {
                MainFrame.heartBeat.ReceivedBeat();
            }
            case "NCL" -> {
                mainFrame.DisplayNewNutzer(input.substring(3));
            }
            case "CLD" -> {
                mainFrame.RemoveName(input.substring(3));
            }
            case "MSG" -> {
                String[] data = input.substring(3).split("%SPLIT%");
                mainFrame.DisplayMSG(data[0], data[1]);
            }
            default -> {
                
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
        if(name.contains("%SPLIT%") || password.contains("%SPLIT%") || name.isEmpty() || password.isEmpty()){
            mainFrame.DisplayLoginError("Name oder Passwort sind ungültig!");
            return;
        }
        SendMsg("LOG"+name+"%SPLIT%"+password);
    } 
    
    public void SendRegister(String name, String password){
        name = name.trim();
        password = password.trim();
        if(name.contains("%SPLIT%") || password.contains("%SPLIT%") || name.isEmpty() || password.isEmpty()){
            mainFrame.DisplayLoginError("Name oder Passwort sind ungültig!");
            return;
        }
        SendMsg("REG"+name+"%SPLIT%"+password);
    }
}
