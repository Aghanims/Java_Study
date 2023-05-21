package CSC201.UnitSix;

//Problem#2 combined with problem#3
public class SubstitutionCipher implements MessageEncoder, MessageDecoder
{
    private int shift;
    private char[] alphabets = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public SubstitutionCipher(int shift)
    {
        this.shift = shift;
    }

    public int getShift() 
    {
        return shift;
    }

    public void setShift(int shift)
    {
        this.shift = shift;
    }

    public String encode(String plainText) 
    {
        StringBuilder combine = new StringBuilder();
        int alphabetLocation = 0;
        plainText.toLowerCase();
        for(int index = 0; index < plainText.length(); index++)
        {
            for(int alphabetIndex = 0; alphabetIndex < alphabets.length; alphabetIndex++)
            {
                if(plainText.charAt(index) == alphabets[alphabetIndex])
                    alphabetLocation = alphabetIndex;
            }

            combine.append(alphabets[alphabetLocation + shift]);
        }    

        return combine.toString();
    }

    //Problem#3
    public String decode(String cipherText)
    {
        StringBuilder decode = new StringBuilder();
        cipherText.toLowerCase();
        int letterIndexFinder = 0;

        for(int index = 0; index < cipherText.length(); index++)
        {
            for(int alphabetIndex = 0;  alphabetIndex < alphabets.length; alphabetIndex++)
            {
                if(cipherText.charAt(index) == alphabets[alphabetIndex])
                    letterIndexFinder = alphabetIndex;   
            }

            decode.append(alphabets[letterIndexFinder - shift]);
        }
        return decode.toString();
    }

    //test
    public static void main(String[] args) 
    {
        SubstitutionCipher a = new SubstitutionCipher(3);

        System.out.println("From: richmond");
        System.out.println("To: " + a.encode("richmond"));
        System.out.println("Cipher Decoded: " + a.decode(a.encode("richmond")));
    }

    

}
