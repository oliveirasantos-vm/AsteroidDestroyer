package Objects;

import java.awt.image.BufferedImage;

import Main.Game;

public class Enemy extends Objects{

	public double speed = Objects.rand.nextInt(9-3)+1;
	
	public int life = 3;
	
	public Enemy(double x, double y, int widht, int height, BufferedImage sprite) {
		super(x, y, widht, height, sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void tick() {
		y+=speed;
		if(y >= Game.HEIGHT) {
			Game.objects.remove(this);
			Player.life -= 1;
			return;
		}
		for(int i = 0; i < Game.objects.size(); i++) {
			Objects e = Game.objects.get(i);
			
			if(e instanceof Shot) {
				if(Objects.isCollidding(this, e)) {
					
					life--;
					Game.objects.remove(e);
					if(life == 0) {
						Game.score += 100;
						Game.objects.remove(this);
					}
				}
			}
		}
	}

}
