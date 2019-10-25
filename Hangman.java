// Muhammad Iqbal

import java.util.*;		// Import libraries
import java.io.*;

class Hangman{
	public static void main(String[] args){	// Main method

		int count = 0;			// Declare variables
		String userGuess = "";
		int attempts = 0;
		ArrayList<String> guessesList  = new ArrayList<String>();
		Scanner kb = new Scanner(System.in);

		String[] wordsArray = wordsFromFile(); // Method to access words from file

		String[] secretWord = pickRandomWord(wordsArray);	// Randomly picks one word

		String[] displayDashes = new String[secretWord.length]; // Display word in dashes
		while(count < secretWord.length){
			displayDashes[count] = "_";
			count++;
		}
			System.out.println("+------------------------------+");		// Print message board
			System.out.println("|   "+converToWord(displayDashes));		// Set dashes with empty string
			System.out.println("+------------------------------+");
			System.out.println("|   Misses: " + guessesList);			// Stores user guesses to arraylist
			System.out.println("|   Guess a word:  ");
			System.out.println("+------------------------------+");

		while (attempts < 8){		// Main loop
			boolean guessedWord = false;	// Set boolean values to false
			boolean gameWin = false;

			userGuess = kb.nextLine();		// Takes user guess
			guessesList.add(userGuess);		// Adds user guess to the list of guesses

			count = 0;					// Reset loop counter
			while(count < secretWord.length){		// Create a loop to the size of the hidden letter
				if (secretWord[count].equals(userGuess)){	// Check if user input matches each letter
					displayDashes[count] = userGuess;		// If it matches, replace dashes with user input
					guessedWord = true;		// Set the boolean logic to true
				}
				count++;	// Move the counter to the next letter
			}
			System.out.println("");			// Print the list of letters to the message board
			System.out.println("");
			System.out.println("+------------------------------+");
			System.out.println("|   "+converToWord(displayDashes));

		if (guessedWord == false){	// Incorrect guess
			attempts++;
			hangedManFigure(attempts); // Print a part of hangman figure

			System.out.println("");
			System.out.println("");
			System.out.println("+------------------------------+");
			System.out.println("|   "+converToWord(displayDashes));		// Display dashes
			System.out.println("| ");
			System.out.println("| Incorrect!");
			System.out.println("+------------------------------+");
			System.out.println("+------------------------------+");
			System.out.println("|   Misses: " + guessesList);	// Show the list of user guesses
			System.out.println("|   Guess a word: ");
			System.out.println("+------------------------------+");
			System.out.println("");
			System.out.println("");

		if (attempts == 7){		// Game over
			System.out.println("   YOU LOSE");
			System.out.println("   The answer was: " + converToWord(secretWord) + "!");
			break;
		}
		}

		else{		// Correct guess
			System.out.println("| ");
			System.out.println("| Correct!");
			System.out.println("+------------------------------+");
			System.out.println("+------------------------------+");
			System.out.println("|   Misses: " + guessesList);
			System.out.println("|   Guess a word: ");
			System.out.println("+------------------------------+");
			System.out.println("");
			System.out.println("");
		}

			count = 0;
			while(count < secretWord.length){  // Set the boolean logic for game winning statement
				if(displayDashes[count].equals("_")){
					gameWin = false;
					break;
					}
					else{
						gameWin = true;
					}
					count++;
				}

		if(gameWin == true){	// Game win
			System.out.println("   YOU WIN!");
			System.out.println("   The answer was: " + converToWord(secretWord) + "!");
			break;
			}
		}
	}

// ---------------------------------------- Methods -------------------------------------------

