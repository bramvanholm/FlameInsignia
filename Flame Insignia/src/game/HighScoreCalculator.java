package game;

import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.regex.Pattern;

import game.Game;

public class HighScoreCalculator {

	static int highScore;
	//Method to calculate the High Score
	public static int calculateHighScore (int allies, int turns, String difficulty) {
		highScore = allies*100 + turns*100;
		switch(difficulty){
		case "Easy":
			break;
		case "Standard":
			highScore = highScore/2*3;
			break;
		case "Hard":
			highScore = highScore*2;
			break;
		}
		return highScore;
	}
//Getting the High Scores from the file
	public static ArrayList<Integer> getHighScore() {
		ArrayList<Integer> allScores = new ArrayList<Integer>();
		ArrayList<Integer> bestScores = new ArrayList<Integer>();
		try(Scanner scan = new Scanner(new FileReader("Resources/High Scores.txt"));) {
			while (scan.hasNext()) {
				int highScore = scan.nextInt();
				allScores.add(highScore);
			}
			Collections.sort(allScores);

			if (allScores.size()<10) {
				for(int i=0; i<allScores.size(); i++) {
					bestScores.add(allScores.get(i));
				}
			} else {
				for(int i =0;i<10;i++) {
					bestScores.add(allScores.get(i));
				}
			}
		}catch(FileNotFoundException e) {
			System.out.println("File Not Found" +e);
			System.exit(0);

		}catch (Exception e) {
			System.out.println("Error" +e);
			System.exit(0);
		}
		return bestScores;
	}
//Adding the High Score to the file with the High Scores
	public static void addHighScore(int highScore) {

		try (Scanner scan = new Scanner(new FileReader("Resources/High Scores.txt"));
				FileWriter out = new FileWriter("Resources/High Scores.txt",true)){
			FileOutputStream fileOut = new FileOutputStream("Resources/High Scores.txt", true);
			PrintWriter outHighScore = new PrintWriter(fileOut, true);
			outHighScore.format("%d %n", highScore);
			outHighScore.close();
			fileOut.close();
		} catch (IOException e){
			System.out.println("Error" +e);
		}
	}

	/*public static void main(String[] args) {

		int allies= 3;
		int turns =4;
		String difficulty ="Standard";
		int highScore =calculateHighScore( allies, turns,difficulty);
		addHighScore(highScore);
		System.out.println(getHighScore());
	}*/
}
