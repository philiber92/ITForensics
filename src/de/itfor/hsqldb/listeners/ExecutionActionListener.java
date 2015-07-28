package de.itfor.hsqldb.listeners;

import de.itfor.hsqldb.Database;
import de.itfor.hsqldb.forms.ChronicForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by Philipp Bergt and Jan Schneck on 18.07.2015.
 */
public class ExecutionActionListener extends DBListener implements ActionListener {

    String statement;

    public ExecutionActionListener(Database db, String statement) {
        super(db);
        this.statement = statement;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // show chronic form
        ChronicForm chronic = new ChronicForm();
        chronic.pack();
        chronic.setVisible(true);

        try {
            db.query(statement);
            chronic.WriteInfo("Statement was executed successfully");
        } catch (SQLException ex) {
            chronic.WriteError("Statement couldn't executed successfully: " + ex);
        }
    }
}
