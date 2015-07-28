package de.itfor.hsqldb.forms;

import de.itfor.hsqldb.listeners.DBFileMouseListener;
import de.itfor.hsqldb.listeners.SQLFilesMouseListener;
import de.itfor.hsqldb.listeners.SQLImportActionListener;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class ConnectionForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField userField;
    private JPasswordField pwdField;
    private JTextField dbField;
    private JTextField filesField;
    private JButton connect;

    private File dbFile;
    private File[] sqlFiles;

    public ConnectionForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setVisible(true);

        JMenu menu = new JMenu("Menu");
        menu.setVisible(true);

        JMenuItem statementItem = new JMenuItem("SQL Insert");
        statementItem.setVisible(true);
        statementItem.addActionListener(new SQLImportActionListener());
        statementItem.setEnabled(false);

        JMenuItem importItem = new JMenuItem("Files Import");
        importItem.setEnabled(false);
        importItem.setVisible(true);

        menu.add(statementItem);
        menu.add(importItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(getParent());
            }
        });


        dbField.addMouseListener(new DBFileMouseListener(getParent()));
        filesField.addMouseListener(new SQLFilesMouseListener(getParent()));

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

}
