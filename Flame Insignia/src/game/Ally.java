package game;

public class Ally extends Unit {

	private int EXP;

	public Ally(String name, int maxhp, int hit, int atk, int def) {
		super(name,maxhp,hit,atk,def,5);
		this.EXP = 0;
	}


	// How to make(/initialize?) units? => UnitPlacer?

	//BL: Just a test
	public static void main(String[] args) {

		Ally prince = new Ally("Prince",25,80,11,8); 
		//BL: For prince: Insert/increase stats from choice startGUI
		Ally retainer = new Ally("Retainer",20,75,10,7);
		Ally guard = new Ally("Guard",22, 75,11,6);

		retainer.checkTerrain("Forest");


		System.out.println(prince.getMOV()+" "+retainer.getEVA());
	}

}