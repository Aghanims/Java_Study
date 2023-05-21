package CSC201.ExtraCreditCipher;

/*
	Program:	FindValueInArray.java
	Date:		03.24.2020
	Scope:		isMember Method Write a recursive boolean method named isMember.

				The 	method should search an array for a specified value, and return true if the value is found in the array, or false if the value is not found in the array.

				Demonstrate the method in a program.

				int a[] = new int[size]
				look in a of size
					look in a of size-1
						look in a of size-2
							... until a has size 1 and I compare with that value
Arguments:
	value we try to find
	array in which we are looking
	size of the array in which we are looking

	Find the maximum element in the array, building a recursive method named maxElement
	that solves the problem
*/

public class FindValueInArray
{
	public static void main(String[] args)
	{
		int array[] = {1,3,5,7,9,11,35,20,25,28,30};
		int size=array.length;
		int n;
		for(int i=0; i<10;i++)
		{
			n=(int)(Math.random()*30+1);
			if(isMember(array, n, size))
				System.out.println("Random number " + n + " is among values of array");
			else
				System.out.println("Random number " + n + " is not in the array");
		}

		System.out.println("Maximum element in the array is " + maxElement(array, 0));
		int max=array[0];
		for(int i=1; i< size; i++)
			if(array[i]>max)
				max=array[i];
		System.out.println("Max element in iterative  way is: " + max);
	}


	public static boolean isMember(int[] array, int value, int size)
	{
		//base case	- size of array is zero
		if(size==0)
			return false;
		else
			if(array[size-1]==value)
				return true;
			else
				return isMember(array, value, size-1);
	}

	public static int maxElement(int[] array, int start)
	{
		int max;
		//base case - when array has only one element
		// if start is the last possible index in the array, I search no more,
		// I return that particular value of the array as the maximum value
		if(start==(array.length-1))
				return array[start];
		// formula - reduce the search by advancing with the start point.
		else
		{
			// max is maximum of array elements starting at value start +1
			// look for max in the rest of array, and I find a value
			max=maxElement(array,start+1);
			// find a max, and compare it with the element at value start
			if(array[start]>max)// compare the maximum found with the current value
				return array[start];// if current value is bigger, I return it as max
			else
				return max;//otherwise, max is the maximum, and I return it

		}
	}



}