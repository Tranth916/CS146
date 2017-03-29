package CS146;
/**
 * Class Insertionsort
 * @author tranth
 */
public class Insertionsort extends Sort{
    /**
     * Method called to begin the insertion sort sequence.
     * @param dataFile pass the unsorted data in as a String array.
     * @return returns the sorted data as a string array.
     */
    public static String[] iSort(String[] dataFile)
    {
      
        startTimer();
        insertionsort(dataFile);
        stopTimer();
        printElapsedTime("Insertionsort");
        return dataFile;
    }
    public static String[] insertionsort(String[] dataFile) {
        for (int i = 1; i < dataFile.length; i++) {
            String currentKey = dataFile[i];
            int j = (i-1);
            for (j = i - 1; (j >= 0 && compareTo(dataFile[j], currentKey) > 0); j--) {
                dataFile[j + 1] = dataFile[j];
            }
            dataFile[j + 1] = currentKey;
        }
        return dataFile;
    }

}
