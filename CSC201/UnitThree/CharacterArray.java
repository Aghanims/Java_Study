package CSC201.UnitThree;
//Unit#3.Problem#5
//Algorithm
/*
    •	Create a class called CharacterArray. 
    •	The scanner class is not required. Initialize the character array with the given string. 
    •	Write a program which will accept an alpha numeric string at the keyboard. 
    •	Store the string, of any length, into a character array, for example: 
            NVCC Manassas Campus 6901 Sudley Road Manassas VA 20109 
    •	For each visible character: 
        •	Display the original character
        •	Determine and display whether the character is a digit or a letter
        •	If the character is a lower case letter, redisplay the character in upper case
        •	If the character is a upper case letter, redisplay the character in lower case
        •	If the character is a digit, display it as an * (asterisk)

*/
public class CharacterArray 
{
    private String string;
    private char[]  intoChar;

    public CharacterArray()
    {
        this(null);
    }
    public CharacterArray(String string)
    {
        this.string = string;
    }
    
    public String getString()
    {
        return string;
    }

    public void StringIntoChar()
    {
        String withOutSpace = string.replaceAll(" ", "");
        intoChar = new char[withOutSpace.length()];

        for(int index = 0; index < withOutSpace.length(); index++)
        {
            intoChar[index] = withOutSpace.charAt(index);

            if(Character.isDigit(withOutSpace.charAt(index)))
                System.out.println(intoChar[index] + " is a digit");
            else
                System.out.println(intoChar[index] + " is a letter");    
        }
        System.out.println();

        char modifier;
        System.out.println("Changing lowercase into uppercase, and vice versa: ");
        for(int index = 0; index < withOutSpace.length(); index++)
        {
            if(Character.isLetter(withOutSpace.charAt(index)))
            {
                if(Character.isLowerCase(withOutSpace.charAt(index)))
                {
                    modifier = Character.toUpperCase(withOutSpace.charAt(index));
                    System.out.println(modifier);
                }
                else if(Character.isUpperCase(withOutSpace.charAt(index)))
                {
                    modifier = Character.toLowerCase(withOutSpace.charAt(index));
                    System.out.println(modifier);
                }
            }
            else
                System.out.println("*");
           
        }
    }

    public static void main(String[] args) 
    {
        CharacterArray mod1 = new CharacterArray("Hi I am Richmond 72");

        mod1.StringIntoChar();
    }    
}
