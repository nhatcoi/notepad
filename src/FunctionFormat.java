import java.awt.*;

public class FunctionFormat {
    GUI gui;
    Font arial, comicSansMs, timesNewRoman;
    String selectedFont;

    public FunctionFormat(GUI gui) {
        this.gui = gui;
    }

    public void wordWrap() {
        if(!gui.wordWrapOn) {
            gui.wordWrapOn = true;
            gui.text.setLineWrap(true);
            gui.text.setWrapStyleWord(true);
            gui.iWrap.setText("Word Wrap: On");
        } else {
            gui.wordWrapOn = false;
            gui.text.setLineWrap(false);
            gui.text.setWrapStyleWord(false);
            gui.iWrap.setText("Word Wrap: Off");
        }
    }

    public void createFont(int fontSize) {

        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMs = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);

        setFont(selectedFont);
    }

    public void setFont(String font) {
        selectedFont = font;

        switch (selectedFont) {
            case "Arial" :
                gui.text.setFont(arial);
                break;
            case "Comic Sans MS" :
                gui.text.setFont(comicSansMs);
                break;
            case "Times New Roman" :
                gui.text.setFont(timesNewRoman);
                break;
        }
    }
}
