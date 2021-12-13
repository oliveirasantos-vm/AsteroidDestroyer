package Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Main.Game;
import Objects.Player;

public class UI {
	
	public static BufferedImage lifes[] = {Game.lifesheet.getSprite(0,  0, 144, 48),
										   Game.lifesheet.getSprite(0, 48, 144, 48),
										   Game.lifesheet.getSprite(0, 96, 144, 48),
										   Game.lifesheet.getSprite(0,144, 144, 48),
										   Game.lifesheet.getSprite(0,192, 144, 48)};
	
	public void tick() {
		
	}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("Consolas", Font.BOLD, 24));
		g.drawString("Score: "+Game.score, 6, 24);
		
		for(int i = 0; i < (int)(Player.life); i++) {
			g.drawImage(lifes[Player.life], Game.WIDTH - 82, 6, 76, 24, null);
		}
	}
}
