package de.itfor.hsqldb;

import de.itfor.hsqldb.forms.ImportForm;

/**
 * Created by Philipp Bergt and Jan Schneck on 02.07.15.
 */
public class HSQLDB {

    public static void main(String[] args) {
        ImportForm dialog = new ImportForm();
        dialog.pack();
        dialog.setVisible(true);
    }

}