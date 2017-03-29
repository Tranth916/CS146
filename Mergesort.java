package CS146;
/**
 * Mergesort class.
 * @author tranth
 */
public class Mergesort extends Sort{
    /**
     * @param input pass the unsorted data in an unsorted String array.
     * @return return the sorted array.
     */
	public static String[] mSort(String[] input)
	{
                startTimer();
                mergesort(input);
                stopTimer();
                printElapsedTime("Mergesort"); 
                
		return input;
	}
        /**
         * @param unsortedData pass the unsorted array through recursively.
         *  
         */
	public static void mergesort(String[] unsortedData)
	{
		if(unsortedData.length > 1)
		{
			int endOfHead = unsortedData.length / 2;
			int lengthOfTail = unsortedData.length - (unsortedData.length/2);
			String[] head = new String[endOfHead];
			System.arraycopy(unsortedData, 0, head, 0, endOfHead);
			String[] tail = new String[lengthOfTail];
			System.arraycopy(unsortedData, endOfHead, tail, 0, lengthOfTail);
			mergesort(head);
			mergesort(tail);
			merge(head,tail,unsortedData);
		}
	}    
        /**
         * 
         * @param Head begin the merging sequence from the first index to mid index.
         * @param Tail begin the merging sequence from the mid index to the last index.
         * @param Original combine the sorted head array and tail array.
         */
	public static void merge(String[] Head, String[] Tail, String[] Original)
		{
			int headPointer = 0;
			int tailPointer = 0;
			int originalPointer = 0;
			while(headPointer < Head.length && tailPointer < Tail.length)
			{
					//Head < Tail
			if( compareTo( Head[headPointer] , Tail[tailPointer]) < 0)
					{
						Original[originalPointer] = Head[headPointer];
						originalPointer++;
						headPointer++;
					}
			//Head > Tail
			else if( compareTo( Head[headPointer], Tail[tailPointer]) > 0 )
					{
					Original[originalPointer] = Tail[tailPointer];
					tailPointer++;
					originalPointer++;
					}
			else if( compareTo(Head[headPointer], Tail[tailPointer]) == 0)
					{
					Original[originalPointer++] = Head[headPointer++];
					Original[originalPointer++] = Tail[tailPointer++];
					}
			}

		while(headPointer < Head.length && originalPointer < Original.length)
		{
			Original[originalPointer] = Head[headPointer];
			headPointer++;
			originalPointer++;
		}
		while(tailPointer < Tail.length && originalPointer < Original.length)
		{
			Original[originalPointer] = Tail[tailPointer];
			tailPointer++;
			originalPointer++;
		}
	}
}