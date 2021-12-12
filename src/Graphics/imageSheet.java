package Graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class imageSheet {
	private BufferedImage imagesheet;
	
	public imageSheet(String path) {
		try {
			imagesheet = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getSprite(int x, int y, int width, int height) {
		return imagesheet.getSubimage(x, y, width, height);
	}
}
