package ryanafzal.window;

import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class WindowComponent extends JComponent {
	
	BufferedImage image;
	
	public WindowComponent(String filename) {
		super();
		loadImage(filename);
		addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
			     click();
			  }
			});
	}
	
	public WindowComponent() {
		super();
		image = null;
	}
	
	public void loadImage(String filename) {
		image = null;
		try {
		    image = ImageIO.read(new File(filename));
		} catch (IOException e) {
			System.out.println("WindowComponent " + getName() + " failed to load image!");
		}
	}
	
	public void click() {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        g.drawImage(image,getX(),getY(),null);
    }

}
