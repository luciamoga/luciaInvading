import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
/**
 * 
 * 
 * Abstract class used for implementing common functionalities between players and enemies
 */
public abstract class Actor {
	private String shootingSoundFile = "src/scifi002.wav";
	protected BufferedImage avatar;
	private int x = 100, y = 100, step = 10;
	
	
	public Actor() {
	}
	/**
	 * Plays the actor's shooting sound
	 */
	public void playShoothingSound() {
		try {
			AudioPlayer.player.start(new AudioStream(new FileInputStream(shootingSoundFile)));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BufferedImage getImage() {
		return avatar;
	}

	public void setImage(String avatarFile) {
		try {
			avatar = ImageIO.read(new File(avatarFile));
		} catch (Exception e) {
			System.out.println("Could not load avatar from " + avatarFile);
		}

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}
	public void setShootingSoundFile(String shootingSoundFile) {
		this.shootingSoundFile = shootingSoundFile;
		
	}
	public BufferedImage getAvatar() {
		return avatar;
	}
	public void setAvatar(BufferedImage avatar) {
		this.avatar = avatar;
	}
	
	

}
