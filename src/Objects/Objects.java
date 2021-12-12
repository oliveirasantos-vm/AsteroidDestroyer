package Objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import Main.Game;

public class Objects {
		
	protected double x;
	protected double y;
	protected int width;
	protected int height;
	protected BufferedImage sprite;
	
	public static Random rand = new Random();
		
	public Objects(double x, double y, int width, int height, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public BufferedImage getSprite() {
		return sprite;
	}

	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
	}
	
	public static boolean isCollidding (Objects e1, Objects e2) {
		Rectangle e1Mask = new Rectangle((int)e1.getX(), (int)e1.getY(), e1.getWidth(), e1.getHeight());
		Rectangle e2Mask = new Rectangle((int)e2.getX(), (int)e2.getY(), e2.getWidth(), e2.getHeight());
		return e1Mask.intersects(e2Mask);
	}
	
	public void tick () {};
	
	public void render (Graphics g) {
		g.drawImage(sprite, (int)this.getX(), (int)this.getY(), null);
	}
}
