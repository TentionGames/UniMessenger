package com.mycompany.tennertcomserver;

import java.util.ArrayList;

public class HeartBeat extends Thread {

    Datenbank db;

    public HeartBeat(Datenbank db) {
        this.db = db;
    }

    @Override
    public void run() {
        while (true) {
            Wait(1000);
            SendHB();
            ListenToHB();
        }
    }

    private void Wait(int millSec) {
        try {
            Thread.sleep((long) millSec);
        } catch (InterruptedException ex) {
        }
    }

    private void SendHB() {
        db.getClientManager().SendMessageToAllClients("HBT");
    }

    private void ListenToHB() {
        for (int i = 0; i < db.getClientManager().getAnzClients(); i++) {
            if (System.currentTimeMillis() - db.getClientManager().getClientHandler(i).getLastBeatReceived() > 3000) {
                ClientDisconnected(i);
            }
        }
    }

    private void ClientDisconnected(int clientIdx) {
        ClientHandler disconnectedClient = db.getClientManager().getClientHandler(clientIdx);
        if (disconnectedClient.info != null) {
            String name = disconnectedClient.info.getName();
            for (int j = 0; j < db.getClientManager().getAnzClients(); j++) {
                ClientInfo curClientInfo = disconnectedClient.info;
                if (curClientInfo != null && !curClientInfo.getName().equals(name)) {
                    db.getClientManager().SendMessageToClient(j, "CLD" + name);
                }
            }
            db.getMainFrame().RemoveName(name);
        }
        db.getClientManager().RemoveClient(clientIdx);
    }
}
