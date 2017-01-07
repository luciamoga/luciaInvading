public class Enemy extends Actor {
	protected String imageFile = "src/meteorite.png";
	protected String shootingSoundFile = "src/scifi002.wav";
	private int step = 5;
	public Enemy() {
		super.setImage(imageFile);
		super.setStep(step);
		super.setShootingSoundFile(shootingSoundFile);
	}

	public Enemy (int x, int y){
		this();
		super.setX(x);
		super.setY(y);
	}
	/**
	 * Does the generic action(s) (eg: play sound) for the shooting and then some specific things to the player
	 */
	public void shoot() {
		super.shoot();
	}
}
