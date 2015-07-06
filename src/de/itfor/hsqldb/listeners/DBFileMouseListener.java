package de.itfor.hsqldb.listeners;

import de.itfor.hsqldb.file.filter.TypeFileFilter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

/**
 * Created by Philipp Bergt and Jan Schneck on 06.07.15.
 */
public class DBFileMouseListener implements MouseListener{

    Container _parent;

    public DBFileMouseListener(Container parent) {
        _parent  = parent;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        TypeFileFilter fileFilter = new TypeFileFilter("db");
        fileChooser.setFileFilter(fileFilter);
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
