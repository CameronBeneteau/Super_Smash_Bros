// Player class
//
//

public class Player {
	private int x, y, orgX, orgY, jumpCount;
	private double hp;
	private double vy, vd;
	private boolean jump;
	private int lives;

	public Player(int x, int y){
		this.x = x;
		this.y = y;
		orgX = x;
		orgY = y;
		hp = 100.0;
		jump = false;
		jumpCount = 0;
		vy = -11;
		lives = 3;
	}

	public void jump(){
		jump = true;
		vy += 0.15;
    	y += vy;
    	if (vy >= -2 ){
			jump = false;
			jumpCount += 1;
			vy = -11;
		}
	}

	public void moveLeft(){
		x -= 4;
	}

	public void moveRight(){
		x += 4;
	}

	public void fall(){
		y += 5;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public boolean getJump(){
		return jump;
	}
	
	public void maxJumpCount(){
		jumpCount = 2;
	}
	
	public void setJumpFalse(){
		jump = false;
		vy = -10;
	}

	public int getJumpCount(){
		return jumpCount;
	}

	public void resetJump(){
		jumpCount = 0;
	}

	public void takeDamage(){
		hp -= 0.5;
	}
	public void stop(){
		vy = 0;
	}
	public int getHp(){
		return (int) hp;
	}
	
	public int getLives(){
		return lives;
	}
	
	public void loseLife(){
		lives--;
	}
	
	public void reset(){
		hp = 100;
		x =  orgX;
		y =  orgY;
	}
	
	public void kill(){
		hp = 0;
	}

	public void resetAll(){
		x = orgX;
		y = orgY;
		hp = 100;
		lives = 3;
	}
}