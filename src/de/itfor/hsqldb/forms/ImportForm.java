package de.itfor.hsqldb.forms;

import de.itfor.hsqldb.Database;
import de.itfor.hsqldb.listeners.SQLFilesMouseListener;
import de.itfor.hsqldb.listeners.SQLImportActionListener;

import javax.swing.*;
import java.awt.event.*;

public class ImportForm extends DBDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField selectErrorFileTextField;
    private SQLFilesMouseListener filesListener;

    public ImportForm(Database database) {
        super(database);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        filesListener = new SQLFilesMouseListener(getParent());

        buttonCancel.addActionListener(e -> onCancel());
        textField1.addMouseListener(filesListener);
        buttonOK.addActionListener(new SQLImportActionListener(db));

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }


    private void onCancel() {
// add your code here if necessary
        dispose();
    }
}
