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

import org.junit.Test;

/**
 *
 * @author Alonso del Arte
 */
public class JPEGFileFilterTest {
    
    /**
     * Test of the accept function, of the JPEGFileFilter class. The extension 
     * *.jpg should be accepted.
     */
    @Test
    public void testAccept() {
        System.out.println("accept");
        String filename = "image.jpg";
        File file = new File(filename);
        JPEGFileFilter filter = new JPEGFileFilter();
        String msg = "JPEG file filter should accept file " + file.toString();
        assert filter.accept(file) : msg;
    }
    
    /**
     * Another test of the accept function, of the JPEGFileFilter class. The 
     * extension *.png should be rejected.
     */
    @Test
    public void testRejectPNG() {
        String filename = "image.png";
        File file = new File(filename);
        JPEGFileFilter filter = new JPEGFileFilter();
        String msg = "JPEG file filter should reject file " + file.toString();
        assert !filter.accept(file) : msg;
    }

    /**
     * Another test of the accept function, of the JPEGFileFilter class. The 
     * extension *.txt should be rejected.
     */
    @Test
    public void testRejectText() {
        String filename = "document.txt";
        File file = new File(filename);
        JPEGFileFilter filter = new JPEGFileFilter();
        String msg = "JPEG file filter should reject file " + file.toString();
        assert !filter.accept(file) : msg;
    }

    /**
     * Another test of the accept function, of the JPEGFileFilter class. The 
     * extension *.html should be rejected.
     */
    @Test
    public void testRejectHTML() {
        String filename = "index.html";
        File file = new File(filename);
        JPEGFileFilter filter = new JPEGFileFilter();
        String msg = "JPEG file filter should reject file " + file.toString();
        assert !filter.accept(file) : msg;
    }

    /**
     * Another test of the accept function, of the JPEGFileFilter class. The 
     * extension *.rtf should be rejected.
     */
    @Test
    public void testRejectRichText() {
        String filename = "document.rtf";
        File file = new File(filename);
        JPEGFileFilter filter = new JPEGFileFilter();
        String msg = "JPEG file filter should reject file " + file.toString();
        assert !filter.accept(file) : msg;
    }

    /**
     * Another test of the accept function, of the JPEGFileFilter class. The 
     * extension *.JPG should be accepted.
     */
    @Test
    public void testAcceptUpperCaseExtension() {
        String filename = "image.JPG";
        File file = new File(filename);
        JPEGFileFilter filter = new JPEGFileFilter();
        String msg = "JPEG file filter should accept file " + file.toString();
        assert filter.accept(file) : msg;
    }

    /**
     * Another test of the accept function, of the JPEGFileFilter class. 
     * Directories (folders) should be accepted, since they might contain files 
     * that would be accepted, or their subdirectories might.
     */
    @Test
    public void testAcceptFolder() {
        String dirName = System.getProperty("user.dir");
        File dir = new File(dirName);
        JPEGFileFilter filter = new JPEGFileFilter();
        String msg = "JPEG file filter should accept folder " + dir.toString();
        assert filter.accept(dir) : msg;
    }

    /**
     * Test of the getDescription function, of the JPEGFileFilter class. The 
     * description should include the acronym "JPEG".
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        JPEGFileFilter filter = new JPEGFileFilter();
        String description = filter.getDescription();
        String msg = "Description should include \"JPEG\"";
        assert description.contains("JPEG") : msg;
    }
    
}
