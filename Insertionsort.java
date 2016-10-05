public class Insertionsort
{
	String[] dataFile;

	public Insertionsort()
	{
	}
	public Insertionsort(String[] input)
	{
		dataFile = input;
	}

	public String[] insertionsort(String[] data)
	{
		dataFile = data;

		long startTime = System.currentTimeMillis() % 1000;

		for(int i = 1; i < dataFile.length; i++)
		{
			int j = i - 1;

			String currentKey = dataFile[i];
			
			for( j = i-1 ; (j >= 0 && compareTo(dataFile[j],currentKey) > 0); j--)
			{
				dataFile[j+1] = dataFile[j];
			}

			dataFile[j+1] = currentKey;
		}

		long stopTime = System.currentTimeMillis() % 1000;
		
		System.out.println("\n\t ### Took : " + (stopTime - startTime) + " milliseconds to insertionsort. ###");
		
		return dataFile;

	}

	public int compareTo(String first, String second)
	{
		//String firstIndex = String.valueOf(first);
		//String secondIndex = String.valueOf(second);

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









}