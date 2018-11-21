package unitStats;

public abstract class Unit {
	//Defining unit variables
	//HP: Hit Points/Health; HIT: Hit%; ATK: Attack; DEF: Defence; EVA: Evasion/dodge; MOV: Movement range
	public int HP;
	private int HIT;
	private int ATK;
	private int DEF;
	public int EVA;
	private int MOV;

	//Checks terrain unit is standing on and temporarily raises stats
	public static void checkTerrain() {};
}
