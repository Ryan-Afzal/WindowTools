package ryanafzal.window;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class WindowSwitch extends WindowComponent {
	
	public BufferedImage image_off;
	public BufferedImage image_on;
	public boolean on;
	
	public WindowSwitch(String filename_off, String filename_on) {
		
		addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                on = !on;
            }
            
        });
		
		boolean isLoaded = loadImages(filename_off,filename_on);
		
		if (isLoaded) {
			image = image_off;
		}
	}
	
	public boolean loadImages(String filename_off, String filename_on) {
			try {
			    image_off = ImageIO.read(new File(filename_off));
			    image_on = ImageIO.read(new File(filename_on));
			    return true;
			} catch (IOException e) {
				return false;
			}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		if (on) {
			g.drawImage(image_on,getX(),getY(),null);
		} else {
			g.drawImage(image_off,getX(),getY(),null);
		}
    }
	
}
