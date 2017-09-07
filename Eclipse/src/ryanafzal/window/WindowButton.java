package ryanafzal.window;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class WindowButton extends WindowComponent {
	
	BufferedImage image_static;
	BufferedImage image_hover;
	BufferedImage image_pressed;
	boolean mouse_hover;
	
	public WindowButton(String filename_static, String filename_hover, String filename_pressed) {
		
		addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                mouse_hover = true;
            }
            
            @Override
            public void mouseExited(MouseEvent me2) {
            	mouse_hover = false;
            }
            
        });
		
		boolean isLoaded = loadImages(filename_static, filename_hover, filename_pressed);
		
		if (isLoaded) {
			image = image_static;
		}
	}
	
	public boolean loadImages(String filename_static, String filename_hover, String filename_pressed) {
			try {
			    image_static = ImageIO.read(new File(filename_static));
			    image_hover = ImageIO.read(new File(filename_hover));
			    image_pressed = ImageIO.read(new File(filename_pressed));
			    return true;
			} catch (IOException e) {
				return false;
			}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		if (mouse_hover) {
			g.drawImage(image_hover,getX(),getY(),null);
		} else {
			g.drawImage(image_static,getX(),getY(),null);
		}
    }

}
