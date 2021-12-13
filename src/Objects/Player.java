package Objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Main.Game;

public class Player extends Objects	 {
	
	public static BufferedImage player = Game.playersheet.getSprite(0, 0, 48, 48);
	
	public static BufferedImage playerA[] = {Game.playersheet.getSprite(0, 0, 48, 48),
											 Game.playersheet.getSprite(48, 0, 48, 48),
											 Game.playersheet.getSprite(96, 0, 48, 48)};
		
	public static boolean right, left;
	public double speed = 4.8;
	public static boolean shoting = false;
	
	public static int life = 4;
	
	public int framesAnimation = 0;
	public int maxFrames = 12;
	public int maxSprites = 3;
	public int curSprite = 0;
	
	public Player(double x, double y, int widht, int height, BufferedImage sprite) {
		super(x, y, widht, height, sprite);
	}
	
	public void tick() {
		if(right)
			x+=speed;
		if(left)
			x-=speed;
		
		if(x >= Game.WIDTH - 48)
			x = Game.WIDTH - 48;
		else if(x <= 0)
			x = 0;
		
		if(shoting) {
			shoting = false;
			int xx = (int)this.getX()+20;
			int yy = (int)this.getY();
			Shot shot = new Shot(xx, yy, 8, 8, null);
			Game.objects.add(shot);
		}
	}
	
	public void render (Graphics g) {
		framesAnimation++;
		if(framesAnimation == maxFrames) {
			curSprite++;
			framesAnimation = 0;
			if(curSprite == maxSprites) {
				curSprite = 0;
			}
		}
		g.drawImage(playerA[curSprite], (int)this.getX(), (int)this.getY(), null);
	}

}
