package de.itfor.hsqldb.listeners;

import de.itfor.hsqldb.Database;

/**
 * Created by Philipp on 19.07.2015.
 */
public class DBListener {

    protected Database db;

    public DBListener(Database db) {
        this.db = db;
    }

}
