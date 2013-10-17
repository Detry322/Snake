package net.synergycraft.snake;

public class Direction {
	
	public static final Direction UP = new Direction(0,-1);
	public static final Direction DOWN = new Direction(0,1);
	public static final Direction LEFT = new Direction(-1,0);
	public static final Direction RIGHT = new Direction(1,0);
	private int xDirection, yDirection;
	
	public Direction(int x, int y) {
		xDirection = x;
		yDirection = y;
	}
	

	public boolean equals(Direction x) {
		
		if (xDirection == x.getXDirection() && yDirection == x.getYDirection())
			return true;
		return false;
	}
	
	public int getXDirection() {
		return xDirection;
	}
	
	public int getYDirection() {
		return yDirection;
	}
	

}
