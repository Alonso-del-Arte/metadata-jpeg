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
package metadatamanager;

import fileops.JPEGFileFilter;

import java.io.File;
import java.io.FileNotFoundException;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Alonso del Arte
 */
public class MetadataManager {
    
    private static final FileFilter FILTER = new JPEGFileFilter();
    
    private File currentlyOpen = null;
    
    /**
     * Opens a file.
     * @param file The file to open.
     * @throws IllegalArgumentException If <code>file</code> is a directory or 
     * if it's not recognized as a JPEG file.
     * @throws NullPointerException If <code>file</code> is null.
     * @throws FileNotFoundException If there's a problem opening the file or if 
     * the file does not exist.
     */
    void openFile(File file) throws FileNotFoundException {
        if (file == null) {
            String excMsg = "file must not be null";
            throw new NullPointerException(excMsg);
        }
        if (file.isDirectory()) {
            String excMsg = file.getAbsolutePath() 
                    + " is a directory, not a file";
            throw new IllegalArgumentException(excMsg);
        }
        if (!FILTER.accept(file)) {
            String excMsg = file.getName() + " is not a JPEG file";
            throw new IllegalArgumentException(excMsg);
        }
        if (!file.exists()) {
            String excMsg = file.getAbsolutePath() + " not found";
            throw new FileNotFoundException(excMsg);
        }
        this.currentlyOpen = file;
    }
    
    /**
     * Retrieves the currently open file. This package private function exists 
     * mostly, or perhaps entirely, for the sake of testing.
     * @return A {@code File} object for the currently open file.
     */
    File getFile() {
        return this.currentlyOpen;
    }
    
    void saveFile() {
        //
    }
    
    void closeFile() {
        this.currentlyOpen = null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
