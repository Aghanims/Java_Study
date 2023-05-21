package CSC201.ExtraCreditCipher;

/*
	Program:	RotateCipher.java
	Scope:		implements the interface, where the encoded message will have the characters shiftted randomly either right or left by a number of characters with possible values between 2 and 10.
Encoding example
		shift=2
		travel			travel
		012345			012345
	->	  trav		<-  avel
		el					tr

Decoding
		eltrav
		012345
	<-	trav
		    el
*/
public class RotateCipher implements MessageEncoder, MessageDecoder
{
	// instace variables
	private int shift;
	private int direction;

	// constructor
	public RotateCipher()
	{
		shift=(int)(Math.random()*9+2);	// [0,1)->[0,9)->[2,11)
		direction=(int)(Math.random()*2);	// {0,1}
		// 0 for right and 1 for left
	}

	public String encode(String plainText)
	{
		//shift=(int)(Math.random()*9+2);	// [0,1)->[0,9)->[2,11) done in constructor
		//direction=(int)(Math.random()*2);	// {0,1}
		//direction=1;
		String encoded=" ";
		int len=plainText.length();
		// normalize shift so it is smaller than length of string
		// if normalized shift is 0 or 1, bring to minimum value 2
		if(shift>len)
		{
			shift=shift%len;	// retain the remainder of integer division
			if(shift==0 || shift==1)
				shift=2;	// bring it to acceptable minimum value
		}
		System.out.println("Shift is: " + shift);
		System.out.println("Direction is: " + (direction==0?"right":"left"));
		if(direction==0)	// shift right
			encoded=plainText.substring(len-shift)+plainText.substring(0,len-shift);
		else				// shift left
			encoded = plainText.substring(shift)+plainText.substring(0,shift);

		return encoded;
	}

	public String decode(String encoded)
	{
		String message="";
		int len=encoded.length();
		// normalize shift so it is smaller than length of string
		// if normalized shift is 0 or 1, bring to minimum value 2
		if(shift>=len)
		{
			shift=shift%len;	// retain the remainder of integer division
			if(shift==0 || shift==1)
				shift=2;	// bring it to acceptable minimum value
		}
		if(direction==0)		//decode an encoded message with shift right
			message=encoded.substring(shift)+encoded.substring(0,shift);
		else
			message=encoded.substring(len-shift)+encoded.substring(0,len-shift);

		return message;
	}

}