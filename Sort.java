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

		while (EXIT == false )
		{
			commandsFromUser = getCommands();
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
					//System.out.println("***Insertionsort Called!");

					sortedData = isort.insertionsort(dataFromFile);

					writeTheFile(sortedData);

					writeTextFile(sortedData, "sorted.txt");
				}
				else if(instructionCalled == 1)
				{
					//System.out.println("***Mergesort Called!");

					sortedData = msort.mSort(dataFromFile);


				}

			}
				//	System.out.println("******** instruction given: " + instructionCalled);
		}		
	}


public static int getInstructions(String[] commandsGiven)
{
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

public static void writeUnsortedFile(String[] unsortedFile)
{
	if (unsortedFile.length == 0)
		return;
	else
	{
		System.out.println("-------- Unsorted File --------");

		for(int i = 0; i < unsortedFile.length; i++)
		{
			System.out.println( " " + unsortedFile[i] + "" );
		}

		System.out.println("-------- End Of File --------");
	}

}
public static void writeTheFile(String[] sortedFile)
{
	if (sortedFile.length == 0)
		return;
	else
	{
		System.out.println("-------- Sorted File --------");

		for(int i = 0; i < sortedFile.length; i++)
		{
			System.out.println( " " +sortedFile[i] + "" );
		}

		System.out.println("-------- End Of File --------");
	}
}



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


