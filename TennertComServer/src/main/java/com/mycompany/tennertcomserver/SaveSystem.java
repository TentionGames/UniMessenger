package com.mycompany.tennertcomserver;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaveSystem {
    
    private Datenbank db;
    
    public SaveSystem(Datenbank db){
        this.db = db;
        File directory = new File("C:/UniMessenger/");
        if(!directory.exists()) directory.mkdir();
        File[] files = directory.listFiles();
        for (int i = 0; i < files.length; i++) {
            if(files[i].isFile()){
                try {
                    ImportFile(files[i].getAbsolutePath());
                }
                catch (FileNotFoundException e) {}
                catch (IOException e) {}
                catch (ClassNotFoundException e) {}
            }
        }
        
        db.getMainFrame().SetLog(LoadLogFile());
    }
    
    private void ImportFile(String path) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.readObject();
        if (obj instanceof ClientInfo) {
            db.AddClientInfo((ClientInfo)obj);
        }
        if (ois != null) try { ois.close(); } catch (IOException e) {}
        if (fis != null) try { fis.close(); } catch (IOException e) {}
    }
    
    public void SaveClientInfo(ClientInfo clientInfo){
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("C:/UniMessenger/" + clientInfo.getName() + ".ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(clientInfo);
        }
        catch (IOException e) {System.out.println(e);}
        finally {
          if (oos != null) try { oos.close(); } catch (IOException e) {}
          if (fos != null) try { fos.close(); } catch (IOException e) {}
        }
    }
    
    public void SaveLogFile(String log){
        try {
            Files.writeString(Path.of("C:/UniMessenger/log.txt"), log);
        } catch (IOException ex) {}
    }
    
    private String LoadLogFile(){
        try {
            return Files.readString(Path.of("C:/UniMessenger/log.txt"));
        } catch (IOException ex) {return "";}
    }
}
