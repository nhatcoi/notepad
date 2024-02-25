import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class FunctionReport {
    GUI gui;

    public FunctionReport(GUI gui) {
        this.gui = gui;
    }

    public void openWebLink(String url) throws URISyntaxException {
        try{
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
