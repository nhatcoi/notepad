import java.awt.*;

public class FunctionColor {

    GUI gui;

    public FunctionColor(GUI gui) {
        this.gui = gui;
    }

    public void changeColor(String color) {

        switch (color) {
            case "White" :
                gui.window.getContentPane().setBackground(Color.white);
                gui.text.setBackground(Color.white);
                gui.text.setForeground(Color.black);
                break;
            case "Black" :
                gui.window.getContentPane().setBackground(Color.black);
                gui.text.setBackground(Color.black);
                gui.text.setForeground(Color.white);
                break;
            case "Blue" :
                gui.window.getContentPane().setBackground(new Color(153,204,255));
                gui.text.setBackground(new Color(153,204,255));
                gui.text.setForeground(Color.white);
                break;
        }
    }
}
