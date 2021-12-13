package Objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Main.Game;

public class Explosion extends Objects{
	private int frames = 0;
	private int targetFrames = 3;
	private int maxAnimation = 2;
	private int curAnimation = 0;
	
	public BufferedImage[] explosionSprites = new BufferedImage[3];
	
	public Explosion(double x, double y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		// TODO Auto-generated constructor stub
		explosionSprites[0] = Game.enemysheet.getSprite(0, 0, 48, 48);
		explosionSprites[1] = Game.enemysheet.getSprite(48, 0, 48, 48);
		explosionSprites[2] = Game.enemysheet.getSprite(96, 0, 48, 48);
	}
	
	public void tick() {
		y--;
		frames++;
		if(frames == targetFrames) {
			frames = 0;
			curAnimation++;
			if(curAnimation > maxAnimation) {
				Game.objects.remove(this);
				return;
			}
		}
	}
	
	public void render (Graphics g) {
		g.drawImage(explosionSprites[curAnimation], (int)this.getX(), (int)this.getY(), null);
	}

}
