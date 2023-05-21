package CSC201.ExtraCreditCipher;

/*
	Program:	Encryption.java
	Date:		03.24.2022
	Scope:		Test various classes that implement MessageEncoder interface


*/
public class Encryption
{
	public static void main(String[] args)
	{
		String message="travel";				//"It is never late to learn Java!";
		RotateCipher rc = new RotateCipher();
		String encoded="";
		String decoded="";
		System.out.println("Initial message \t: " + message);
		for(int i=0; i<5; i++)
		{
			rc = new RotateCipher();
			encoded=rc.encode(message);	//rc is the RotateCipher object
			System.out.println("Encoded message \t: " + encoded);
			decoded=rc.decode(encoded);
			System.out.println("Decoded message \t: " + decoded);

/*
			ShuffleCipher sc = new ShuffleCipher(3);
			sc.encode() <-- encode and decode are from ShuffleCipher not another one
			sc.decode()	<--
			Java does dynamic biding -> take the type of object as it is instantiateed

*/
		}
	}



}