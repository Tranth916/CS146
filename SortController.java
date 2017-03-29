package CS146;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The SortController class is used to handle the User's input and output
 * requests. This class handles the file reading,writing, and generating random
 * data tables.
*/
public class SortController{
	/**
     * String used to store the external file's name.
     */
    private String dataFileName;
    /**
     * String array used to store the data table read from the external file.
     */
    private String[] dataFromText;
    /**
     * String used to store the input from the user.
     */
    private String instructionsFromUser;
  
    /*
    Constructor for Sort Controller.
    No parameters required.
    */
    public SortController()
    {
        startSort();
    }
    
    /**
     * Method used handle the application's loop while waiting for user's input.
    */
    public void startSort(){
        /*
        Loop holds if there is no valid instruction input or no input from user.
        */
        while(instructionsFromUser == null)
        {
            /*
            Get the User's input from Keyboard, validates that the first whole
            word is a valid sorting algorithm.
            */
            instructionsFromUser = getCommands();
            
            if(dataFileName != null && dataFileName.length() > 0)
            {
                dataFromText = readTheFile(dataFileName);
            }
            else
            {
                getFileName();
                dataFromText = readTheFile(dataFileName);
            }
            if(dataFromText.length > 0)
            {
                writeUnsortedFile(dataFromText);
            }
            /**
             * 
             */
            if(dataFromText.length > 0)
            {
                callSortMethod(instructionsFromUser);
            }
            if(dataFromText.length > 0)
            {
                writeTheSortedFile(dataFromText);
            }
            
            saveTheFile();
        }    
    }
/**
 * 
 * @param sortAlgorithm string value of which sorting algorithm called.
 * @post starts the sorting sequence.
 */
    public void callSortMethod(String sortAlgorithm)
    {
        if(sortAlgorithm.matches("insertionsort"))
        {
            Insertionsort.iSort(dataFromText);
        }
        else if(sortAlgorithm.matches("mergesort"))
        {
            Mergesort.mSort(dataFromText);
        }else if(sortAlgorithm.matches("quicksort"))
        {
            Quicksort.qSort(dataFromText);
        }else if(sortAlgorithm.matches("exit"))
        {
            System.exit(1);
        }
    }
    
    /**
     * 
     * @return  String value of which sorting algorithm was called and the text
     * name.
     */
    public String getCommands() {
        System.out.println("Valid instructions are: ");
        System.out.println("\t==> insertionsort _____.txt");
        System.out.println("\t==> mergesort _____.txt");
        System.out.println("\t==> quicksort _____.txt");
        System.out.println("\t==> exit");
        System.out.println("Type in instruction: \t");
        System.out.print("=>");
        Scanner inputCommand = new Scanner(System.in);
        String givenCommand = inputCommand.nextLine();
        givenCommand = validateInstructions(givenCommand);
        return givenCommand;
    }
    /**
     * Method call to ensure the instruction input from the user is valid.
     * @param input String valid of the input from scanner.
     * @return  Return the String value of which sorted algorithm called.
     */
    public String validateInstructions(String input) {
        String[] validMethodCalls = {"insertionsort", "mergesort", "quicksort"};
        String[] processInput = input.toLowerCase().trim().split("\\s+");
        String methodCalled = "";
        for (int i = 0; i < processInput.length; i++) {
            for (int j = 0; j < validMethodCalls.length; j++) {
                System.out.println("called: " + processInput[i]);
                
                if (processInput[i].contains("exit")) {
                    System.exit(1);
                }
                if (processInput[i].matches(validMethodCalls[j])) 
                {
                    methodCalled = processInput[i];
                    dataFileName = getFileName(input);
                    return methodCalled;
                }
            }   
        }
        return null;
    } 
    /**
     * Method call to retrieve the file name from user's input.
     * @return return the file name if valid with extention .txt.
     */
    public String getFileName()
    {
        Scanner input = new Scanner(System.in);
        while(input.hasNext())
        {
            System.out.println("Enter a valid file name. Such as: Data.txt");
            String dataName = input.next().trim();
            if(dataName.contains("exit"))
            {
                System.exit(1);
            }
            if(dataName.trim().endsWith(".txt"))
            {
                dataFileName = dataName.trim();
            }
        }
        return dataFileName;
    }
    public String getFileName(String givenInput) {
        String fileName = "";
        String[] processInput = givenInput.split(("\\s+"));
        for(int i = 0; i < processInput.length; i++)
        {
            if(processInput[i].endsWith(".txt"))
            {
                fileName = processInput[i];
            }else
            {
                fileName = null;
            }
        }
        return fileName;
    }
    /**
     * Process the file, Buffer is used to read each entry in the file. Each
     * entry is separated by a new line.
     * @param fileName
     * @params fileName String value of the file name.
     * @throws e FileNotFoundException if the file is not in the class's local directory.
     * @throws ex IOException if the file has reached the end. 
     * @return names String array with the data read from text file.
     */
    public String[] readTheFile(String fileName) {
        System.out.println("\n****** Reading from file: /" + fileName + "*****");
        ArrayList<String> data = new ArrayList<>();
        String line = null;
        try {
            FileReader filereader = new FileReader(fileName);
            BufferedReader bufferedreader = new BufferedReader(filereader);
            while ((line = bufferedreader.readLine()) != null) {
                data.add(line);
            }
            bufferedreader.close();
        } catch (FileNotFoundException e) {
            System.out.println("\n\t\t***File not found!***\n");
            fileName = getFileName();
            readTheFile(fileName);
            
        } catch (IOException ex) {
            System.out.println("\n\t\t***End of File***\n");
        }
        String[] names = new String[data.size()];
        names = data.toArray(names);
        return names;
    }
    /**
     * Print to command/terminal the entries in the unsorted array.
     */
    
    public void writeUnsortedFile(String[] unsortedFile) {
        if (unsortedFile.length == 0) {
            return;
        }
        else {
            System.out.println("\n-------- Unsorted File --------");

            for (int i = 0; i < unsortedFile.length; i++) {
                System.out.println(" " + unsortedFile[i] + "");
            }
            System.out.println("\n-------- End Of File --------");
        }

    }
    /**
     * Print to command/termial the entries in the sorted Array.
     * @param sortedFile pass the sorted data to be printed.
     */
    public void writeTheSortedFile(String[] sortedFile) {
        if (sortedFile.length == 0) {
            return;
        }
        else {
            System.out.println("\n-------- Sorted File --------");

            for (int i = 0; i < sortedFile.length; i++) {
                System.out.println(" " + sortedFile[i] + "");
            }

            System.out.println("\n-------- End Of File --------");
        }
    }

    public void saveTheFile()
    {
        writeTableToText(dataFromText, "SORTED_OUTPUT_" + dataFileName);

        dataFileName = null;
        dataFromText = null;
        instructionsFromUser = null;
        startSort();
    }
/**
 * Method call to write the unsorted or sorted data to text file.
 * @param dataFile pass the sorted or unsorted String array.
 * @param fileOutName  pass the file output name.
 * @throws fnfe, FileNotFoundException if the file output name is invalid.
 */
public static void writeTableToText(String[] dataFile, String fileOutName) {
        if (dataFile == null || fileOutName == null) {
            return;
        }

        try {
            PrintWriter writer = new PrintWriter(fileOutName);
            int tableSize = dataFile.length;
            System.out.println("\n\t\t------WRITING TABLE SIZE: " + tableSize + " to " + fileOutName);
            for (int i = 0; i < dataFile.length; i++) {

                writer.println(dataFile[i]);
            }

            writer.close();

        } catch (FileNotFoundException fnfe) {
        }

    }
}
