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

public class GameGUI extends JFrame {

	//BL: Interesting Classes: JLayered, JTextPane

	JLabel turnLabel = new JLabel("Turns left: " +10, JLabel.LEFT);
	JList<String> statList=new JList<String>(new String[] { "Prince", "Boss"});


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

	GameGUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Flame Insignia: Battle");

		gridPanel.setLayout(new GridLayout(8,8));
		addButtons(gridPanel,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f);
		// Random selection from array, for loop for assigning buttons

		turnPanel.add(turnLabel);
		turnPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		statPanel.add(statList);

		infoPanel.setLayout(new GridLayout(2,1));
		infoPanel.add(turnPanel);
		infoPanel.add(statPanel);

		setLayout(new BorderLayout());
		add(gridPanel, BorderLayout.CENTER);
		add(infoPanel, BorderLayout.EAST);


		setPreferredSize(new Dimension(500,500));
		pack();
		setVisible(true);
	}

	//BL: test
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new GameGUI();
			}
		});

	}
}
