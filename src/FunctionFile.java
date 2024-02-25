import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FunctionFile {
    GUI gui;
    String fileName;
    String fileAddress;

    public FunctionFile(GUI gui) {
        this.gui = gui;
    }

    public void newFile() {
        gui.text.setText("");
        gui.window.setTitle("New");
        fileName = null;
        fileAddress = null;
    }

    public void open() {
        FileDialog fileDialog = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fileDialog.setVisible(true);

        if(fileDialog.getFile()!=null) {
            fileName = fileDialog.getFile();
            fileAddress = fileDialog.getDirectory();
            gui.window.setTitle(fileName); // title on window
        }
        System.out.println("File Address : " + fileAddress + fileName);

        try{
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName)); // need address to read file

            gui.text.setText("");

            String line = null;
            while((line = br.readLine()) != null) {
                gui.text.append(line + "\n");
            }
            br.close();
        } catch (Exception e) {
            System.out.println("FILE NOT OPENED!");
        }
    }

    public void save() {
        if(fileName == null) {
            saveAs();
        }
        else {
            try {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.text.getText());
                fw.close();
            } catch (Exception e) {
                System.out.println("Wrong");
            }
        }
    }

    public void saveAs() {
        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if(fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);

            try {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.text.getText());
                fw.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void exit() {
        System.exit(0);
    }
}
