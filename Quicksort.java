public class Quicksort
{
	private String[] dataFile;

	public Quicksort()
	{

	}

	public Quicksort(String[] data)
	{
		dataFile = data;
	}

	public String[] getData()
	{
		return dataFile;
	}

	public String[] quicksort()
	{
		quicksort(dataFile,0,dataFile.length);
		return dataFile;
	}	
	public String[] qSort(String[] input)
	{	
		dataFile = input;	

		long startTime = System.currentTimeMillis();
		
		System.out.println("##### Start time: " + startTime);
		quicksort(dataFile,0,dataFile.length - 1);
		long stopTime = System.currentTimeMillis();
		System.out.println("##### Stop time: " + stopTime);

		System.out.println("\n\t ### Took : " + (stopTime - startTime)%1000 + " milliseconds to quicksort. ###");
		
		startTime = 0;
		stopTime = 0;

		return dataFile;
	}

	public String[] quicksort(String[] data)
	{

		dataFile = data;
		quicksort(dataFile, 0 , dataFile.length - 1);
		return dataFile;
	}

	public void quicksort(String[] data, int low, int high)
	{
		if (data.length == 0)
		{
			return;
		}
		if(low < high)
		{
			int partitionIndex = partition(data,low,high);
			
			if( low < partitionIndex - 1)
			quicksort(data,low,partitionIndex-1);
			
			if(partitionIndex < high)
			quicksort(data,partitionIndex, high);	
		}
	}
	
	public static int partition(String[] data, int low, int high)
	{

			int i = low;
			int j = high;
			String pivotString = data[ (low+high) / 2];
			while ( i <= j )
			{
				//Compare the pivotString against the low values of Data array.
			
				while( compareTo(pivotString , data[i]) > 0  )
				{
					i++;
				}

			while( compareTo(pivotString, data[j])  < 0 )
			{
				j--;
			}

			if(i <= j)
			{
				String swapData = data[i];
				data[i] = data[j];
				data[j] = swapData;	
				i++;
				j--;
			}
		}
		return i;
	}
	
	
	public static int compareTo( String first, String second)
	{
		String[] splitFirst = first.split("\\s+");
		String[] splitSecond = second.split("\\s+");
		
		int firstValue = Integer.parseInt(splitFirst[0]);
		int secondValue = Integer.parseInt(splitSecond[0]);
		
		if(firstValue < secondValue)
		{
			return -1;
		}
		if(firstValue > secondValue)
		{
			return 1;
		}
		
		return 0;
	}
}