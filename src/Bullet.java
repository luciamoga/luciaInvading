
public class Bullet extends Actor {
	
	private boolean enemyBullet;
	protected String imageFile;
	public Bullet(int x, int y, boolean enemyBullet) {
		super.setX(x);
		super.setY(y);
		this.enemyBullet = enemyBullet;
		if (enemyBullet){
			imageFile = "src/enemyBullet.png";
		}else{
			imageFile = "src/friendlyBullet.png";
		}
	}
	public boolean isEnemyBullet() {
		return enemyBullet;
	}
	public void setEnemyBullet(boolean enemyBullet) {
		this.enemyBullet = enemyBullet;
	}
	
}
