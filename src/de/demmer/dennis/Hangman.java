package de.demmer.dennis;

import java.util.ArrayList;
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
		
		return (int) Math.floor(Math.random()*wordBag.length);
	}

	private boolean checkForWin() {
		// TODO
		// check if all Letters in the List<Letter> word are solved
		// print finished word and congratulation message
		// return true
		
		for (Letter letter : word) {
			if(!letter.isSolved()) {
				return false;
			}
		}
		
		System.out.println();
		printWord();
		System.out.println("You win!");
		
		//else
		return true;
	}

	private void askForChar() {
		// TODO
		// ask for character input
		// check if character exists in the List<Letter>
		// if so set the letters isSolved boolean to true
		// if no equal char found -> tries -1
		
		
		System.out.println("\n Please enter new letter and press ENTER");
		
		Character input = scanner.next().charAt(0);
		
		boolean charFound = false;
	
		for (Letter letter : word) {
			Character letterLower = Character.toLowerCase(letter.getLetter());
			Character inputLower = Character.toLowerCase(input);
			
			if(letterLower.equals(inputLower)) {
				letter.setSolved(true);
				charFound = true;
			}
		}
		
		if(charFound == false) {
			tries = tries -1;
		}
		
	}

	private void printWord() {
		// TODO
		// print all Letter in 'List<Letter> word'
		// if the current Letter isSolved print " "
		// else print "_"
		
		for (Letter letter : word) {
			if(letter.isSolved()) {
				System.out.print(letter.getLetter()+ " ");
			} else {
				System.out.print("_ ");
			}
		}
		
		System.out.println();
		
	}

	private void printHangman() {
		// TODO
		// print the current picture from the 'String[] pics' based on the tries left
		
		System.out.println(pics[pics.length-tries-1]);
				
	}

	private List<Letter> wordToList(String string) {
		// TODO
		// Fill the List<Letter> with the chars of the string
		
		List<Letter> letters = new ArrayList<Letter>();
		
		for (Character character  : string.toCharArray()) {
			letters.add(new Letter(character));	
		}
		
		return letters;
	}
	
}
