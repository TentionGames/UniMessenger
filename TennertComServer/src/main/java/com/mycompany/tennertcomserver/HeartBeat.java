package com.mycompany.tennertcomserver;

import java.util.ArrayList;

public class HeartBeat extends Thread {

    ArrayList<ClientHandler> clientHandlers = MainFrame.comManager.clientHandlers;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) 1000);
            } catch (InterruptedException ex) {}
            for (int i = 0; i < clientHandlers.size(); i++) {
                clientHandlers.get(i).SendMsg("HBT");
            }
            for (int i = 0; i < clientHandlers.size(); i++) {
                if (System.currentTimeMillis() - clientHandlers.get(i).lastBeatReceived > 3000) {
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
