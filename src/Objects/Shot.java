package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Main.Game;

public class Shot extends Objects{
	
	public double speed = 9;

	public Shot(double x, double y, int widht, int height, BufferedImage sprite) {
		super(x, y, widht, height, sprite);
		// TODO Auto-generated constructor stub
	}
	
	
	public void tick() {
		y -= speed;
		if(y < 0) {
			Game.objects.remove(this);
			return;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval((int)this.getX(), (int)this.getY(), 8, 8);
	}
	
}
