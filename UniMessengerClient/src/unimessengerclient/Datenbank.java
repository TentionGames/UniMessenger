package unimessengerclient;

public class Datenbank {
    
    private final MainFrame mainFrame;
    private final HeartBeat heartBeat;
    private final ServerHandler serverHandler;
    
    public Datenbank(){
        mainFrame = new MainFrame(this);
        heartBeat = new HeartBeat(this);
        serverHandler = new ServerHandler(this);
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public HeartBeat getHeartBeat() {
        return heartBeat;
    }

    public ServerHandler getServerHandler() {
        return serverHandler;
    }
}
