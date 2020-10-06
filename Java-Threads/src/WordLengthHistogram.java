import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Program to read the contents of a text file and display a histogram of the 
 * 		lengths	of the words in the file.<br>
 * @author andrianoff
 * @version 15 Feb 2018
 */
public class WordLengthHistogram
{

	public static void main(String[] args) throws FileNotFoundException
	
	{
		int[] freq = new int[21];
		String word;
		String filename;
		
		Scanner console = new Scanner(System.in);
		
		System.out.print("Enter name of text file: ");
		filename = console.next();
		
		Scanner sc = new Scanner(new File(filename));
		
		while (sc.hasNext())
		{
			word = sc.next();
			freq[word.length()]++;
		}
		
		displayHistogram(freq);
	}
	
	/**
	 * Displays a (horizontal) histogram of the values stored in list.
	 * @param list the list of values
	 */
	private static void displayHistogram(int[] list)
	{
		int i;
		int j;
		
		for (i = 1; i < list.length; i++)
		{
			try {
				System.out.print("[" + ((i < 10)?" ":"") + i + "]  ");
			
			for (j = 0; j < list[i]; j++)
			{
				System.out.print("*");
			}
		}
			catch(InterruptedException e) {
			}
			
			System.out.println();
		}
	}
		
	}
