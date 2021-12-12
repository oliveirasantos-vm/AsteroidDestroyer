package Main;

import Objects.Enemy;

public class EnemySpawn {
	public int targetTime = 60*2;
	public int curTime = 0;
	
	public void tick() {
		curTime++;
		if(curTime == targetTime) {
			curTime = 0;
			int yy = 0;
			int xx = Objects.Objects.rand.nextInt(Game.WIDTH-48);
			Enemy enemy = new Enemy (xx, yy, 48, 48, Game.enemysheet.getSprite(0, 0, 48, 48));
			Game.objects.add(enemy);
		}
	}
}
