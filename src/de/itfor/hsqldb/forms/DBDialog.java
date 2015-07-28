package de.itfor.hsqldb.forms;

import de.itfor.hsqldb.Database;

import javax.swing.*;

/**
 * Created by Philipp Bergt and Jan Schneck on 19.07.2015.
 */
public class DBDialog extends JDialog {

    protected Database db;

    public DBDialog(Database db) {
        super();
        this.db = db;
    }

}
