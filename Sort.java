import java.util.Random;
import java.lang.*;
import java.io.*;
import java.util.*;

public class Sort
{
	public static void main(String[]args)
	{	
		

	}

public static String[] getCommand()
{
	System.out.print("Type in insertionsort data.txt\n");		

	Scanner inputCommand = new Scanner(System.in);
		
	String givenCommand = inputCommand.nextLine();

	if(givenCommand != null)
	{
		String[] splitCmd = givenCommand.split("\\s+");
		if(splitCmd[0].matches("insertionsort") || splitCmd[0].matches("mergesort"))
		{
			return splitCmd; 
		}
	}
	return null;public class mergesort<T>
{
void mergesort(T[] A)
	{
	//Basecase: Array length is 1.
	if(A.length > 1)
	{
		int endOfHead = A.length / 2;
		int lengthOfTail = A.length - (A.length/2);
		T[] head = (T[]) new Object[endOfHead];
		System.arraycopy(A, 0, head, 0, endOfHead);
		T[] tail = (T[]) new Object[lengthOfTail];
		System.arraycopy(A, endOfHead, tail, 0, lengthOfTail);
		mergesort(head);
		mergesort(tail);
		merge(head,tail,A);
	}
}

public int compareTo(T str1 ,T str2)
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


public void merge(T[] Head, T[] Tail, T[] Original)
{
	int aPointer = 0;
	int bPointer = 0;
	int cPointer = 0;
	while(aPointer < Head.length && bPointer < Tail.length)
		{
			//Head < Tail
			if( compareTo( Head[aPointer] , Tail[bPointer]) < 0)
			{
				Original[cPointer] = Head[aPointer];
				cPointer++;
				aPointer++;
			}
			//Head > Tail
			else if ( compareTo( Head[aPointer], Tail[bPointer]) > 0 )
			{
				Original[cPointer] = Tail[bPointer];
				bPointer++;
				cPointer++;
			}
			else if( compareTo(Head[aPointer], Tail[bPointer]) == 0)
			{
				Original[cPointer++] = Head[aPointer++];
				Original[cPointer++] = Tail[bPointer++];
			}

		}

	while(aPointer < Head.length && cPointer < Original.length)
	{
		Original[cPointer] = Head[aPointer];
		aPointer++;
		cPointer++;
	}
	while(bPointer < Tail.length && cPointer < Original.length)
	{
		Original[cPointer] = Tail[bPointer];
		bPointer++;
		cPointer++;
	}
}

}