	public static String[] wordsFromFile(){		// A method to read from text file
		int choice = 0;
		String[] fileArray = null;				// Declare variables
	  	ArrayList<String> easyList = new ArrayList<String>();
		ArrayList<String> mediumList = new ArrayList<String>();
		ArrayList<String> hardList = new ArrayList<String>();
		Random rand = new Random();
		Scanner inFile1 = null;
		Scanner inFile2 = null;
		Scanner inFile3 = null;
		Scanner scan = new Scanner(System.in);

		System.out.println("");							// Welcome message
		System.out.println("");
		System.out.println("+------------------------------+");
		System.out.println("|   WELCOME TO HANGMAN GAME    |");
		System.out.println("+------------------------------+");
		System.out.println("");
		System.out.println("");
		System.out.println("***Game Rules*** ");
		System.out.println("The word to guess is represented by a row of dashes, giving the number of letters, numbers and category.");
		System.out.println("If the guessing player suggests a letter which occurs in the word, the computer will write it in all its correct positions.");
		System.out.println("If the suggested letter does not occur in the word, the computer will draw one element of a hanged man stick figure as a tally mark.");
		System.out.println("The game is over when: ");
		System.out.println(" -The guessing player completes the word");
		System.out.println(" -The program completes the diagram");
		System.out.println("");
		System.out.println("Press enter to continue..");
		scan.nextLine();							// Game menu
		System.out.println("");
		System.out.println("");
		System.out.println("+------------------------------+");
		System.out.println("| Choose your difficulty level |");
		System.out.println("|         1-- Easy             |");
		System.out.println("|         2-- Medium           | ");
		System.out.println("|         3-- Hard             | ");
		System.out.println("|         4-- Exit             | ");
		System.out.println("+------------------------------+");
		System.out.println("");
		System.out.println("");

		choice = scan.nextInt();
		if(choice == 4){
		System.out.println("");
		System.out.println("Game Exiting...");
		System.out.println("Thank you for playing");
		System.exit(0);
		}


		if(choice == 1){

		try{  // try catch block for text file handling
			inFile1 = new Scanner(new File("easy.txt"));	// Easy.txt file
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(1);
		}

			while(inFile1.hasNext()){		// Creates a loop that reads all contents from the file
				easyList.add(inFile1.nextLine()); // If the file exist, add it to the arraylist
			}
			fileArray = new String[easyList.size()];	// Converts arraylist back to string array
			fileArray = easyList.toArray(fileArray);
		}


		if(choice == 2){

		try{
			inFile2 = new Scanner(new File("medium.txt"));		// Medium.txt file
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(1);
		}

			while(inFile2.hasNext()){
				mediumList.add(inFile2.nextLine());
			}
			fileArray = new String[mediumList.size()];
			fileArray = mediumList.toArray(fileArray);
		}


		if(choice == 3){

		try{
			inFile3 = new Scanner(new File("hard.txt"));	// Hard.txt file
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(1);
		}

			while(inFile3.hasNext()){
				hardList.add(inFile3.nextLine());
			}
			fileArray = new String[hardList.size()];
			fileArray = hardList.toArray(fileArray);
		}
			return fileArray;
	}



	public static String converToWord(String[] displayDashes){  // A method that removes the dashes and returns string
		String word = "";
		int count = 0;

		while(count < displayDashes.length){
			if(displayDashes[count] == "_"){
				word = word + " ";
			}
			word = word + displayDashes[count];
			count++;
		}

		return word;
	}



	public static String[] pickRandomWord(String[] wordsArray){ // Randomly picks a word
		String pickedWord = "";

		pickedWord = wordsArray[(int)(Math.random()* wordsArray.length)];
		String[] letters = pickedWord.split("(?!^)");//Negative lookahead for start of string, means not positioined before the start of input. Picks word per line
		return letters;
	}



	public static void hangedManFigure(int attempts){	 // Hangman stick figure
		if (attempts == 1) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("      +-----+  ");
			System.out.println("      |        ");
			System.out.println("      |        ");
			System.out.println("      |        ");
			System.out.println("      |        ");
			System.out.println("      |        ");
			System.out.println("      |________");
			System.out.println();
		}
		if (attempts == 2) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("      +-----+  ");
			System.out.println("      |     0  howdy! Im Jack");
			System.out.println("      |        ");
			System.out.println("      |        ");
			System.out.println("      |        ");
			System.out.println("      |        ");
			System.out.println("      |________");
			System.out.println();

		}
		if (attempts == 3) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("      +-----+  ");
			System.out.println("      |     0  ");
			System.out.println("      |     |  ");
			System.out.println("      |        ");
			System.out.println("      |        ");
			System.out.println("      |        ");
			System.out.println("      |________");
			System.out.println();
		}
		if (attempts == 4) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("      +-----+  ");
			System.out.println("      |     0  ");
			System.out.println("      |     |\\");
			System.out.println("      |        ");
			System.out.println("      |        ");
			System.out.println("      |        ");
			System.out.println("      |________");
			System.out.println();
		}
		if (attempts == 5) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("      +-----+  ");
			System.out.println("      |     0  oh no!");
			System.out.println("      |    /|\\");
			System.out.println("      |        ");
			System.out.println("      |        ");
			System.out.println("      |        ");
			System.out.println("      |________");
			System.out.println();
		}
		if (attempts == 6) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("      +-----+  ");
			System.out.println("      |     0  save me!!");
			System.out.println("      |    /|\\");
			System.out.println("      |    /   ");
			System.out.println("      |        ");
			System.out.println("      |        ");
			System.out.println("      |________");
			System.out.println();
		}

		if (attempts == 7) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("      +-----+  ");
			System.out.println("      |     0  ");
			System.out.println("      |    /|\\");
			System.out.println("      |    / \\");
			System.out.println("      |        ");
			System.out.println("      |        ");
			System.out.println("      |________");
			System.out.println("      GAME OVER");
			System.out.println();
		}
	}		// End of method
}	// End of program
