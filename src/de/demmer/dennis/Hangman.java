package de.demmer.dennis;

import java.util.List;
import java.util.Scanner;

public class Hangman {

	private String[] pics = {	
			"       \r\n" + 
			"       \r\n" + 
			"       \r\n" + 
			"       \r\n" + 
			"       \r\n" + 
			"       \r\n" + 
			"         \n" ,
			"       \r\n" + 
			"       \r\n" + 
			"       \r\n" + 
			"       \r\n" + 
			"       \r\n" + 
			"       \r\n" + 
			"=========\n" ,
			"  +---+\r\n" + 
			"  |   |\r\n" + 
			"      |\r\n" + 
			"      |\r\n" + 
			"      |\r\n" + 
			"      |\r\n" + 
			"=========\n" ,
			
			"  +---+\r\n" + 
			"  |   |\r\n" + 
			"  O   |\r\n" + 
			"      |\r\n" + 
			"      |\r\n" + 
			"      |\r\n" + 
			"=========\n" ,
			
			"  +---+\r\n" + 
			"  |   |\r\n" + 
			"  O   |\r\n" + 
			"  |   |\r\n" + 
			"      |\r\n" + 
			"      |\r\n" + 
			"=========\n" ,
			
			"  +---+\r\n" + 
			"  |   |\r\n" + 
			"  O   |\r\n" + 
			" /|   |\r\n" + 
			"      |\r\n" + 
			"      |\r\n" + 
			"=========\n" , 
			
			"  +---+\r\n" + 
			"  |   |\r\n" + 
			"  O   |\r\n" + 
			" /|\\  |\r\n"+ 
			"      |\r\n" + 
			"      |\r\n" + 
			"=========\n" ,
			
			"  +---+\r\n" + 
			"  |   |\r\n" + 
			"  O   |\r\n" + 
			" /|\\  |\r\n"+ 
			" /    |\r\n" + 
			"      |\r\n" + 
			"=========\n" ,
			
			"  +---+\r\n" + 
			"  |   |\r\n" + 
			"  O   |\r\n" + 
			" /|\\  |\r\n"+ 
			" / \\  |\r\n"+ 
			"      |\r\n" + 
			"=========\n"};
	
	// Words the program choose from on start up
	private String[] wordBag = {"Java"};
	
	// A representation of the word as a List of Letters. Each Letter holds a boolean value to express its state (solved/not solved)
	private List<Letter> word;
	
	// Number of tries before the game is over
	private int tries = 8;
	
	// Scanner to get user input
	private Scanner scanner = new Scanner(System.in);
	
	
	public Hangman() {
		//create random index for word to pick
		int randomIndex = getRandomIndex();
		
		// Fill the List<Letter> with the chars of the string
		word = wordToList(wordBag[randomIndex]);
		
		// Game Loop: 
		// breaks if tries are exceeded or game is won
		while(tries > 0) {
			printHangman();
			printWord();
			askForChar();
			if(checkForWin() == true) break;
			System.out.println("\n\n*********************\n\n");
		}
		
		// if loop break and tries are 0 or less
		if(tries <= 0) {
			printHangman();
			System.out.println("You loose. The word was '" + wordBag[randomIndex] + "'");
		}
	}
	

	private int getRandomIndex() {
		// TODO 
		// return random int in range of the wordBag length
		return 0;
	}

	private boolean checkForWin() {
		// TODO
		// check if all Letters in the List<Letter> word are solved
		// print finished word and congratulation message
		// return true
		
		//else
		return false;
	}

	private void askForChar() {
		// TODO
		// ask for character input
		// check if character exists in the List<Letter>
		// if so set the letters isSolved boolean to true
		// if no equal char found -> tries -1
		
	}

	private void printWord() {
		// TODO
		// print all Letter in 'List<Letter> word'
		// if the current Letter isSolved print " "
		// else print "_"
		
	}

	private void printHangman() {
		// TODO
		// print the current picture from the 'String[] pics' based on the tries left
	}

	private List<Letter> wordToList(String string) {
		// TODO
		// Fill the List<Letter> with the chars of the string
		return null;
	}
	
}
