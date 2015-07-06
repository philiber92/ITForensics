package de.itfor.hsqldb.listeners;

import de.itfor.hsqldb.file.filter.TypeFileFilter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

/**
 * Created by Philipp Bergt and Jan Schneck on 02.07.15.
 */
public class SQLFilesMouseListener implements MouseListener {

    Container _parent;

    public SQLFilesMouseListener(Container parent) {
        _parent = parent;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        TypeFileFilter sqlFileFilter = new TypeFileFilter("sql");
        fileChooser.setFileFilter(sqlFileFilter);
        fileChooser.setMultiSelectionEnabled(true);
        int result = fileChooser.showOpenDialog(_parent);

    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
