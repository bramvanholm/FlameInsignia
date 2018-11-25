package guiFlameInsignia;

//Temp storage of imports; divide/remove this later
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class StartGUI extends JFrame {

	StartGUI(){

		JPanel introPanel = new JPanel();
		JLabel introLabel = new JLabel("The thing you pride yourself the most in is: ", JLabel.CENTER); //TextPane?

		JPanel choicePanel = new JPanel();
		JRadioButton choiceButton1 = new JRadioButton("Choicce1");
		JRadioButton choiceButton2 = new JRadioButton("Choicce1");
		JRadioButton choiceButton3 = new JRadioButton("Choicce3");


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Flame Insignia: Prologue");

		introPanel.add(introLabel);
		
		choicePanel.setLayout(new GridLayout(3,1));
		//BL: Make a ButtonGroup for a single choice button
		choicePanel.add(choiceButton1);
		choicePanel.add(choiceButton2);
		choicePanel.add(choiceButton3);
		
		setLayout(new BorderLayout());
		add(introPanel, BorderLayout.CENTER);
		add(choicePanel, BorderLayout.SOUTH);

		setPreferredSize(new Dimension(400,250));
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
