package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import Graphics.ImageSheet;
import Graphics.UI;
import Objects.Objects;
import Objects.Player;

public class Game extends Canvas implements Runnable, KeyListener, MouseListener, MouseMotionListener {
	
	public static JFrame frame;
	private Thread thread;
	private boolean isRunning = true;
	public static final int WIDTH = 480;
	public static final int HEIGHT = 720;
	
	public static BufferedImage image;
	
	public static ImageSheet playersheet;
	public static ImageSheet enemysheet;
	public static ImageSheet lifesheet;
	
	public static List<Objects> objects;
	
	public static Player player;
	public static EnemySpawn enemyspawn;
	
	private BufferedImage gameBackground;
	private BufferedImage gameBackground2;
	
	public int backy[] = {0, 720};
	public int backySpeed = 4;
	
	public static UI ui;
	
	public static int score = 0;
	
	
	public Game() {
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		initFrame();
		
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		
		objects = new ArrayList<Objects>();
		
		playersheet = new ImageSheet("/playersheet.png");
		player = new Player((Game.WIDTH/2)-24,Game.HEIGHT-64,0,0, Player.player);
		
		enemysheet = new ImageSheet("/enemysheet.png");
		lifesheet = new ImageSheet("/lifesheet.png");
		
		objects.add(player);
		
		enemyspawn = new EnemySpawn();
		
		ui = new UI();
		
		try {
			gameBackground = ImageIO.read(getClass().getResource("/background.jpg"));
			gameBackground2 = ImageIO.read(getClass().getResource("/background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void initFrame() {
		frame = new JFrame("Asteroid Destroyer");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public synchronized void Start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	
	public synchronized void Stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String arg[]) {
		Game game = new Game();
		game.Start();
	}
	
	public void tick() {
		for(int i = 0; i < objects.size(); i++) {
			Objects e = objects.get(i);
			e.tick();
		}
		enemyspawn.tick();
		
		backy[0]-=backySpeed;
		
		if(backy[0] + 720 <= 0) {
			backy[0] = 720;
		}
		
		backy[1]-=backySpeed;
		if(backy[1] + 720 <= 0) {
			backy[1] = 720;
		}
		
		ui.tick();
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		requestFocus();
		
		Graphics g = image.getGraphics();
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, (Game.WIDTH),(Game.HEIGHT));
		
		g.drawImage(gameBackground, 0, backy[0], null);
		g.drawImage(gameBackground2, 0, backy[1], null);
		
		for(int i = 0; i < objects.size(); i++) {
			Objects e = objects.get(i);
			e.render(g);
		}
		
		ui.render(g);
		
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, WIDTH, HEIGHT,null);
		bs.show();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long lastTime = System.nanoTime();
		double amountoOfTicks = 60.0;
		double ns = 1000000000 / amountoOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			if(delta >= 1) {
				tick();
				render();
				frames++;
				delta--;
			}
			if(System.currentTimeMillis() - timer >= 1000) {
				System.out.println("FPS: "+frames);
				frames = 0;
				timer += 1000;
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D)
			player.right = true;
		if(e.getKeyCode() == KeyEvent.VK_A)
			player.left = true;
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
			player.shoting = true;
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D)
			player.right = false;
		if(e.getKeyCode() == KeyEvent.VK_A)
			player.left = false;
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
			player.shoting = false;
	}

}
