package com.mycompany.tennertcomclient;

public class HeartBeat extends Thread {

    long lastBeatReceived = System.currentTimeMillis();

    private final Datenbank db;
    private boolean running = true;
    
    public HeartBeat(Datenbank db){
        this.db = db;
    }
    
    @Override
    public void run() {
        running = true;
        while (running) {
            SendHB();
            Wait(1000);
            ListenToHB();
        }
    }

    public void Stop(){
        running = false;
    }
    
    private void Wait(int millSec) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
    }

    private void SendHB() {
        db.getServerHandler().SendMsg("HBT");
    }

    private void ListenToHB() {
        if (System.currentTimeMillis() - lastBeatReceived >= 3000) {
            db.getServerHandler().Disconnect();
        }
    }

    public void ReceivedBeat() {
        lastBeatReceived = System.currentTimeMillis();
    }
}
