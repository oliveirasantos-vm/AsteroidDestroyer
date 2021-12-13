package Objects;

import java.awt.image.BufferedImage;

import Main.Game;

public class Player extends Objects	 {
	
	public static BufferedImage players[] = {Game.spritesheet.getSprite(0, 0, 48, 48),
											 Game.spritesheet.getSprite(48, 0, 48, 48),
											 Game.spritesheet.getSprite(96, 0, 48, 48),
											 Game.spritesheet.getSprite(0, 48, 48, 48),
											 Game.spritesheet.getSprite(48, 48, 48, 48),
											 Game.spritesheet.getSprite(96, 48, 48, 48),
											 Game.spritesheet.getSprite(0, 96, 48, 48),
											 Game.spritesheet.getSprite(48, 96, 48, 48),
											 Game.spritesheet.getSprite(96, 96, 48, 48)};
	
	public static boolean right, left;
	public double speed = 4.8;
	public static boolean shoting = false;
	
	public static int life = 4;
	
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

}
