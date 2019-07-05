/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram 

{

	public RandomGenerator rgen = RandomGenerator.getInstance();
	
	public String gameWord = "";
	
	public String dashes = ""; 
	
	public int guessesLeft = 8;
	
	public String guess = "";
	
    public void run()
    
	{
		setupGame();
		
		playGame();
	}

	public void setupGame()
	
	{
		chooseWord();
		
		wordToDashes(gameWord);
		
	}
	
	public String chooseWord()
	
	{
	
		int randomNumber = rgen.nextInt(0, getWordCount());
		
		gameWord = getWord(randomNumber);
		
		return gameWord;
		
	}
	
	public String wordToDashes(String str)
	
	{
		
		for (i = 0; i < gameWord.length(); i++) {
	
		dashes += "-";
		
		return dashes;
		
	}
	
	public void playGame ()
	
	{
		
		while (guessesLeft != 0)
		
		{
	
			System.out.println = "You have " + guessesLeft + "guesses left.";
	
	//this can't be right
			guess = println(nextLine("Please guess a letter: "));
	
			guess = guess.toUpperCase();
		
			if (guessIsValid() && guessMatchesLetter())
		
			{
				
				updateDashes();
				
			}
			
			else
			
			{
			
				guessesLeft--; 
				
			}
			
			if (dashes == gameWord)
			
			{
			
			System.out.println("You win. The word is " + gameWord + ".")
			
		
		}
		
		if (guessesLeft == 0) 
		
		{
		
		System.out.println("You lose. The word was " + gameWord + ".")
		
	}
	
	public boolean guessIsValid() {
	
		if (guess.CharAt(i).isLetter() {
			
			return true;
	
		} else {
			
			return false;
		}
	
	public boolean guessMatchesLetter()
	
	{
		
		for (i = 0; i < gameWord.length; i++)
		
		if (i == guess)
		
		return true;
	
	}
	
	public string updateDashes() 
	
	{
		
		for (i = 0; i < dashes.length(); i++)
		
		{
		
			if (gameWord(i) == guess)
		
			{
				
				dashes = dashes.replace(charAt(i), guess);
				
				System.out.println(dashes);
				
			}
		
		}
	
	}

	isGameOver

}
