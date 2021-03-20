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
     * Test of accept method, of class JPEGFileFilter.
     */
    @Test
    public void testAccept() {
        System.out.println("accept");String filename = "image.jpg";
        File file = new File(filename);
        JPEGFileFilter filter = new JPEGFileFilter();
        String msg = "JPEG file filter should accept file " + file.toString();
        assert filter.accept(file) : msg;
    }

    /**
     * Test of getDescription method, of class JPEGFileFilter.
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
