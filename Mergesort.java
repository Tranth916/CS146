

public class Mergesort
{
	String[] dataFile;

	public Mergesort()
	{

	}
	public Mergesort(String[] input)
	{
		dataFile = input;
		mergesort(dataFile);
	}

	public String[] mSort(String[] input)
	{
		long startTime = System.currentTimeMillis() % 1000;
		dataFile = input;
		mergesort(dataFile);
		long stopTime = System.currentTimeMillis() % 1000;

		System.out.println("\n\t ### Took : " + (stopTime - startTime) + " milliseconds to mergesort. ###");
		return dataFile;
	}
	public String[] getFile()
	{
		return dataFile;
	}

	public void mergesort(String[] A)
	{
	//Basecase: Array length is 1.
		if(A.length > 1)
		{
			int endOfHead = A.length / 2;
			int lengthOfTail = A.length - (A.length/2);
			String[] head = new String[endOfHead];
			System.arraycopy(A, 0, head, 0, endOfHead);
			String[] tail = new String[lengthOfTail];
			System.arraycopy(A, endOfHead, tail, 0, lengthOfTail);
			mergesort(head);
			mergesort(tail);
			merge(head,tail,A);
		}
	}

	public int compareTo(String str1 ,String str2)
	{
			String first = String.valueOf(str1);
			String second = String.valueOf(str2);


			String[] spl1 = first.trim().split("\\s+");	
			String[] spl2 = second.trim().split("\\s+");
		try
		{	
				int strOne = Integer.parseInt(spl1[0]);
				int strTwo = Integer.parseInt(spl2[0]);

				if(strOne > strTwo)
				{
					return 1;
				}
				else if(strOne < strTwo)
				{
					return -1;
				}
				else if(strOne == strTwo)
				{
					return 0;
				}
		}
		catch(NumberFormatException e)
				{

				}
				return 0;
	}

	public void merge(String[] Head, String[] Tail, String[] Original)
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