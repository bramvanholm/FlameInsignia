package gui;

//Temp storage of imports; divide/remove this later

import java.awt.*;
import java.awt.GridLayout;
import java.awt.Dimension;

import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JList;
import javax.swing.JRadioButton;

import game.Unit;
import game.Ally;
import game.Enemy;



public class GameGUI extends JFrame {

	//BL: Interesting Classes: JLayered, JTextPane




	JPanel gridPanel = new JPanel();


	JPanel infoPanel = new JPanel();
	JPanel turnPanel = new JPanel();
	JPanel statPanel = new JPanel();

	String f = "F";
	//BL: Search random selection of array
	private static void addButtons(Container contentPane,
			String ... strings) {
		for (String label : strings) {
			contentPane.add(new JButton(label));
		}
	}

	private static void addLabels(Container contentPane, String ... labels) {
		for(String label : labels) {
			contentPane.add(new JLabel(label));
		}
	}

	GameGUI(String difficulty, String princeStat) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Flame Insignia: Battle");

		Enemy boss = new Enemy("Bandit Leader",30,75,8,7,0);
		Ally retainer = new Ally("Retainer", 22,75,8,5);
		Ally squire = new Ally("Squire", 22,75,7,6);
		Ally prince = new Ally("Prince",25,75,7,5);
		switch (princeStat) {
		case "HIT": prince.setHIT(15);
		break;
		case "ATK":prince.setATK(2);
		break;
		case "DEF":prince.setDEF(2);
		break;
		}

		statPanel.setLayout(new GridLayout(9,2));
		
		addLabels(statPanel,prince.getInfo(), prince.getStats());
		addLabels(statPanel,retainer.getInfo(), retainer.getStats());
		addLabels(statPanel,squire.getInfo(), squire.getStats());
		addLabels(statPanel,boss.getInfo(), boss.getStats());

		Enemy bandit1 = null;
		Enemy bandit2 = null;
		Enemy bandit3 = null;
		Enemy bandit4 = null;
		Enemy bandit5 = null;
		switch(difficulty) {
			case "Easy": bandit1 = new Enemy("Bandit 1",15,70,9,5);
				bandit2 = new Enemy("Bandit 2",15,70,9,5);
				bandit3 = new Enemy("Bandit 3",15,70,9,5);
				addLabels(statPanel,bandit1.getInfo(), bandit1.getStats());
				addLabels(statPanel,bandit2.getInfo(), bandit2.getStats());
				addLabels(statPanel,bandit3.getInfo(), bandit3.getStats());
				break;
				
			case "Standard": bandit1 = new Enemy("Bandit 1",15,70,9,5);
				bandit2 = new Enemy("Bandit 2",15,70,9,5);
				bandit3 = new Enemy("Bandit 3",15,70,9,5);
				bandit4 = new Enemy("Bandit 4",15,70,9,5);
				addLabels(statPanel,bandit1.getInfo(), bandit1.getStats());
				addLabels(statPanel,bandit2.getInfo(), bandit2.getStats());
				addLabels(statPanel,bandit3.getInfo(), bandit3.getStats());
				addLabels(statPanel,bandit4.getInfo(), bandit4.getStats());
				break;
			case "Hard": bandit1 = new Enemy("Bandit 1",15,70,9,5);
				bandit2 = new Enemy("Bandit 2",15,70,9,5);
				bandit3 = new Enemy("Bandit 3",15,70,9,5);
				bandit4 = new Enemy("Bandit 4",15,70,9,5);
				bandit5 = new Enemy("Bandit 5",15,70,9,5);
				addLabels(statPanel,bandit1.getInfo(), bandit1.getStats());
				addLabels(statPanel,bandit2.getInfo(), bandit2.getStats());
				addLabels(statPanel,bandit3.getInfo(), bandit3.getStats());
				addLabels(statPanel,bandit4.getInfo(), bandit4.getStats());
				addLabels(statPanel,bandit5.getInfo(), bandit5.getStats());
		}
		statPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		gridPanel.setLayout(new GridLayout(8,8));
		addButtons(gridPanel,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f);
		// Random selection from array, for loop for assigning buttons

		JLabel turnLabel = new JLabel("Turns left: " +10, JLabel.LEFT); // Adjust to actual turns left
		turnPanel.add(turnLabel);
		turnPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


		infoPanel.setLayout(new GridLayout(2,1));
		infoPanel.add(turnPanel);
		infoPanel.add(statPanel);

		setLayout(new BorderLayout());
		add(gridPanel, BorderLayout.CENTER);
		add(infoPanel, BorderLayout.EAST);


		setPreferredSize(new Dimension(1100,900));
		pack();
		setVisible(true);
	}

}
