package CS146;
public class Sort{
    public static void main(String[] args)
    {
        /*
        Call constructor to initialize the sort controller.
        Constructor starts the program's loop.
        */
        SortController sort = new SortController();        
    }
    
    private static long startTime;
    private static long stopTime;
    
    /**
     * 
     * @param firstNum first integer to compare.
     * @param secondNum second integer to compare.
     * @return returns 1 if first > second, 0 if equal, -1 if first < second.
     */
    public static int compareTo(int firstNum, int secondNum)
    {
        return Integer.compare(firstNum, secondNum);
    }
  
    /**
     * 
     * @param str1 String value of the first. First integer will be parsed from the string.
     * @param str2 String value of the second. Second integer will be parsed from the string.
     * @return  returns 1 if Parsed integer from str1 > str2, 0 if equal, -1 if str1 < str2
     */
    public static int compareTo(String str1 ,String str2)
	{
			String first = String.valueOf(str1);
			String second = String.valueOf(str2);
                        /*
                        Split each string by regex. "\\s+" will separate each
                        by the space character.
                        */
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
    /**
     * Initializes the start time.
     */
    public static void startTimer()
    {
        startTime = System.nanoTime();
        System.out.println("##### Start time: " + startTime);    
    }
    /**
     * Initializes the stop time.
     */
    public static void stopTimer()
    {
        stopTime = System.nanoTime();
        System.out.println("##### Stop time:  " + stopTime);
    }
    /**
     * @param SortMethod pass the string value of which method was called.
     */
    public static void printElapsedTime(String SortMethod)
    {    
        long totalTime = (long) ((stopTime-startTime) * Math.pow(10.0, -6));
        
        System.out.println("\n\t ### Took : " + totalTime + " Milliseconds using " + SortMethod);
	
        startTime = 0;
        stopTime = 0;   
    }
    
}