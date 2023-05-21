package CSC201.ExtraCreditCipher;

/*
	Program:	RecursionExamples.java
	Date:		03.31.2022
	Scope:		Discuss recursion, and give examples of methods that can be implemented using recursion

	Recursive methods invoke themselves with other arguments that should conduct to a base case where return value is known.

	Conditions for recursion:
		* have a base case - a value of the recursion argument for which result is known
		* recursion formula - formula that connects current step in calculation from previous one.
	Additional caution on implementation so that the formula continues to be applied, facilitating the method invoking itself with different values

	NOTE: avoid infinite recursion
		- incorrect base case
		- algorithm that does not conduct to invoking base case
		- incorrect recursion formula - incorrect direction of applying recursion

	Examples:
	Calculate the following sum using both iterative and recursive methods.

	sum(n)=2+5+11+34+...
	Find the rule that builds this sum considering that:
	sum(1)=2=1+1=1!+1
	sum(2)=5=2+3=2!+(1+2)
	sum(3)=12=6+6=3!+(1+2+3)
	sum(4)=34=24+10=4!+(1+2+3+4)
	and so on ...
	sum(n)=n!+(1+2+...+n)
	Calculate sum in both iterative and recursive way.
	sum(n)=
			sum(n(n+1))
			sum((n-1)+2n)
			sum(n^(n-1)+n)
			sum(n+sum(n-1)+1)
			sum()+sum()

	Ackerman function:
		ackerman(m,n)= 		if m==0			--> ackerman(m,n)=n+1
							if n==0			--> ackerman(m,n)=ackerman(m-1,1)
							if n!=0, m!=0 	--> ackerman(m-1,ackerman(m,n-1)

	*/
	public class RecursionExamples
	{
		public static void main(String[] args)
		{
			// for n=7, calculate sum(n)=n!+(1+2+...n)
			int max=10;
			// iterative method -> perform one set of calculations and return result
			for(int n=1; n<=max; n++)
			{
				System.out.println("Result of iterative sum for n equals " + n + " is: " + iterativeFancySum(n));

				System.out.println("\tResult of recursive sum for n equals " + n + " is: " + recursiveFancySum(n));

			}
			int m=0;
			int n=100;
			System.out.println("Ackerman("+m+","+n+")="+ackerman(m,n));
			m=3;
			n=0;
			System.out.println("Ackerman("+m+","+n+")="+ackerman(m,n));
			m=5;
			n=4;
			System.out.println("Ackerman("+m+","+n+")="+ackerman(m,n));
		}

		//iterative method
		public static int iterativeFancySum(int n)
		{
			int sum=0;
			int prod=1;
/*
			for(int i=1; i<=n; i++)
				prod=prod*i;
			for(int i=1; i<=n; i++)
			{
				sum=sum+i;		// i=3 sum=(1+2)+3+6		6=3!
			}
*/
			for(int i=1; i<=n; i++)
			{
//				System.out.println("n="+i);
				prod=prod*i;
//				System.out.println("Prod="+prod);
				sum=sum+i;
//				System.out.println("Sum="+sum);
//				sum=sum+prod;
//				System.out.println("Partial result for n= " + i + " is: " +sum);
			}
			sum=sum+prod;
			return sum;
		}
		// recursive solution
		public static int recursiveFancySum(int n)
		{
			return sum(n)+factorial(n);
		}

		// calculates sum of natural numbers in recursive way
		public static int sum(int n)
		{
			if(n==1)		//base case
				return 1;
			return sum(n-1)+n;
		}

		// calculates factorial in recursive way
		public static int factorial(int n)
		{
			if(n==1)
				return 1;
			return factorial(n-1)*n;
		}

		public static int ackerman(int m, int n)
		{
			/*
					ackerman(m,n)= 		if m==0			--> ackerman(m,n)=n+1
										if n==0			--> ackerman(m,n)=ackerman(m-1,1)
										if n!=0, m!=0 	--> ackerman(m-1,ackerman(m,n-1)
			*/
			if(m==0)
				return n+1;
			if(n==0)
				return ackerman(m-1,1);
			return ackerman(m-1, ackerman(m,n-1));
			/*
				m=3, n=2	ackerman(2, ackerman(3,1))
										ackerman(2,0)
											ackerman(1,1)
												ackerman(0, ackerman(1,0))
			*/

		}

	}