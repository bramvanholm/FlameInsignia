package gui;

//Temp storage of imports; divide/remove this later
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class StartGUI extends JFrame {

	StartGUI(){

		String introText1 = "The relationship with your country's neighbor has always been strained.";
		String introText2 =	"But finally an envoy was sent to arrange talks for peace and tax regulations.";
		String introText3 =	"As the Prince, you are tasked with escorting the envoy back to his homeland, as a sign of goodwill.";
		String introText4 =	"While engaging in idle conversation, the envoy asks you:'What is the thing you pride yourself the most in?";
		String introText5 =	"You respond with:";
		
		String introText6 = "At nightfall your group sets up camp, and everyone eventually goes to sleep in their respective tents.";
		String introText7 = "Suddenly you wake up to screams. You hear a guard yell:'Bandits! The mountain bandits are attacking!'";
		String introText8 = "You immediately realize the severity of the situation:";
		String introText9 = "If something were to happen to the envoy, it would mean war. You run outside prepared for battle...";



		JPanel introPanel1 = new JPanel();
		JPanel introPanel2 = new JPanel();
		JLabel introLabel1 = new JLabel(introText1, JLabel.CENTER);
		JLabel introLabel2 = new JLabel(introText2, JLabel.CENTER);
		JLabel introLabel3 = new JLabel(introText3, JLabel.CENTER);
		JLabel introLabel4 = new JLabel(introText4, JLabel.CENTER);
		JLabel introLabel5 = new JLabel(introText5, JLabel.CENTER);
		
		JLabel introLabel6 = new JLabel(introText6, JLabel.CENTER);
		JLabel introLabel7 = new JLabel(introText7, JLabel.CENTER);
		JLabel introLabel8 = new JLabel(introText8, JLabel.CENTER);
		JLabel introLabel9 = new JLabel(introText9, JLabel.CENTER);	//TextPane?

		JPanel choicePanel = new JPanel();
		JRadioButton choiceButton1 = new JRadioButton("My aim. I always succeed in hitting my opponent.");
		JRadioButton choiceButton2 = new JRadioButton("My strength. I crush my opponents with overwhelming power.");
		JRadioButton choiceButton3 = new JRadioButton("My armor. I shrug off my opponents attacks like my morning robe.");


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Flame Insignia: Prologue");

		introPanel1.setLayout(new GridLayout(5,1));
		introPanel1.add(introLabel1);
		introPanel1.add(introLabel2);
		introPanel1.add(introLabel3);
		introPanel1.add(introLabel4);
		introPanel1.add(introLabel5);

		choicePanel.setLayout(new GridLayout(3,1));
		//BL: Make a ButtonGroup for a single choice button
		choicePanel.add(choiceButton1);
		choicePanel.add(choiceButton2);
		choicePanel.add(choiceButton3);
		
		introPanel2.setLayout(new GridLayout(4,1));
		introPanel2.add(introLabel6);
		introPanel2.add(introLabel7);
		introPanel2.add(introLabel8);
		introPanel2.add(introLabel9);
		
		ButtonGroup choiceGroup = new ButtonGroup();
		choiceGroup.add(choiceButton1);
		choiceGroup.add(choiceButton2);
		choiceGroup.add(choiceButton3);
		
		choicePanel.setLayout(new GridLayout(3,1));
		//BL: Make a ButtonGroup for a single choice button
		choicePanel.add(choiceButton1);
		choicePanel.add(choiceButton2);
		choicePanel.add(choiceButton3);
		
		setLayout(new BorderLayout());
		add(introPanel1, BorderLayout.NORTH);
		add(choicePanel, BorderLayout.CENTER);
		add(introPanel2, BorderLayout.SOUTH);

		setPreferredSize(new Dimension(700,300));
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
