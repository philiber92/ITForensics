package de.itfor.hsqldb.listeners;

import de.itfor.hsqldb.Database;
import de.itfor.hsqldb.forms.ChronicForm;
import de.itfor.hsqldb.forms.StatementForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.sql.SQLException;

/**
 * Created by Philipp Bergt and Jan Schneck on 18.07.2015.
 */
public class SQLImportActionListener extends DBListener implements ActionListener{

    ChronicForm chronicForm;

    public SQLImportActionListener(Database db) {
        super(db);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        chronicForm = new ChronicForm();
        chronicForm.pack();
        chronicForm.setVisible(true);
    }

    private void writeFilesToDB(File[] sqlFiles, File errorFile) {
        try(PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(errorFile.getAbsolutePath())))){
            for(File file : sqlFiles) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void executeStatement(String statement) {
        try {
            db.query(statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
