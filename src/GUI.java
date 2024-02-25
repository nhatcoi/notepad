import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;

public class GUI implements ActionListener {

    JFrame window;

    // text area
    JTextArea text;
    JScrollPane scrollPane;
    // menu bar
    JMenuBar menuBar;
    // file menu
    JMenu menuFile, menuEdit, menuFormat, menuColor, menuReport;
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;

    // edit menu
    JMenuItem iUndo, iRedo;

    // format menu
    JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
    JMenu menuFont, menuFontSize;
    boolean wordWrapOn = false;

    // color menu
    JMenuItem iColor1, iColor2, iColor3;

    // report menu
    JMenuItem iReport;


    FunctionFile file = new FunctionFile(this);
    FunctionFormat format = new FunctionFormat(this);
    FunctionColor color = new FunctionColor(this);
    FunctionEdit edit = new FunctionEdit(this);
    FunctionReport report = new FunctionReport(this);

    UndoManager um = new UndoManager();

    public static void main(String[] args) {

        new GUI();
    }

    public GUI() {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createEditMenu();
        createFormatMenu();
        createColor();
        createReport();

        format.selectedFont = "Arial";
        format.createFont(16);
        format.wordWrap();

        color.changeColor("White");

        window.setVisible(true);

    }

    public void createWindow() {
        window = new JFrame("Notepad by Nhat Coi");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea() {
        text = new JTextArea();

        text.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit());
            }
        });

        scrollPane = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        window.add(scrollPane);
    }

    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);
        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);
        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);
        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
        menuReport = new JMenu("Report");
        menuBar.add(menuReport);

    }

    public void createFileMenu() {
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);


        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("Save As");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("E xít");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }

    public void createFormatMenu() {

        // Word wrap
        iWrap = new JMenuItem("Word Wrap: Off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);


        // Font
        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);


        // Font size
        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("size8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("size12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("size16");
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("size20");
        menuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("size24");
        menuFontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("size28");
        menuFontSize.add(iFontSize28);
    }

    public void createColor() {

        iColor1 = new JMenuItem("White");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("White");
        menuColor.add(iColor1);

        iColor2 = new JMenuItem("Black");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Black");
        menuColor.add(iColor2);

        iColor2 = new JMenuItem("Blue");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Blue");
        menuColor.add(iColor2);
    }

    public void createEditMenu(){
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);

        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);
    }

    public void createReport() {
        iReport = new JMenuItem("Report");
        iReport.addActionListener(this);
        iReport.setActionCommand("Report");
        menuReport.add(iReport);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch(command) {
            case "New": file.newFile(); break;
            case "Open" : file.open(); break;
            case "Save": file.save(); break;
            case "Save As": file.saveAs(); break;
            case "Undo" : edit.undo(); break;
            case "Redo" : edit.redo(); break;
            case "Word Wrap" : format.wordWrap(); break;
            case "Arial" : format.setFont(command); break;
            case "Comic Sans MS" : format.setFont(command); break;
            case "Times New Roman" : format.setFont(command); break;
            case "size8" : format.createFont(8); break;
            case "size12" : format.createFont(12); break;
            case "size16" : format.createFont(16); break;
            case "size20" : format.createFont(20); break;
            case "size24" : format.createFont(24); break;
            case "size28" : format.createFont(28); break;
            case "Exit" : file.exit(); break;
            case "White" : color.changeColor(command); break;
            case "Black" : color.changeColor(command); break;
            case "Blue" : color.changeColor(command); break;
            case "Report" :
                try {
                    report.openWebLink("https://www.messenger.com/t/100038026341974");
                } catch (URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }
        }
    }
}