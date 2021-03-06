package game;

public class Tile {
	
	private String type;
	private int xCoordinate;
	private int yCoordinate;
	public boolean focus;
	
	
	public Tile(String type_in, int x_in, int y_in) {
		setType(type_in);
		setCoordinates(x_in,y_in);
		this.focus=false;
	}
	
	public void setType(String t) {
		this.type=t;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setCoordinates(int x, int y) {
		this.xCoordinate=x;
		this.yCoordinate=y;
	}
	
	public int[] getCoordinates() {
		int[] coordinates = {this.xCoordinate,this.yCoordinate};
		return coordinates;
	}
}
