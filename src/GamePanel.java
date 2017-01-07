import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import javax.swing.Timer;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * 
 * Main panel of the game. Contains all elements of the game including
 * background, players, enemies and bullets. Controls the painting and
 * repainting.
 */
public class GamePanel extends JPanel implements KeyListener {

	/**
	 * Background settings
	 */
	private static final String backgroundImage = "src/magellanic-clouds.png";
	private static final Color backgroundColor = Color.white;
	// When set on true, the background is a solid color, not an image
	private static final boolean solidColorBackground = true;

	private Player localPlayer;
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();

	/**
	 * 
	 * @param players
	 *            a list of players
	 * @param enemies
	 *            a list of enemies
	 */
	public GamePanel(ArrayList<Player> players, ArrayList<Enemy> enemies) {
		this();
		this.players = players;
		this.enemies = enemies;
	}

	/**
	 * Sets up the panel, adds a dummy player, generates a number of enemies and
	 * sets up the timed events
	 */
	public GamePanel() {
		addKeyListener(this);
		setVisible(true);
		setFocusable(true);
		requestFocus(true);
		requestFocusInWindow();

		// Create a player
		this.setLocalPlayer(new Player("Alex", 150, 380));

		// Generate 15 enemies
		generateEnemies(15);

		setTimerEvents();
	}

	/**
	 * Sets up actions that happen repeatedly during the game. This controls the
	 * enemy's respawning after becoming invisible due to going outside the
	 * view: it reappears at the same x position, but at the top of the screen.
	 * Each time an enemy is moved, the <b>repaint</b> function is called.
	 */
	private void setTimerEvents() {
		Timer timer = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Enemy enemy : enemies) {
					enemy.setY(enemy.getY() + enemy.getStep());
					if (enemy.getY() > getHeight()) {
						enemy.setY(0);
					}
				}

				repaint();

			}

		});
		timer.setRepeats(true);
		timer.setCoalesce(true);
		timer.start();
	}

	/**
	 * 
	 * @param n
	 *            number of enemies to generate<br>
	 *            Generates n enemies at random positions
	 */
	public void generateEnemies(int n) {
		Random rand = new Random();
		for (int i = 0; i <= n; i++) {
			int x = rand.nextInt(700);
			int y = rand.nextInt(400);
			Enemy enemy = new Enemy(x, y);
			enemies.add(enemy);
		}
	}

	public void addEnemy(Enemy enemy) {
		enemies.add(enemy);
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void paintEnemies(Graphics g) {
		for (Enemy enemy : enemies) {
			g.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);
		}
	}

	public void paintPlayers(Graphics g) {
		for (Player player : players) {
			g.drawImage(player.getImage(), player.getX(), player.getY(), this);
		}
	}

	public void paintBullets(Graphics g) {
		for (Bullet bullet : bullets) {
			g.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), this);
		}
	}

	public Player getLocalPlayer() {
		return localPlayer;
	}

	public void setLocalPlayer(Player localPlayer) {
		this.localPlayer = localPlayer;
		players.add(localPlayer);
	}

	/**
	 * Overwrites the paint function. It is called for the first render of the
	 * images and each time <b>repaint()</b> is used.<br>
	 * The background is set (either solid color or image according to the
	 * boolean solidColorBackground). Then the players, enemies and bullets are
	 * drawn and the local player's name is painted underneath its avatar.
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (solidColorBackground) {
			setBackground(backgroundColor);
		} else {
			try {
				BufferedImage background = ImageIO.read(new File(backgroundImage));
				g.drawImage(background, 0, 0, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//
		paintPlayers(g);
		paintEnemies(g);
		paintBullets(g);
		// g.drawImage(player.getImage(), playerPos, getHeight() -
		// player.getImage().getHeight() - 50, this);

		g.setColor(Color.WHITE);
		Font font = new Font("Courier", Font.BOLD, 15);
		g.setFont(font);
		g.drawString(localPlayer.getName(), localPlayer.getX(), localPlayer.getY() + 45);
	}

	@Override
	public void keyPressed(KeyEvent key) {
		int keyCode = key.getKeyCode();

		System.out.println(keyCode);
		switch (keyCode) {
		// case 38:
		// //UP
		// break;
		// case 40:
		// //DOWN
		// break;
		case 37:
			localPlayer.setX(localPlayer.getX() - localPlayer.getStep());
			break;
		case 39:
			localPlayer.setX(localPlayer.getX() + localPlayer.getStep());
			break;
		case 32:
			Bullet bullet = localPlayer.shoot();
			System.out.println(bullet.getX() + " " + bullet.getY());
			bullets.add(bullet);
			System.out.println(bullets.size());
			break;
		}
		repaint();

	}

	@Override
	public void keyReleased(KeyEvent key) {

	}

	@Override
	public void keyTyped(KeyEvent key) {

	}

}