package unimessengerclient;

import java.io.File;

public class MyCustomFilter extends javax.swing.filechooser.FileFilter{

    @Override
    public boolean accept(File file) {
        return file.isDirectory() || file.getAbsolutePath().endsWith(".jpg") || file.getAbsolutePath().endsWith(".png") || file.getAbsolutePath().endsWith(".pdf");
    }

    @Override
    public String getDescription() {
        return "Images (*.png, *.jpg) and PDFs (*.pdf)";
    }
    
}
