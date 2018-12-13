package gui;

//Temp storage of imports; divide/remove this later

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import game.Unit;
import game.Ally;
import game.Enemy;



public class GameGUI extends JFrame {

	JPanel gridPanel = new JPanel();
	JPanel infoPanel = new JPanel();
	JPanel turnPanel = new JPanel();
	JPanel statPanel = new JPanel();
	Font font = new Font("Calibri",Font.PLAIN, 16);
	
	//BL: Replace by Lars' version
	String f = "F";
	private static void addButtons(Container contentPane,
			String ... strings) {
		for (String label : strings) {
			contentPane.add(new JButton(label));
		}
	}
	// Method to generate the information on the infoPanel:
	// Amount of turns left; Name + Health, Health bar, stats of a Unit.
	private static void addInfo(Container contentPane, Font font, Unit ... units) {
		JLabel turn = new JLabel("Turns left: " +10); //BL: Adjust to actual turns left
		turn.setFont(font);
		turn.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		contentPane.add(turn);
		
		for(Unit unit : units) {
			JPanel panel = new JPanel();
			JLabel info = new JLabel(unit.getInfo());
			JLabel stats = new JLabel(unit.getStats());
			JProgressBar progressBar = new JProgressBar(0,unit.getMAXHP());

			info.setFont(font);
			stats.setFont(font);
			progressBar.setValue(unit.getHP());

			panel.setLayout(new GridLayout(2,1));
			panel.add(info);
			panel.add(progressBar);
			panel.add(stats);
			panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			contentPane.add(panel);
		}
	}

	// Method to set Enemy stats
	private static void setEnemyStats (int maxhp, int atk, Enemy ... enemies) {
		for (Enemy enemy : enemies) {
			enemy.setMAXHP(maxhp);
			enemy.setHP(maxhp);
			enemy.setATK(atk);
		}
	}
	
	
	GameGUI(String difficulty, String princeStat) {
		//Initialising Enemy and Ally Units
		Enemy boss = new Enemy("Bandit Leader",25,75,9,6,0);
		Enemy bandit1 = new Enemy("Bandit 1",13,70,8,5);
		Enemy bandit2 = new Enemy("Bandit 2",13,70,8,5);
		Enemy bandit3 = new Enemy("Bandit 3",13,70,8,5);
		Enemy bandit4 = new Enemy("Bandit 4",13,70,8,5);
		
		Ally guard1 = new Ally("Guard 1",22,75,6,6);
		Ally guard2 = new Ally("Guard 2",22,75,6,6);
		Ally prince = new Ally("Prince",25,75,7,5);

		//Adjusting enemy stats according to the difficulty
		switch(difficulty) {
		case "Easy":
			break;
		case "Standard": 
			setEnemyStats(18,1, bandit1, bandit2, bandit3, bandit4);
			setEnemyStats(30,1,boss);
			break;
		case "Hard":
			setEnemyStats(21,2,bandit1, bandit2, bandit3, bandit4);
			setEnemyStats(35,2,boss);
			break;
		}
		
		//Adjusting the prince's stats according to the choice made
		switch (princeStat) {
		case "HIT":
			prince.setHIT(15);
		break;
		case "ATK":
			prince.setATK(2);
		break;
		case "DEF":
			prince.setDEF(2);
		break;
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Flame Insignia: Battle");

		// Setting Layout of the panel with status information
		infoPanel.setLayout(new GridLayout(13,1));
		addInfo(infoPanel, font, prince, guard1, guard2, boss, bandit1, bandit2, bandit3, bandit4);
		
		// Setting Layout of the game grid
		//BL: Replace by Lars' version
		gridPanel.setLayout(new GridLayout(8,8));
		addButtons(gridPanel,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f);
		

		//Setting Layout of the JFrame
		setLayout(new BorderLayout());
		add(gridPanel, BorderLayout.CENTER);
		add(infoPanel, BorderLayout.EAST);

		setPreferredSize(new Dimension(1100,900));
		pack();
		setVisible(true);
	}

}