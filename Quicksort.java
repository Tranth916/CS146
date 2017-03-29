package CS146;
/**
 * Class Quicksort
 * @author tranth
 */
public class Quicksort extends Sort{
    /**
     * 
     * @param input pass the String array with the data to be sorted.
     * @return returns an array with the sorted data.
     */
    public static String[] qSort(String[] input){
        startTimer();
        
        quicksort(input, 0, input.length - 1);
        
        stopTimer();
        printElapsedTime("Quicksort");
        return input;
    }
/**
 * 
 * @param data String array with the unsorted data to be sorted.
 * @param low Integer of the lower index of the unsorted data array.
 * @param high Integer of the higher index of the unsorted data array.
 */
    public static void quicksort(String[] data, int low, int high) {
        if (data.length == 0) {
            return;
        }
        if (low < high) {
            int partitionIndex = partition(data, low, high);

            if (low < partitionIndex - 1) {
                quicksort(data, low, partitionIndex - 1);
            }

            if (partitionIndex < high) {
                quicksort(data, partitionIndex, high);
            }
        }
    }
/**
 * 
 * @param data Pass the divided String array with reduced unsorted entries. 
 * @param low Pass the lower index which starts the lower sorted region.
 * @param high Pass the higher index which starts the higher sorted regions.
 * @return index of which index will be the partition.
 */
    public static int partition(String[] data, int low, int high) {
        int i = low;
        int j = high;
        String pivotString = data[(low + high) / 2];
        while (i <= j) {
            //Compare the pivotString against the low values of Data array.

            while (compareTo(pivotString, data[i]) > 0) {
                i++;
            }

            while (compareTo(pivotString, data[j]) < 0) {
                j--;
            }

            if (i <= j) {
                String swapData = data[i];
                data[i] = data[j];
                data[j] = swapData;
                i++;
                j--;
            }
        }
        return i;
    }

}
