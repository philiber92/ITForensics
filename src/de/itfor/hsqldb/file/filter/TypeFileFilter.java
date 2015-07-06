package de.itfor.hsqldb.file.filter;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Philipp Bergt and Jan Schneck on 06.07.15.
 */
public class TypeFileFilter extends FileFilter{

    String _type;

    public TypeFileFilter(String type) {
        if(type == null) {
            throw new NullPointerException("Type can't be null!");
        }
        _type = type.toLowerCase().trim();
    }


    @Override
    public boolean accept(File f) {
        String[] type = f.getName().split("\\.");
        if(type.length>1) {
            if(type[type.length-1].contentEquals(_type) && f.exists()) {
                return true;
            }
        } else {
            if(f.isDirectory() && f.exists()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "*." + _type;
    }
}
