package de.demmer.dennis;

public class Letter {

	private boolean isSolved = false;
	private Character letter;
	
	
	public Letter(Character letter) {
		this.letter = letter;
	}


	public boolean isSolved() {
		return isSolved;
	}


	public void setSolved(boolean isSolved) {
		this.isSolved = isSolved;
	}


	public Character getLetter() {
		return letter;
	}
	
}
