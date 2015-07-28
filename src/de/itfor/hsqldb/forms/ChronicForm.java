package de.itfor.hsqldb.forms;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class ChronicForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JProgressBar progressBar1;
    private JTextPane c;

    private SimpleAttributeSet infoAttr = new SimpleAttributeSet();
    private SimpleAttributeSet errorAttr = new SimpleAttributeSet();

    public ChronicForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        this.c.setText("Execution ...");

        StyleConstants.setFontFamily(infoAttr, "Gulim");
        StyleConstants.setFontSize(infoAttr, 12);
        StyleConstants.setForeground(infoAttr, Color.black);

        StyleConstants.setFontFamily(errorAttr, "Gulim");
        StyleConstants.setFontSize(errorAttr, 12);
        StyleConstants.setForeground(errorAttr, Color.red);
        StyleConstants.setBold(errorAttr, true);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
// add your code here
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public void WriteLine(String text, AttributeSet attr) {
        StyledDocument doc = this.c.getStyledDocument();
        try {
            doc.insertString(doc.getLength(), "\n" + text, null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public void WriteInfo(String text) {
        WriteLine(text, infoAttr);
    }

    public void WriteError(String text) {
        WriteLine(text, errorAttr);
    }
}
