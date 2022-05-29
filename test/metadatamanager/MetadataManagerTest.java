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

import imageops.TestImagePanel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

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
    
    private static File TEST_FILE;
    
    private static final Random RANDOM = new Random();
    
    private static final TestImagePanel TEST_IMAGE = new TestImagePanel();
    
    @BeforeClass
    public static void setUpClass() throws IOException {
        BufferedImage image = new BufferedImage(TestImagePanel.PANEL_WIDTH, 
                TestImagePanel.PANEL_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.createGraphics();
        TEST_IMAGE.paint(g);
        String filename = TEMP_DIR_PATH + File.separatorChar + "TestImage" 
                + RANDOM.nextInt() + ".jpg";
        TEST_FILE = new File(filename);
        ImageIO.write(image, "JPG", TEST_FILE);
        System.out.println("Successfully wrote " + TEST_FILE.getAbsolutePath());
    }
    
    /**
     * Another test of the getFile function, of the MetadataManager class. When 
     * the program is first opened, getFile() should return null.
     */
    @Test
    public void testGetFileAtTheBeginning() {
        MetadataManager manager = new MetadataManager();
        File file = manager.getFile();
        String msg = "No file open at first, getFile() should return null";
        assertNull(msg, file);
    }
    
    /**
     * Another test of the openFile procedure, of the MetadataManager class. 
     * Null file should be rejected.
     * @throws java.io.FileNotFoundException
     */
    @Test(expected = NullPointerException.class)
    public void testOpenFileRejectsNull() throws FileNotFoundException {
        MetadataManager manager = new MetadataManager();
        manager.openFile(null);
        System.out.println("Somehow opened null file");
    }
    
    /**
     * Another test of the openFile procedure, of the MetadataManager class. 
     * A directory (folder) should be rejected.
     * @throws java.io.FileNotFoundException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testOpenFileRejectsDirectory() throws FileNotFoundException {
        String dirPathName = System.getProperty("user.dir");
        File dir = new File(dirPathName);
        MetadataManager manager = new MetadataManager();
        manager.openFile(dir);
        System.out.println("Somehow opened " + dir.getAbsolutePath() 
                + " as if it were a file");
    }
    
    /**
     * Test of the openFile procedure, of the MetadataManager class.
     * @throws FileNotFoundException
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
    
    @AfterClass
    public static void tearDownClass() {
        TEST_IMAGE.closePanel();
        if (TEST_FILE.delete()) {
            System.out.println("Successfully deleted " 
                    + TEST_FILE.getAbsolutePath());
        } else {
            String excMsg = "Unable to delete " + TEST_FILE.getAbsolutePath();
            throw new RuntimeException(excMsg);
        }
    }
    
}
