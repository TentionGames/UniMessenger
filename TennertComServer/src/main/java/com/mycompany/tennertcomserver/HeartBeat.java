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
        for (int i = 0; i < db.getAnzClients(); i++) {
            db.getClientHandler(i).SendMsg("HBT");
        }
    }

    private void ListenToHB() {
        for (int i = 0; i < db.getAnzClients(); i++) {
            if (System.currentTimeMillis() - db.getClientHandler(i).getLastBeatReceived() > 3000) {
                ClientDisconnected(i);
            }
        }
    }

    private void ClientDisconnected(int clientIdx) {
        if (db.getClientHandler(clientIdx).info != null) {
            String name = db.getClientHandler(clientIdx).info.getName();
            for (int j = 0; j < db.getAnzClients(); j++) {
                ClientInfo curClientInfo = db.getClientHandler(clientIdx).info;
                if (curClientInfo != null && !curClientInfo.getName().equals(name)) {
                    db.getClientHandler(clientIdx).SendMsg("CLD" + name);
                }
            }
            db.getMainFrame().RemoveName(name);
        }
        db.RemoveClient(clientIdx);
    }
}
