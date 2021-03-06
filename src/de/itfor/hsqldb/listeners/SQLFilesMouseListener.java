package de.itfor.hsqldb.listeners;

import de.itfor.hsqldb.file.filter.TypeFileFilter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Philipp Bergt and Jan Schneck on 02.07.15.
 */
public class SQLFilesMouseListener implements MouseListener {

    private Container _parent;
    private List<File> files;

    public SQLFilesMouseListener(Container parent) {
        _parent = parent;
        files = new ArrayList();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        TypeFileFilter sqlFileFilter = new TypeFileFilter("sql");
        fileChooser.setFileFilter(sqlFileFilter);
        fileChooser.setMultiSelectionEnabled(true);

        int result = fileChooser.showOpenDialog(_parent);
        if(result == JFileChooser.APPROVE_OPTION) {
            files = new ArrayList(Arrays.asList(fileChooser.getSelectedFiles()));
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public List<File> getFiles() {
        return files;
    }
}
