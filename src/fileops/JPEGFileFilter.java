/*
 * Copyright (C) 2022 Alonso del Arte
 *
 * This program is free software: you can redistribute it and/or modify it under 
 * the terms of the GNU General Public License as published by the Free Software 
 * Foundation, either version 3 of the License, or (at your option) any later 
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more 
 * details.
 *
 * You should have received a copy of the GNU General Public License along with 
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package fileops;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * A filter to tell a file chooser to accept JPEG files and reject files of 
 * other types. This filter only checks the file extension, it does not try to 
 * validate the contents according to the JPEG standard. The filter also accepts 
 * directories.
 * @author Alonso del Arte
 */
public class JPEGFileFilter extends FileFilter {

    /**
     * Determines whether or not to accept a file.
     * @param file The file to accept or reject.
     * @return True if the file has the *.jpg extension, false otherwise.
     */
    @Override
    public boolean accept(File file) {
        return file.getName().endsWith(".jpg");
    }

    // STUB TO FAIL THE FIRST TEST
    @Override
    public String getDescription() {
        return "Sorry, not implemented yet";
    }
    
}
