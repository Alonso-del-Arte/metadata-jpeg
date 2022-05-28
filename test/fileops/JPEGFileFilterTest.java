/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileops;

import java.io.File;

import org.junit.Test;
import static org.junit.Assert.*;

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
