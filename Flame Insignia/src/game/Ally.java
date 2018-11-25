package game;

public class Ally extends Unit {

	private int EXP;

	Ally(int hp, int hit, int atk, int def) {
		super(hp,hit,atk,def,5);
		this.EXP = 0;
	}
	

	// How to make(/initialize?) units? => UnitPlacer?

	//BL: Just a test
	public static void main(String[] args) {

		Ally prince = new Ally(25,80,11,8); 
		//BL: For prince: Insert/increase stats from choice startGUI
		Ally retainer = new Ally(20,75,10,7);
		Ally guard = new Ally(22, 75,11,6);
		
		retainer.checkTerrain("Forest");
		

		System.out.println(prince.getMOV()+" "+retainer.getEVA());
	}


}