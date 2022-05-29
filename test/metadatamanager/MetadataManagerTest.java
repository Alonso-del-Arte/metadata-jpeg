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

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests of the MetadataManager class.
 * @author Alonso del Arte
 */
public class MetadataManagerTest {
    
    private static final String TEMP_DIR_PATH 
            = System.getProperty("java.io.tmpdir");
    
    private static final File TEMP_DIR = new File(TEMP_DIR_PATH);
    
    /**
     * Another test of the getFile function, of the MetadataManager class.
     */
    @Test
    public void testGetFileAtBeginning() {
        MetadataManager manager = new MetadataManager();
        File file = manager.getFile();
        String msg = "No file open at first, getFile() should return null";
        assertNull(msg, file);
    }
    
    /**
     * Test of openFile method, of class MetadataManager.
     * @throws java.io.FileNotFoundException
     */
//    @Test
    public void testOpenFile() throws FileNotFoundException {
        System.out.println("openFile");
        File file = null;
        MetadataManager instance = new MetadataManager();
        instance.openFile(file);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of the getFile function, of the MetadataManager class.
     */
//    @Test
    public void testGetFile() {
        System.out.println("getFile");
        MetadataManager instance = new MetadataManager();
        File expResult = null;
        File result = instance.getFile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveFile method, of class MetadataManager.
     */
//    @Test
    public void testSaveFile() {
        System.out.println("saveFile");
        MetadataManager instance = new MetadataManager();
        instance.saveFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeFile method, of class MetadataManager.
     */
//    @Test
    public void testCloseFile() {
        System.out.println("closeFile");
        MetadataManager instance = new MetadataManager();
        instance.closeFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class MetadataManager.
     */
//    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MetadataManager.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
