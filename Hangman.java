
/*   
 
 * File: Hangman.java
  ------------------
  
 If I told you that this program was written in Eclipse, that would not be the 
  whole truth. 
  
  Please see readme sections:
	  
	1) Where I was.

	2) Where I am.
	
	3) Where I am going, I can.

	I promise you it will be worth the time. 
  
    It was worth it to me.
  
  */
 

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.util.Scanner;

import java.awt.*;

public class Hangman extends ConsoleProgram 

{

	public static final RandomGenerator RGEN = RandomGenerator.getInstance();
	
	private String gameWord;
	
	private String dashes; 
	
	private int guessesLeft = 8;
	
	private Character theGuess;
	
	private char[] wordToArray; 
	
	private char guessChar(String guess)
	
	{
		
		theGuess = guess.charAt(0);
		
		return theGuess;
		
	}
	
	@Override
	
    public void run()
    
	{
		
    	setupGame();
		
		playGame();
	}

	public void setupGame()
	
	{
		chooseWord();
		
		makeWordArray(gameWord);
		
		wordToDashes(gameWord);
		
	}
	
	public String chooseWord()
	
	{
	
		HangmanLexicon wordNumber = new HangmanLexicon();
		
		int randomNumber = RGEN.nextInt(0, wordNumber.getWordCount() - 1);
		
		gameWord = wordNumber.getWord(randomNumber);
		
		return gameWord.toUpperCase();
		
	}
	
	public char[] makeWordArray(String word)
	
	{

		wordToArray = word.toCharArray();
		
		return wordToArray;
	}

	public String wordToDashes(String gameWord)
	
	{
		
		for (int i = 0; i < gameWord.length(); i++) 
		
		{
			
		// String builder will always be preferable here because of performance gains, 
		// gains but I kept this for-loop "as-is" for purely sentimental reasons.
			
			dashes += "-";
			
		}
		
		return dashes;
		
	}

	public void playGame ()
	
	{
		
		while (guessesLeft != 0)
		
		{
	
			System.out.println("You have " + guessesLeft + " guesses left.");
	
			Scanner letterReader = new Scanner(System.in);
			
			System.out.println("Please guess a letter: ");
	
			String guess = letterReader.nextLine();
	
			guess = guess.toUpperCase();
			
			if (Character.isLetter(guessChar(guess)) && guessMatchesLetter(guessChar(guess)))
		
			{
				
				updateDashes(theGuess);
				
				System.out.println(dashes);
				
				System.out.println("Correct!  Here is what the word looks like now: " + dashes);
				
				// updateDashes(theGuess);
				
				if (dashes.equals(gameWord))
				
				{
				
					System.out.println("You win. The word is " + gameWord + ".");
				
					break;
				
				}
				
			}
			
			else
			
			{
				
				System.out.println("That guess did not match.");
			
				guessesLeft--;
				
				if (guessesLeft == 0) 
		
				{
		
					System.out.println("You lose. The word was " + gameWord + ".");
				}
				
			}
		
		}
		
	}
	
	public boolean guessMatchesLetter(char theGuess)
	
	{
		
		for (int i = 0; i < wordToArray.length; i++)
		
		{
			
			if (theGuess == wordToArray[i])
		
			{
		
				return true;
		
			}
				
		}
		
			return false;
	
	}
	
	public String updateDashes (char ch)
	
	{
		
		for (int i = 0; i < gameWord.length(); i++ )
			
		{
			
			if (theGuess == gameWord.charAt(i))
					
			{
			
				if (i == 0)
					
				{	
				
					dashes = theGuess + dashes.substring(1);
				
				}
				
				else if (i > 0)
					
				{				
		
					dashes = dashes.substring(0, i) + theGuess + dashes;
				
				}
				
			}	
			
		}
		
		return dashes;
		
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
