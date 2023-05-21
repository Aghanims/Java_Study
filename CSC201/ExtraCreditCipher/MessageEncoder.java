package CSC201.ExtraCreditCipher;

/*
	Program:	MessageEncoder.java
	Scope:		Design and implement an interfaceMessageEncoder that has a
				single abstract method encode(plainText), where plainText is the message to be encoded. The method will return the encoded message.
Create a class RotateCipher, that implements the interface, where the encoded message will have the characters shiftted randomly either right or left by a number of characters with possible values between 2 and 10.

Create a class SubstitutionCipher that implements the interface MessageEncoder. The constructor should have one parameter called shift. Define the method encode so that each letter is shifted by the value in shift. For example, if shift is 3, a will be replaced by d, b will be replaced by e, c will be replaced by f, and so on. (Hint: You may wish to define a private method that shifts a single character.)

Create a class ShuffleCipher that implements the interface MessageEncoder, as described in Exercise 15. The constructor should have one parameter called n. Define the method encode so that the message is shuffled n times. To perform one shuffle, split the message in half and then take characters from each half alternately. For example, if the message is abcdefghi, the halves are abcde and fghi. The shuffled message is afbgchdie. (Hint: You may wish to define a private method that performs one shuffle.)
*/
public interface MessageEncoder
{
	public String encode(String plainText);
}