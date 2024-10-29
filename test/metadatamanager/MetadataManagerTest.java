/*
 * Copyright (C) 2024 Alonso del Arte
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

import org.apache.commons.imaging.formats.jpeg.JpegImageMetadata;

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
     */
    @Test(expected = NullPointerException.class)
    public void testOpenFileRejectsNull() {
        MetadataManager manager = new MetadataManager();
        try {
            manager.openFile(null);
            System.out.println("Somehow opened null file");
        } catch (FileNotFoundException fnfe) {
            throw new RuntimeException(fnfe);
        }
    }
    
    /**
     * Another test of the openFile procedure, of the MetadataManager class. 
     * A directory (folder) should be rejected.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testOpenFileRejectsDirectory() {
        String dirPathName = System.getProperty("user.dir");
        File dir = new File(dirPathName);
        MetadataManager manager = new MetadataManager();
        try {
            manager.openFile(dir);
            System.out.println("Somehow opened " + dir.getAbsolutePath() 
                    + " as if it were a file");
        } catch (FileNotFoundException fnfe) {
            throw new RuntimeException(fnfe);
        }
    }
    
    /**
     * Another test of the openFile procedure, of the MetadataManager class. 
     * An image file that is not JPEG file should be rejected. This test creates 
     * an empty GIF file because a later test will require files to exist. The 
     * file is deleted before concluding the test.
     * @throws IOException If a problem occurs trying to create an empty GIF 
     * file for this test.
     */
    @Test
    public void testOpenFileRejectsNonJPEGFile() throws IOException {
        String filename = TEMP_DIR_PATH + File.separatorChar + "image.gif";
        File file = new File(filename);
        file.createNewFile();
        MetadataManager manager = new MetadataManager();
        try {
            manager.openFile(file);
            System.out.println("Somehow opened " + file.getAbsolutePath() 
                    + " even though it's not a JPEG");
        } catch (IllegalArgumentException iae) {
            System.out.println("Trying to open " + file.getAbsolutePath() 
                    + " correctly caused IllegalArgumentException");
            System.out.println("\"" + iae.getMessage() + "\"");
        } catch (RuntimeException re) {
            String msg = re.getClass().getName() 
                    + " is the wrong exception for trying to open " 
                    + file.getAbsolutePath();
            fail(msg);
        } finally {
            file.delete();
        }
    }
    
    /**
     * Another test of the openFile procedure, of the MetadataManager class. 
     * An image file that is not JPEG file should be rejected. This test creates 
     * an empty GIF file because a later test will require files to exist.
     * @throws FileNotFoundException This one should always occur, but also it 
     * should be caught and reported by the test runner. If it doesn't occur, 
     * check to make sure java.io.tmpdir does not have a file called 
     * nonexistent.jpg.
     */
    @Test(expected = FileNotFoundException.class)
    public void testOpenFileRejectsNonExistentFile() 
            throws FileNotFoundException {
        String filename = TEMP_DIR_PATH + File.separatorChar 
                + "nonexistent.jpg";
        File file = new File(filename);
        String msg = file.getAbsolutePath() + " should not exist";
        assert !file.exists() : msg;
        MetadataManager manager = new MetadataManager();
        manager.openFile(file);
        System.out.println("Somehow opened " + file.getAbsolutePath() 
                + " even though it doesn't actually exist");
    }
    
    /**
     * Test of the openFile procedure, of the MetadataManager class.
     */
    @Test
    public void testOpenFile() {
        System.out.println("openFile");
        MetadataManager manager = new MetadataManager();
        try {
            manager.openFile(TEST_FILE);
        } catch (FileNotFoundException fnfe) {
            String errMsg = "FileNotFoundException shouldn't have occurred for " 
                    + TEST_FILE.getAbsolutePath();
            throw new AssertionError(errMsg, fnfe);
        }
    }

    /**
     * Test of the getFile function, of the MetadataManager class.
     * @throws java.io.FileNotFoundException If the file is not found. But that 
     * shouldn't happen in this context, the test file should have been created 
     * by the test class set up.
     */
    @Test
    public void testGetFile() throws FileNotFoundException {
        System.out.println("getFile");
        MetadataManager manager = new MetadataManager();
        manager.openFile(TEST_FILE);
        File actual = manager.getFile();
        assertEquals(TEST_FILE, actual);
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
     * Test of the closeFile procedure, of the MetadataManager class.
     * @throws java.io.FileNotFoundException If the file is not found. But that 
     * shouldn't happen in this context, the test file should have been created 
     * by the test class set up.
     */
    @Test
    public void testCloseFile() throws FileNotFoundException {
        System.out.println("closeFile");
        MetadataManager manager = new MetadataManager();
        manager.openFile(TEST_FILE);
        manager.closeFile();
        File file = manager.getFile();
        String msg = "After closing the file, getFile( ) should return null";
        assert file == null : msg;
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
