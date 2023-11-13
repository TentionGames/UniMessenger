/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tennertcomserver;

import java.util.ArrayList;

public class HeartBeat extends Thread {

    long lastBeatSend = System.currentTimeMillis();
    ArrayList<ClientHandler> clientHandlers = MainFrame.comManager.clientHandlers;

    @Override
    public void run() {
        while (true) {
            if (System.currentTimeMillis() - lastBeatSend > 1000) {
                lastBeatSend = System.currentTimeMillis();
                for (int i = 0; i < clientHandlers.size(); i++) {
                    clientHandlers.get(i).SendMsg("HBT");
                }
            }
            System.out.print("");
            for (int i = 0; i < clientHandlers.size(); i++) {
                if (System.currentTimeMillis() - clientHandlers.get(i).lastBeatReceived > 2000) {
                    if (clientHandlers.get(i).info != null) {
                        String name = clientHandlers.get(i).info.name;
                        for (int j = 0; j < clientHandlers.size(); j++) {
                            ClientInfo curClientInfo = clientHandlers.get(j).info;
                            if (curClientInfo != null && !curClientInfo.name.equals(name)) {
                                clientHandlers.get(j).SendMsg("CLD" + name);
                            }
                        }
                        MainFrame.mainFrame.RemoveName(name);
                    }
                    MainFrame.comManager.clientHandlers.remove(i);
                }
            }
        }
    }
}
