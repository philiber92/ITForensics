package de.itfor.hsqldb;

import de.itfor.hsqldb.forms.ConnectionForm;

/**
 * Created by Philipp Bergt and Jan Schneck on 02.07.15.
 */
public class HSQLDB {

    public static void main(String[] args) {
        ConnectionForm dialog = new ConnectionForm();
        dialog.pack();
        dialog.setVisible(true);
    }

}