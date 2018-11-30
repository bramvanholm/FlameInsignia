package gui;

//Temp storage of imports; divide/remove this later
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import game.Unit;
import game.Ally;
import game.Enemy;


public class StartGUI extends JFrame{

	StartGUI(){

		//Flavor text
		String introText1 =  "<html>The relationship between your kingdom and its neighbor has always been strained:<br>"
				+"Over the centuries, many wars have been fought between the two countries, and even in times of relative peace, small-scale battles occur frequently.<br>"
				+"But a change is happening this winter: An envoy with royal blood was sent by the neighbouring kingdom to arrange talks for peace and tariffs,<br>"
				+"and as the Prince, you are tasked with escorting the envoy back to his homeland, as a sign of sincerity and goodwill.<br>"
				+"While engaging in idle conversation with the envoy, curiosity gets the better of him and he asks you how your life was, growing up as a Prince.<br>"
				+"Reluctantly, you respond with: 'My life was ...'</html>";

		String choiceText1 = "Easy. Aside from combat-training, I've had no difficulties growing up.";
		String choiceText2 = "Standard. I've fought in some battles and have gotten seriously injured a few times.";
		String choiceText3 = "Hard. I've been fighting on battlefields my whole life. I've forgotten the amount of times I nearly died.";

		String introText2 = "<html>The envoy persistently keeps asking question after question, and before losing your patience, you permit him to ask one last question.<br>"
				+"The envoy mutters in protest for a while, before asking his last question: 'What is the thing you pride yourself the most in?</html>";

		String choiceText4 = "My aim. I always succeed in hitting my opponent.";
		String choiceText5 = "My strength. I crush my opponents with overwhelming power.";
		String choiceText6 = "My armor. I shrug off my opponents attacks like my morning robe.";

		String introText3 = "<html>At nightfall your group sets up camp, and everyone, except for those on night duty, eventually goes to sleep in their respective tents.<br>"
				+"Suddenly you wake up to screams. You hear a guard yell: 'Bandits! The mountain bandits are attacking! They've taken the envoy!'<br>"
				+"You immediately realize the severity of the situation: If something were to happen to the envoy, it would mean war. And it would not end in your life time...<br>"
				+" You run outside, prepared for battle, and try to find allies willing to fight back and rescue the envoy...</html>";


		// Assigning text to labels
		Font font = new Font("Calibri",Font.PLAIN, 16);
		JLabel introLabel1 = new JLabel(introText1, JLabel.LEFT);
		JLabel introLabel2 = new JLabel(introText2, JLabel.LEFT);
		JLabel introLabel3 = new JLabel(introText3, JLabel.LEFT); //JTextPane/JTextArea?
		introLabel1.setFont(font);
		introLabel2.setFont(font);
		introLabel3.setFont(font);
		
		// Making the buttons
		JPanel choicePanel1 = new JPanel();
		JRadioButton choiceButton1 = new JRadioButton(choiceText1);
		JRadioButton choiceButton2 = new JRadioButton(choiceText2);
		JRadioButton choiceButton3 = new JRadioButton(choiceText3);
		JPanel choicePanel2 = new JPanel();
		JRadioButton choiceButton4 = new JRadioButton(choiceText4);
		JRadioButton choiceButton5 = new JRadioButton(choiceText5);
		JRadioButton choiceButton6 = new JRadioButton(choiceText6);
		choiceButton1.setFont(font);
		choiceButton2.setFont(font);
		choiceButton3.setFont(font);
		choiceButton4.setFont(font);
		choiceButton5.setFont(font);
		choiceButton6.setFont(font);
		
		JButton startButton =new JButton("Start Battle");
		startButton.setFont(new Font("Calibri",Font.BOLD, 18));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Flame Insignia: Prologue");

		//Setting the Layout of the buttons
		choicePanel1.setLayout(new GridLayout(3,1));
		choicePanel1.add(choiceButton1);
		choicePanel1.add(choiceButton2);
		choicePanel1.add(choiceButton3);
		ButtonGroup choiceGroup1 = new ButtonGroup();
		choiceGroup1.add(choiceButton1);
		choiceGroup1.add(choiceButton2);
		choiceGroup1.add(choiceButton3);

		choicePanel2.setLayout(new GridLayout(3,1));
		choicePanel2.add(choiceButton4);
		choicePanel2.add(choiceButton5);
		choicePanel2.add(choiceButton6);
		ButtonGroup choiceGroup2 = new ButtonGroup();
		choiceGroup2.add(choiceButton4);
		choiceGroup2.add(choiceButton5);
		choiceGroup2.add(choiceButton6);

		//adding actionListeners
		//BL: choiceButton1.addActionListener? or/and in the actionListener below?
		//setting actioListener for running GameGUI
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event){
				//BL: Initialize prince+ enemy units here?
				//BL: or return a value that is used in UnitPlacer/Initialization?
				
				// BL: This is not ideal and I don't know how to do the try statement/Exception
				
				//try {
				if(choiceButton1.isSelected()) {
					Enemy bandit1 = new Enemy("Bandit1",15,70,7,5);
					Enemy bandit2 = new Enemy("Bandit1",15,70,7,5);
					Enemy bandit3 = new Enemy("Bandit1",15,70,7,5);
					Enemy boss = new Enemy("Boss",15,70,7,5,0);
				} else if (choiceButton2.isSelected()) {
					Enemy bandit1 = new Enemy("Bandit1",15,70,7,5);
					Enemy bandit2 = new Enemy("Bandit1",15,70,7,5);
					Enemy bandit3 = new Enemy("Bandit1",15,70,7,5);
					Enemy bandit4 = new Enemy("Bandit1",15,70,7,5);
					Enemy boss = new Enemy("Boss",15,70,7,5,0);	
				} else if (choiceButton3.isSelected()) {
					Enemy bandit1 = new Enemy("Bandit1",15,70,7,5);
					Enemy bandit2 = new Enemy("Bandit1",15,70,7,5);
					Enemy bandit3 = new Enemy("Bandit1",15,70,7,5);
					Enemy bandit4 = new Enemy("Bandit1",15,70,7,5);
					Enemy bandit5 = new Enemy("Bandit1",15,70,7,5);
					Enemy boss = new Enemy("Boss",15,70,7,5,0);
				}
				
				Ally prince = new Ally("Prince",25,75,8,7);
				if(choiceButton4.isSelected()) {
					prince.setHIT(10);
				System.out.println(prince.getHIT());
				} else if (choiceButton5.isSelected()) {
					prince.setATK(2);
				System.out.println(prince.getATK());
				} else if (choiceButton6.isSelected()) {
					prince.setDEF(2);
				System.out.println(prince.getDEF());
				}
				 
					//Execute Button choices 1
					//Execute Button choices 2
				//} catch(InputMismatchException ime) { //BL: Define new InputMismatchException
					//BL: message pop-up: "choose options"
				//}
				
				dispose();
				SwingUtilities.invokeLater(new Runnable(){
					public void run(){
						new GameGUI();
					}
				});
			}
		});

		//Setting the overall layout
		setLayout(new GridLayout(6,1));
		add(introLabel1);
		add(choicePanel1);
		add(introLabel2);
		add(choicePanel2);
		add(introLabel3);
		add(startButton);

		setPreferredSize(new Dimension(1050,800));
		pack();
		setVisible(true);
	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new StartGUI();
			}
		});
	}
}
