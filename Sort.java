import java.util.Random;
import java.lang.*;

public class Sort
{
public static void main(String[]args)
	{	
		Random numberGenerator = new Random();

		int[] input = new int[10000];

		for(int i = 0; i < 10000; i++)
		{
			int n = numberGenerator.nextInt(10000);
			input[i] = n;
			//System.out.print(input[i] + " ");
		}

		long startTime = System.currentTimeMillis();
		//insertionSort(input);
		//mergesort(input);
		long endTime = System.currentTimeMillis();

		System.out.println();

		System.out.println("Started: " + startTime + "Ended: " + endTime +
							"Total Time to Complete: " + (endTime - startTime) );

	}

public static void insertionSort(int[] A)
	{
		//Assume index 0 is sorted.
		//Traverse the entire Array. From left to right.
		for(int i = 1; i < A.length; i++)
		{
			//Initialize j as the place to start.
			int j = i;
			//Initialize a Key which remembers the value in A[j].
			int currentKey = A[j];
			
			//traverse array in right to left using j.
			for(j = i - 1; (j >= 0 && A[j] > currentKey) ; j--)
			{
				//Finding a place to insert values greater than
				//Key that is currently on the left of key.
				if(A[j] > currentKey)
				{
					//Shift all values to the right until we find a place
					//To insert the current key.
					A[j+1] = A[j];
				}
			}
			//Place is found to insert key. 
			A[j+1] = currentKey;
		}

	}



//The helper method.
public static void mergesort(int[] A)
{
	//Basecase: Array length is 1.
	if(A.length > 1)
	{
		int endOfHead = A.length / 2;
		
		int lengthOfTail = A.length - (A.length/2);
		
		int[] head = new int[endOfHead];

		System.arraycopy(A, 0, head, 0, endOfHead);

		int[] tail = new int[lengthOfTail];

		System.arraycopy(A, endOfHead, tail, 0, lengthOfTail);

		mergesort(head);
		mergesort(tail);
		merge(head,tail,A);
	}

}

public static void merge(int[] A, int[] B, int[] C)
{

	int aPointer = 0;
	int bPointer = 0;
	int cPointer = 0;

	while(aPointer < A.length && bPointer < B.length)
		{
			if(A[aPointer] < B[bPointer])
			{
				C[cPointer] = A[aPointer];
				cPointer++;
				aPointer++;
			}
			else if (B[bPointer] < A[aPointer])
			{
				C[cPointer] = B[bPointer];
				bPointer++;
				cPointer++;
			}
		}

	while(aPointer < A.length && cPointer < C.length)
	{
		C[cPointer] = A[aPointer];
		aPointer++;
		cPointer++;
	}

	while(bPointer < B.length && cPointer < C.length)
	{
		C[cPointer] = B[bPointer];
		bPointer++;
		cPointer++;
	}

}

}