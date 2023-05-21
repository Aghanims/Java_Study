package CSC201.UnitSix;

//Problem#2 combined with Problem#3
public class ShuffleCipher implements MessageEncoder, MessageDecoder
{
    private int shuffles;
    
    public ShuffleCipher(int n) 
    {
        shuffles = n;
    }
    
    public String encode(String plainText)
    {
        String word = plainText;

        for(int index  =0; index < shuffles; index++)
            word = shuffle(word);

        return word;
    }
    
    private String shuffle(String word)
    {
        String shuffled = "";
        
        int mid = word.length() / 2;
        String first = word.substring(0, mid);
        String second = word.substring(mid, word.length());
        
        for(int i = 0; i < first.length(); i++)
        {
            shuffled = shuffled + first.charAt(i) + second.charAt(i);
        }
        
        //If the length of the message is odd; add in the last character
        if(second.length() > first.length())
            shuffled = shuffled + second.charAt(second.length()-1);
        
        return shuffled;
    }

    //Problem#3
    public String decode(String cipherText)
    {
        String plainText = cipherText;

        for(int index = 0; index < shuffles; index++)
            plainText = unshuffle(plainText);

        return plainText;
    }

    //preliminary step for to be use for decode()
    private String unshuffle(String cipherText)
    {
        String unshuffled = "";
        
        for(int index = 0; index < cipherText.length(); index += 2)
            unshuffled = unshuffled + cipherText.charAt(index);
        for(int index = 1; index < cipherText.length(); index += 2)
            unshuffled = unshuffled + cipherText.charAt(index);

        return unshuffled;
    }

    //test
    public static void main(String[] args)
    {
        ShuffleCipher s = new ShuffleCipher(5);

        System.out.println("From : Richmond");
        System.out.println("To : " + s.encode("Richmond"));
        System.out.println("Decoded Cipher: " + s.decode(s.encode("Richmond")));
    }

    
}
