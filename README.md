# Hangman Game

Game Design:

-Create a method wordsFromFile that returns string array.

	. Print welcome message.
	. Print game menu.
	. Ask user for seleciton.
	. If user choice selected.
		. Access file in try catch exception block.
		. Create a loop that runs while there is content left in the file.
			. Check if the contents of the file exist. Add it to the arraylist and close the loop.
		. Convert arraylist back to string array.
		. Return string array.
	. Repeat same process for Medium.txt and Hard.txt.
	
-Add wordsFromFile method to the string array wordsArray.
-Create a method pickRandomWord that takes string array wordsArray as an argument and returns string array.

	. Declare string variable.
	. Generate random word from string array wordsArray and assign it to the string variable.
	. Split the string variable into its substrings based on the given regular expression.
	. Add the splitted string variable to the new string array letters.	
	. return string array letters.
	
-Create string array secretWord and populate it with pickRandomWord method.
-Create a string array displayDashes and populate it with string array secretWord.

	. Create a loop that runs to the size of string array secretWord.
		. Replace first index of string array displayDashes with dash.
		. Move the counter to the next position until the loop is finished.
		
-Create a method convertToWord that takes string array displayDashes as an argument and returns a string variable.

	. Create a loop to the length of string array displayDashes.
	. Check if first index of string array displayDashes is equal to dash, if true, assign it to an empty string variable.
	. Return string variable.
	. Print out the method and display dashes to the length of the randomly generated secretWord.
	
-Prompt user to enter a letter.
-Take user input and add it to the string arraylist guessesList.
-Creat a loop to the size of the string array secretWord.

	. Check if user guess is equal to the first index of string array secretWord.
		. If yes, set the boolean value to true and print the letter on message board.
		. If boolean value is false, increment the intiger variable by 1 and print out the hangman stick figure.
			. Print out the dash from string array displayDashes.
			. Check if user attempts reaches to 7, finish the game and exit the program.
			
 -Create a loop that goes to the length of the string array secretWord.
 
	. Check if all elements of the string array displayDashes are equal to dashes. If true, boolean logic is set to false and game will continue.
	. If boolean logic is true, print the winning message and exit the program.
