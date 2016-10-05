/**
Thao Tran
CS146 Data Structures and Algorithms, FALL 2016
Section 3.

Analysis of Theta (n^2) versus Theta (n log n) sorting algorithms.

*/


import java.util.Random;
import java.lang.*;
import java.io.*;
import java.util.*;

public class Sort
{
	public static void main(String[]args)
	{	

		boolean EXIT = false;
		String[] commandsFromUser;
		
		Mergesort msort = new Mergesort();
		Insertionsort isort = new Insertionsort();
		Quicksort qsort = new Quicksort();

		while (EXIT == false )
		{
			commandsFromUser = getCommands();
			/* 
				getCommands() returns a String Array.
			    Command instruction is stored in Array[0]
			    Text file name is stored in Array[1]
			*/

			if(commandsFromUser == null)
			{
				EXIT = true;
			}
		
			else
			{
				
				String fileName = getFileName(commandsFromUser);

				int instructionCalled = getInstructions(commandsFromUser);

				String[] dataFromFile = readTheFile(fileName);
				
				writeUnsortedFile(dataFromFile);

				String[] sortedData;

				if(instructionCalled == 0)
				{
					sortedData = isort.insertionsort(dataFromFile);

					writeTheFile(sortedData);

					writeTextFile(sortedData, "sorted.txt");
				}

				else if(instructionCalled == 1)
				{
					sortedData = msort.mSort(dataFromFile);
					
					writeTheFile(sortedData);

					writeTextFile(sortedData, "sorted.txt");
				}

				else if(instructionCalled == 2)
				{
					sortedData = qsort.qsort(dataFromFile);

					writeTheFile(sortedData);

					writeTextFile(sortedData,"sorted.txt");
				}

			}
				
		}		
	}


/** 
	Processes the String Array given by the user.
	Index [0] holds the requested sorting algorithm.
*/
public static int getInstructions(String[] commandsGiven)
{	
	if(commandsGiven[0].trim().matches("quicksort"))
	{
		return 2;
	}
	if(commandsGiven[0].trim().matches("mergesort"))
	{
		return 1;
	}
	else if(commandsGiven[0].trim().matches("insertionsort"))
	{
		return 0;
	}
	else
		return -1;
}

/**
	Processes the String Array given by the user.
	Index[1] holds the name of the text file.
	File's extention must be of ".txt"
*/
public static String getFileName(String[] dataFromFile)
{
	String fileName;
	String extention = ".txt";

	if(dataFromFile.length == 0)
	{
		return null;
	}
	
	fileName = dataFromFile[1].trim();
		
	if(fileName.endsWith(extention))
		{
			return fileName;
		}
	else
	{
		return null;
	}

}

/**
	Print to command/terminal the entries in the unsorted array.
*/
public static void writeUnsortedFile(String[] unsortedFile)
{
	if (unsortedFile.length == 0)
		return;
	else
	{
		System.out.println("\n-------- Unsorted File --------");

		for(int i = 0; i < unsortedFile.length; i++)
		{
			System.out.println( " " + unsortedFile[i] + "" );
		}

		System.out.println("\n-------- End Of File --------");
	}

}
/**
	Print to command/termial the entries in the sorted Array.
*/
public static void writeTheFile(String[] sortedFile)
{
	if (sortedFile.length == 0)
		return;
	else
	{
		System.out.println("\n-------- Sorted File --------");

		for(int i = 0; i < sortedFile.length; i++)
		{
			System.out.println( " " +sortedFile[i] + "" );
		}

		System.out.println("\n-------- End Of File --------");
	}
}


/** 
	Process the file, Buffer is used to read each entry in the file.
	Each entry is separated by a new line.
*/
public static String[] readTheFile(String fileName)
{

	System.out.println("\n****** Reading from file: /" + fileName + "*****");

	ArrayList<String> data = new ArrayList<String>();
	
	String line = null;
	
	try
	{
		FileReader filereader = new FileReader(fileName);
		BufferedReader bufferedreader = new BufferedReader(filereader);
		while( (line = bufferedreader.readLine()) != null)
		{
			data.add(line);
		}	
		
		bufferedreader.close();
	}

	catch(FileNotFoundException e)
	{	
		System.out.println("\n\t\t***File not found!***\n");
	}

	catch(IOException ex)
	{
		System.out.println("\n\t\t***End of File***\n");
	}

	String[] names = new String[data.size()];
	
	names = data.toArray(names);

	return names;

}

public static String[] getCommands()
{
	System.out.println("Valid instructions are: ");		
	System.out.println("\t1) insertionsort _____.txt");
	System.out.println("\t2) mergesort _____.txt");
	System.out.println("\t3) quicksort _____.txt");
	System.out.println("\t4) exit")
	System.out.println("Type in instruction: \t");
	Scanner inputCommand = new Scanner(System.in);	
	String givenCommand = inputCommand.nextLine();
	

	while( !givenCommand.trim().matches("exit") )
		{
			String[] instructionArray = givenCommand.split("\\s+");

			if(instructionArray[0].matches("insertionsort") || 
				instructionArray[0].matches("mergesort") )
					{
						return instructionArray;
					}
			else
					{
						System.out.println("Not a valid instruction\nType in instruction or\nType exit to quit.");
						givenCommand = inputCommand.nextLine();
					}
		}	
	return null;
}


}


