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
	
	String f = "F";
	//BL: Search random selection of array
	private static void addButtons(Container contentPane,
			String ... strings) {
		for (String label : strings) {
			contentPane.add(new JButton(label));
		}
	}
	
	private static void addInfo(Container contentPane, Font font, Unit ... units) {
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

	// BL: make method to set/raise stats
	private static void setEnemyStats (int maxhp, int atk, Enemy ... enemies) {
		for (Enemy enemy : enemies) {
			enemy.setMAXHP(maxhp);
			enemy.setHP(maxhp);
			enemy.setATK(atk);
		}
	}
	
	
	GameGUI(String difficulty, String princeStat) {

		Enemy boss = new Enemy("Bandit Leader",25,75,9,6,0);
		Enemy bandit1 = new Enemy("Bandit 1",13,70,8,5);
		Enemy bandit2 = new Enemy("Bandit 2",13,70,8,5);
		Enemy bandit3 = new Enemy("Bandit 3",13,70,8,5);
		Enemy bandit4 = new Enemy("Bandit 4",13,70,8,5);
		
		Ally guard1 = new Ally("Guard 1", 22,75,6,6);
		Ally guard2 = new Ally("Guard 2", 22,75,6,6);
		Ally prince = new Ally("Prince",25,75,7,5);

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
		
		switch (princeStat) {
		case "HIT": prince.setHIT(15);
		break;
		case "ATK":prince.setATK(2);
		break;
		case "DEF":prince.setDEF(2);
		break;
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Flame Insignia: Battle");

		statPanel.setLayout(new GridLayout(16,2));
		addInfo(statPanel, font, prince, guard1, guard2, boss, bandit1, bandit2, bandit3, bandit4);
		
		
		gridPanel.setLayout(new GridLayout(8,8));
		addButtons(gridPanel,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f);
		// Random selection from array, for loop for assigning buttons

		
		JLabel turnLabel = new JLabel("Turns left: " +10); //BL: Adjust to actual turns left
		turnLabel.setFont(font);
		turnPanel.add(turnLabel);
		turnPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		infoPanel.setLayout(new BorderLayout());
		infoPanel.add(turnPanel, BorderLayout.NORTH);
		infoPanel.add(statPanel, BorderLayout.CENTER);

		setLayout(new BorderLayout());
		add(gridPanel, BorderLayout.CENTER);
		add(infoPanel, BorderLayout.EAST);


		setPreferredSize(new Dimension(1100,900));
		pack();
		setVisible(true);
	}

}