package Graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageSheet {
	private BufferedImage imagesheet;
	
	public ImageSheet(String path) {
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
