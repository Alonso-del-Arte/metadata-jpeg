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

import java.io.File;
import java.io.FileNotFoundException;

import javax.imageio.ImageIO;

/**
 *
 * @author Alonso del Arte
 */
public class MetadataManager {
    
    private File currentlyOpen = null;
    
    void openFile(File file) throws FileNotFoundException {
        this.currentlyOpen = file;
    }
    
    void closeFile() {
//        this.currentlyOpen = null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
