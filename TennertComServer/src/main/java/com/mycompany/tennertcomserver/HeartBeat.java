package com.mycompany.tennertcomserver;

import java.util.ArrayList;

public class HeartBeat extends Thread {

    Datenbank db;

    public HeartBeat(Datenbank db){
        this.db = db;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) 1000);
            } catch (InterruptedException ex) {}
            for (int i = 0; i < db.getAnzClients(); i++) {
                db.getClient(i).SendMsg("HBT");
            }
            for (int i = 0; i < db.getAnzClients(); i++) {
                if (System.currentTimeMillis() - db.getClient(i).lastBeatReceived > 3000) {
                    if (db.getClient(i).info != null) {
                        String name = db.getClient(i).info.name;
                        for (int j = 0; j < db.getAnzClients(); j++) {
                            ClientInfo curClientInfo = db.getClient(i).info;
                            if (curClientInfo != null && !curClientInfo.name.equals(name)) {
                                db.getClient(i).SendMsg("CLD" + name);
                            }
                        }
                        db.mainFrame.RemoveName(name);
                    }
                    db.RemoveClient(i);
                }
            }
        }
    }
}
