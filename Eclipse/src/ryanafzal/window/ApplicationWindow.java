package ryanafzal.window;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

@SuppressWarnings("serial")
public class ApplicationWindow extends JFrame {
	
	public static boolean running = true;
	public BufferedImage icon;
	
	public ApplicationWindow(String name,String filename) {
		super(name);
		init_images(filename);
		init_close();
	}
	
	public void init_close() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				running = false;
			}
		});
	}
	
	public void init_images(String file) {
		try {
		    icon = ImageIO.read(new File(file));
		} catch (IOException e) {
			System.out.println("ApplicationWindow " + getName() + " failed to load image!");
		}
	}
	
}
