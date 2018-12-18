package game;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.lang.Math;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

import gui.GameGUI;
import gui.StartGUI;

public class Game {
	public Board board; // configuration of board and its tiles
	public Unit[][] state; // current configuration of characters
	public GameGUI myGui;
	public StartGUI myStartGUI;
	public int allyTurn;
	public int enemyTurn;
	public String[] gameParameters = new String[2];

	public void setGameParameters(String[] gameParam) {
		this.gameParameters = gameParam;
	}

	public Game(){
		this.board = new Board();
		setInitialState();
	}

	public void setInitialState() {

		// create initial setting
		// string can be retrieved from file
		// if no unit present on tile -> string will be empty
		// else, string will be respectively ally or enemy

		//initialising units with respective stats
		Boss boss = new Boss("Boss",25,75,9,6);
		Enemy bandit1 = new Enemy("Bandit 1",13,70,8,5);
		Enemy bandit2 = new Enemy("Bandit 2",13,70,8,5);
		Enemy bandit3 = new Enemy("Bandit 3",13,70,8,5);
		Enemy bandit4 = new Enemy("Bandit 4",13,70,8,5);

		Ally guard1 = new Ally("Retainer",22,75,6,6);
		Ally guard2 = new Ally("Guard 2",22,75,6,6);
		Prince prince = new Prince("Prince",25,75,7,5);


		int[][] allyCoord = {{0,2},{2,0}};
		int[] princeCoord = {1,1};
		int[][] enemyCoord = {{1,4},{4,2},{4,5},{6,4}};
		int[] bossCoord = {6,6};

		Unit[][] tempSetting = new Unit[8][8];


		//set units in place
		tempSetting[allyCoord[0][0]][allyCoord[0][1]]=guard1;
		tempSetting[allyCoord[1][0]][allyCoord[1][1]]=guard2;
		tempSetting[princeCoord[1]][princeCoord[1]]=prince;
		tempSetting[enemyCoord[0][0]][enemyCoord[0][1]]=bandit1;
		tempSetting[enemyCoord[1][0]][enemyCoord[1][1]]=bandit2;
		tempSetting[enemyCoord[2][0]][enemyCoord[2][1]]=bandit3;
		tempSetting[enemyCoord[3][0]][enemyCoord[3][1]]=bandit4;
		tempSetting[bossCoord[0]][bossCoord[1]]=boss;

		this.state= tempSetting;
	}

	public boolean isOccupied (int row_in, int col_in) {
		return !(this.state[row_in][col_in]==null);
	}

	public boolean validUnitMove(int row1, int col1, int row2, int col2) {
		int manhattanDistance = Math.abs(row1-row2) + Math.abs(col1-col2);
		if((!isOccupied(row2,col2))&&(manhattanDistance<=3)) {
			return true;
		} else {
			return false;
		}
	}

	public void moveUnit(int row1, int col1, int row2, int col2) {
		if(validUnitMove(row1,col1,row2,col2)){
			this.state[row2][col2] = this.state[row1][col1];
			this.state[row1][col1]=null;
			this.allyTurn+=1;
			this.enemyTurn+=1;
		} else {
			System.out.println("invalid move!");
		}
		updateGUI();
	}

	public void startGui(Game myGame) {
		this.myStartGUI = new StartGUI(myGame);
		
		for (int i=0; i<1;) {
			if(myGame.gameParameters[0]!= null) {
				i++;
			}
		}
		this.myGui=new GameGUI(myGame);
		this.myGui.initiate();	


	}

	// Method to set Enemy stats
	public static void setEnemyStats (int maxhp, int atk, Enemy ... enemies) {
		for (Enemy enemy : enemies) {
			enemy.setMaxHp(maxhp);
			enemy.setHp(maxhp);
			enemy.setAtk(atk);
		}
	}
	 public void setUnitStats(String[] gameParam, Boss boss, Prince prince, Enemy... enemies) {
			//Adjusting enemy stats according to the difficulty
			switch(gameParam[0]) {
			case "Easy":
				break;
			case "Standard": 
				setEnemyStats(18,9,enemies);
				setEnemyStats(30,10,boss);
				break;
			case "Hard":
				setEnemyStats(21,10,enemies);
				setEnemyStats(35,11,boss);
				break;
			}
			
			//Adjusting the prince's stats according to the choice made
			switch (gameParam[1]) {
			case "HIT":
				prince.setHit(90);
			break;
			case "ATK":
				prince.setAtk(9);
			break;
			case "DEF":
				prince.setDef(7);
			break;
			}
	 }

	public void updateGUI() {
		this.myGui.updateState();
		this.myGui.updateScenery();
		this.myGui.updateVisibility();
	}

	public void startGame() {

		//local variables
		boolean endPointReached=false;
		int deadAllies=0;
		this.allyTurn=0;
		this.enemyTurn=0;

		// here comes the actual game play
		while((endPointReached==false)&(deadAllies<3)) {

			//Ally turn

			//step phase
			this.allyTurn=0;
			while(this.allyTurn<3) {;}
			//attack phase
			//attackEnemies
			System.out.println("turn is over");
			//Enemy turn

			//step phase
			//enemyPathFinder(state);
			//attack phase
			//attackAllies

		}
		System.out.println("Game Over");
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game myGame = new Game();

		myGame.startGui(myGame);
		//myGame.setUnitStats(myGame.gameParameters, boss, prince, bandit1,bandit2,bandit3,bandit4);
		myGame.startGame();
		

	}
}

