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
package imageops;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * A simple JComponent that creates a window with a simple image for the purpose 
 * of testing various operations with images.
 * @author Alonso del Arte
 */
public final class TestImagePanel extends JPanel {
    
    /**
     * The background color, blue. RGB: 0000FF.
     */
    public static final Color BACKGROUND_COLOR = new Color(255);
    
    /**
     * A blue green or green blue. RGB: 008080.
     */
    public static final Color MEDIUM_GREEN = new Color(32896);
    
    /**
     * The height of this panel's paintable area. Does not include title bar, 
     * menu bar (if applicable), nor bottom frame border.
     */
    public static final int PANEL_HEIGHT = 300;
    
    /**
     * The width of this panel's paintable area. Does not include left or right 
     * frame borders.
     */
    public static final int PANEL_WIDTH = 400;
    
    private JFrame frame;
    
    private void paintSky(Graphics g, int top, int horizon) {
        Color currColor = BACKGROUND_COLOR;
        for (int i = top; i < horizon; i++) {
            g.setColor(currColor);
            g.drawLine(0, i, PANEL_WIDTH, i);
            currColor = new Color(i, i, 255);
        }
    }
    
    private void paintGround(Graphics g, int horizon, int bottom) {
        Color currColor = MEDIUM_GREEN;
        int red = currColor.getRed();
        int green = currColor.getGreen();
        int blue = currColor.getBlue();
        for (int i = horizon; i <= bottom; i += 2) {
            g.setColor(currColor);
            g.fillRect(0, i, PANEL_WIDTH, i + 1);
            red++;
            green++;
            blue++;
            currColor = new Color(red, green, blue);
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        int oneThirdHeight = PANEL_HEIGHT / 3;
        this.paintSky(g, 0, oneThirdHeight);
        int twoThirdsHeight = 2 * oneThirdHeight;
        this.paintGround(g, oneThirdHeight, PANEL_HEIGHT);
        g.setColor(Color.BLACK);
        Font font = new Font(g.getFont().getFontName(), Font.PLAIN, 192);
        g.setFont(font);
        g.drawString("\u68EE", 50, PANEL_HEIGHT - 50);
    }
    
    private void showPanel() {
        frame = new JFrame("Test Image");
        frame.add(this);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Disposes of the frame containing this panel. It's probably a good idea to 
     * call this procedure in test tear down.
     */
    public void closePanel() {
        frame.dispose();
    }
    
    /**
     * Constructor. No arguments needed.
     */
    public TestImagePanel() {
        this.setBackground(BACKGROUND_COLOR);
        Dimension prefDim = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
        this.setPreferredSize(prefDim);
        showPanel();
    }
    
    public static void main(String[] args) {
        TestImagePanel panel = new TestImagePanel();
    }
    
}