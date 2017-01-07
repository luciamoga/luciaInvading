

public class Player extends Actor {
	protected String imageFile = "src/ufo_PNG14397.png";
	protected String shootingSoundFile = "src/scifi002.wav";
	private String name;
	private int step = 10;

	/**
	 * 
	 * @param name
	 *            name of the player - shown beneath the avatar
	 */
	public Player(String name) {
		this.name = name;
		super.setImage(imageFile);
		super.setStep(step);
		super.setShootingSoundFile(shootingSoundFile);
	}

	/**
	 * 
	 * @param name
	 *            name of the player - shown beneath the avatar
	 * @param x
	 *            x coordinate of the avatar
	 * @param y
	 *            y coordinate of the avatar
	 */
	public Player(String name, int x, int y) {
		this(name);
		super.setX(x);
		super.setY(y);
	}

	/**
	 * Does the generic action(s) (eg: play sound) for the shooting and then
	 * some specific things to the player
	 */
	public void shoot() {
		super.shoot();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
