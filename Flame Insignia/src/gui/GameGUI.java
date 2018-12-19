package gui;

import game.Ally;
import game.Boss;
import game.Enemy;
import game.Game;
import game.HighScoreCalculator;
import game.Prince;
import game.Unit;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ToolTipUI;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import java.text.DecimalFormat;

public class GameGUI extends JFrame implements ActionListener{

	//variables
	Game currentGame;
	int[] indexLastPressed;

	//components grid panel
	JButton[][] tileButton = new JButton[8][8];

	//panel
	ImagePanel gridPanel = new ImagePanel("src/pictures/terrainImage.png");
	JPanel infoPanel = new JPanel();
	JPanel statPanel = new JPanel();
	static Font font = new Font("Calibri",Font.PLAIN, 16);

	//creation of GUI
	public GameGUI(Game game_in){
		super("Flame Insignia: Battle");

		// link game
		this.currentGame=game_in;
		/*	
		Boss boss = new Boss("Boss",25,75,9,6);
		Enemy bandit1 = new Enemy("Bandit 1",13,70,8,5);
		Enemy bandit2 = new Enemy("Bandit 2",13,70,8,5);
		Enemy bandit3 = new Enemy("Bandit 3",13,70,8,5);
		Enemy bandit4 = new Enemy("Bandit 4",13,70,8,5);

		Ally guard1 = new Ally("Retainer",22,75,6,6);
		Ally guard2 = new Ally("Guard",22,75,6,6);
		Prince prince = new Prince("Prince",25,75,7,5);


		// Setting Layout of the panel with status information
		infoPanel.setLayout(new GridLayout(13,1));
		addInfo(infoPanel, font, 10, prince, guard1, guard2, boss, bandit1, bandit2, bandit3, bandit4);
		 */ 
		// setup gridPanel
		gridPanelSetup();

		//format JFrame
		setLayout(new BorderLayout());
		add(infoPanel, BorderLayout.EAST);
		add(gridPanel, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1100,900));
		pack();
		setVisible(true);

	}

	// Method to generate the information on the infoPanel:
	// Amount of turns left; Name + Health, Health bar, stats of a Unit.
	private static void addInfo(Container contentPane, Font font, int turns, Unit ... units) {
		JLabel turn = new JLabel("Turns left: " +turns); //BL: Adjust to actual turns left
		turn.setFont(font);
		turn.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		contentPane.add(turn);

		for(Unit unit : units) {
			JPanel panel = new JPanel();
			JLabel info = new JLabel(unit.getInfo());
			JLabel stats = new JLabel(unit.getStats());
			JProgressBar progressBar = new JProgressBar(0,unit.getMaxHp());

			info.setFont(font);
			stats.setFont(font);
			progressBar.setValue(unit.getHp());

			panel.setLayout(new GridLayout(2,1));
			panel.add(info);
			panel.add(progressBar);
			panel.add(stats);
			panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			contentPane.add(panel);
		}
	}

	public void gridPanelSetup() {
		//create button group
		ButtonGroup group = new ButtonGroup();

		//create buttons+contours
		for(int r=0;r<8;r++){
			for(int c=0;c<8;c++) {
				if(this.currentGame.board.getTileType(r, c).equals("forest")) {
					tileButton[r][c] = new MyButton("green");
					tileButton[r][c].setToolTipText("Here is a forest: +X% evasion");
					tileButton[r][c].addActionListener(this);
					tileButton[r][c].setContentAreaFilled(false);
				} else if(this.currentGame.board.getTileType(r, c).equals("tent")) {
					tileButton[r][c] = new MyButton("red");
					tileButton[r][c].setToolTipText("Here is a tent: +X% evasion");
					tileButton[r][c].addActionListener(this);
					tileButton[r][c].setContentAreaFilled(false);
				} else {
					tileButton[r][c] = new MyButton("gray");
					tileButton[r][c].addActionListener(this);
					tileButton[r][c].setContentAreaFilled(false);
				}

				group.add(tileButton[r][c]);
				gridPanel.add(tileButton[r][c]);
			}
		}

		//add unit elements (we do this by updating the playfield and visibility)
		updateState();
		updateVisibility();

		//format panel
		gridPanel.setLayout(new GridLayout(8,8));
	}
	// Showing the GameOver Dialog
	public void showGameOver(String gameOverReason) {
		JDialog gameOverDialog= new JDialog();
		JPanel textPanel = new JPanel();
		JPanel scorePanel = new JPanel();

		JLabel label = new JLabel();
		JLabel yourScore = new JLabel();
		JButton closeButton = new JButton("Exit Game");

		gameOverDialog.setTitle("Flame Insignia: Epilogue");
		gameOverDialog.setLayout(new BorderLayout());
		//If the game ended because the prince died:
		if (gameOverReason.equals("Prince died")){
			String gameOverText = "<html>You were killed ...<br>"
					+ "With your death, your retainers lost their will to fight and they died at the hand of the bandits as well. <br>"
					+ "The bandits massacred everyone else that was left in the camp and ran away with the envoy.<br>"
					+ "After a week, a travelling merchant discovered the mutilated body of the envoy in a ditch by the road.<br>"
					+ "A war that would last longer than any war previously, erupted between the two countries ...<html/>";	
			label = new JLabel(gameOverText);

			label.setFont(font);
			closeButton.setFont(font);

			gameOverDialog.setLayout(new BorderLayout());
			gameOverDialog.add(label, BorderLayout.CENTER);
			gameOverDialog.add(closeButton, BorderLayout.SOUTH);
		}else if(gameOverReason.equals("Out of Turns")) {
			String gameOverText = "<html> You were too late...<br>"
					+ "The bandits escaped with the envoy. No one was able to pursue them due to their wounds.<br>"
					+ "The next day, a search party combed the area, but to no avail. <br>"
					+ "After a week, a travelling merchant discovered the mutilated body of the envoy in a ditch by the road.<br>"
					+ "A war that would last longer than any war previously, erupted between the two countries ...<html/>";
			label = new JLabel(gameOverText);

			label.setFont(font);
			closeButton.setFont(font);

			gameOverDialog.setLayout(new BorderLayout());
			gameOverDialog.add(label, BorderLayout.CENTER);
			gameOverDialog.add(closeButton, BorderLayout.SOUTH);
			//If the game ended because the the player won:
		}else{
			int highScore = HighScoreCalculator.calculateHighScore(3,4,"Standard");//BL: Change this
			HighScoreCalculator.addHighScore(highScore);
			ArrayList<Integer> bestScores = HighScoreCalculator.getHighScore();

			String gameOverText = "<html>You succeeded in rescuing the Envoy!<br>"
					+"You let out a sigh of relief, knowing that the peace between the two countries is not in danger.<br>"
					+ "For now at least.</html>";
			label  = new JLabel(gameOverText);
			yourScore = new JLabel("Your score : "+highScore);

			label.setFont(font);
			yourScore.setFont(font);
			closeButton.setFont(font);
			textPanel.setLayout(new BorderLayout());
			textPanel.add(label, BorderLayout.CENTER);
			textPanel.add(yourScore, BorderLayout.SOUTH);

			scorePanel.setLayout(new GridLayout(5,2));
			for (int i = 0; i<bestScores.size(); i++) {
				JLabel score = new JLabel(" "+(i+1)+": "+bestScores.get(i));
				score.setFont(font);
				scorePanel.add(score);
			}

			gameOverDialog.add(textPanel, BorderLayout.NORTH);
			gameOverDialog.add(scorePanel, BorderLayout.CENTER);
			gameOverDialog.add(closeButton, BorderLayout.SOUTH);
		}

		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event){
				System.exit(0);
			}
		});

		gameOverDialog.setPreferredSize(new Dimension(400,500));
		gameOverDialog.pack();
		gameOverDialog.setVisible(true);	
	}

	public void updateScenery() {
		for(int r=0;r<8;r++){
			for(int c=0;c<8;c++) {
				if(this.currentGame.board.getTileType(r, c).equals("forest")) {
					tileButton[r][c].setToolTipText("Here is a forest: +X% evasion");
					tileButton[r][c].setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
					tileButton[r][c].setContentAreaFilled(false);
				} else if(this.currentGame.board.getTileType(r, c).equals("tent")) {
					tileButton[r][c].setToolTipText("Here is a tent: +X% evasion");
					tileButton[r][c].setBorder(BorderFactory.createLineBorder(Color.RED,2));
					tileButton[r][c].setContentAreaFilled(false);
				} else {
					tileButton[r][c].setContentAreaFilled(false);
					if(((MyButton) tileButton[r][c]).getFocus()==true) {
						tileButton[r][c].setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
					} else {
						tileButton[r][c].setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
					}
				}
			}
		}
	}

	public void updateState() {
		//method to display current state of game
		for(int r=0;r<8;r++) {
			for(int c=0;c<8;c++) {
				if(currentGame.state[r][c] instanceof Ally) {
					//paste "stretchy" image of ally
					tileButton[r][c].setIcon(new StretchIcon("src/pictures/allyImage.png"));
				} else if (currentGame.state[r][c] instanceof Enemy) {
					//paste "stretchy" image of enemy
					tileButton[r][c].setIcon(new StretchIcon("src/pictures/enemyImage.png"));
				} else if (currentGame.state[r][c] instanceof Prince) {
					//paste "stretchy" image of enemy
					tileButton[r][c].setIcon(new StretchIcon("src/pictures/princeImage.png"));
				} else if (currentGame.state[r][c] instanceof Boss) {
					//paste "stretchy" image of enemy
					tileButton[r][c].setIcon(new StretchIcon("src/pictures/bossImage.png"));
				} else {
					//remove any present icon
					tileButton[r][c].setIcon(null);
				}
			}
		}
	}

	public void updateVisibility() {
		//visibility is only in manhattaDistance of 3 from player
		String coorBlack = returnIndexesBlack(3); 

		for(int r=0;r<8;r++) {
			for(int c=0;c<8;c++) {
				if(!coorBlack.contains(r+","+c)){
					tileButton[r][c].setContentAreaFilled(true);
					tileButton[r][c].setIcon(null);
					tileButton[r][c].setToolTipText(null);
					tileButton[r][c].setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
					tileButton[r][c].setBackground(Color.BLACK);
				}
			}
		}
	}

	public String returnIndexesBlack(int range) {
		String returnString = "";		

		for(int r=0;r<8;r++) {
			for(int c=0;c<8;c++) {
				if(((currentGame.state[r][c] instanceof Ally)||(currentGame.state[r][c] instanceof Prince))){
					//only tiles in Manhattan distance<=3 and tile itself are included
					for(int r1=(r-range);r1<(r+range+1);r1++) {
						for(int c1=c-range+Math.abs(r1-r);c1<(c+range-Math.abs(r1-r))+1;c1++) {
							returnString=returnString+r1+","+c1+" ";
						}
					}
				}
			}
		}
		return returnString;
	}

	public String returnIndexesBlue(int[] point, int range) {
		String returnString = "";		
		int col=point[1];
		int row=point[0];

		for(int r=0;r<8;r++) {
			for(int c=0;c<8;c++) {
				if((Math.abs(r-row)+Math.abs(c-col)<=2&&(currentGame.state[r][c]==null))){
					returnString=returnString+r+","+c+" ";
				}
			}
		}
		if(currentGame.state[row][col]==null) {
			returnString=returnString+row+","+col+" ";
		}

		return returnString;
	}

	public void initiate() {

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int[] pressedButton=new int[2];

		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(e.getSource()==tileButton[i][j]) {
					//find correct pressed button
					pressedButton= new int[] {i,j};
					//movement
					if(((MyButton) tileButton[i][j]).getFocus()==true) {
						this.currentGame.moveUnit(indexLastPressed[0], indexLastPressed[1], i, j);
					}
				}
				//clear focus
				((MyButton) tileButton[i][j]).focusOff();
			}
		}

		//update last pressed button
		indexLastPressed=pressedButton;

		if(!(currentGame.state[pressedButton[0]][pressedButton[1]] instanceof Ally)&&!(currentGame.state[pressedButton[0]][pressedButton[1]] instanceof Prince)) {
			System.out.println("invalid choice");
		}else {
			updateOptions(pressedButton);
		}
		updateScenery();
		updateState();
		updateVisibility();
	}

	public void updateOptions(int[] coorIn) {
		String coorBlue = returnIndexesBlue(coorIn,2); 

		for(int r=0;r<8;r++) {
			for(int c=0;c<8;c++) {
				if(coorBlue.contains(r+","+c)){
					//update focus
					((MyButton) tileButton[r][c]).focusOn();
				}
			}
		}
	}

}