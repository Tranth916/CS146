public class Quicksort
{
	private String[] dataArray;

	public Quicksort()
	{

	}

	public Quicksort(String[] data)
	{
		dataArray = data;
	}

	public String[] getData()
	{
		return dataArray;
	}

	public String[] quicksort()
	{
		quicksort(dataArray,0,dataArray.length);
		return dataArray;
	}

	public String[] quicksort(String[] data)
	{

		dataArray = data;
		quicksort(dataArray,0,dataArray.length);
		return dataArray;
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
			while(compareTo(pivotString, data[j])  < 0)
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