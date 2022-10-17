package game;

public class Paddle {

	
	public static final int startXp1 = 50;
	public static final int startY = 150;
	public static final int startXp2 = 750;
	public static final int speed = 10;
	private static final int WIDTH = 10;
	private static final int HEIGHT = 30;
	private int x;
	private int y;
	private int width;
	private int height;
	
	
	public Paddle(int x, int y, int width, int height, PaddleController controller) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	
	
	public void setXPosition(int x){
	
		this.x = x;
		
	}
	
	public void setYPosition(int y){
	
		this.y = y;
		
	}
	
	public int getXPosition(){
		
		return x;
		
	}
	
	public int getYPosition(){
		
		return y;
		
	}
	
	
	
	public void move(){
	
		
	}
	
	public void hit(){
		
	}
	
	
	
	
	
	
	


	 
}
