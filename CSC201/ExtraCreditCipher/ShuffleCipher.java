package CSC201.ExtraCreditCipher;

public class ShuffleCipher implements MessageEncoder, MessageDecoder 
{
    
    private int shufflesToDo;
    
    public static void main(String[] args)
    {
        ShuffleCipher s = new ShuffleCipher(5);

        System.out.println(s.encode("Richmond"));
        System.out.println(s.decode(s.encode("Richmond")));

    }
    
    public ShuffleCipher(int n) {
        shufflesToDo = n;
    }
    
    public String encode(String plainText)
    {
        String cipherText = plainText;

        for(int i=0; i<shufflesToDo; i++)
            cipherText = shuffle(cipherText);

        return cipherText;
    }
    
    private String shuffle(String s)
    {
        String shuffled = "";
        
        int mid = s.length()/2;
        String first = s.substring(0, mid);
        String second = s.substring(mid, s.length());
        
        //System.out.println("First: " + first);
        //System.out.println("Second: " + second);
        
        for(int i = 0; i < first.length(); i++)
        {
            shuffled = shuffled + first.charAt(i) + second.charAt(i);
        }
        
        //If the length of the message is odd; add in the last character
        if(second.length() > first.length())
            shuffled = shuffled + second.charAt(second.length()-1);
        
        return shuffled;
    }
    
    public String decode(String cipherText)
    {
        String plainText = cipherText;

        for(int i=0; i<shufflesToDo; i++)
            plainText = unshuffle(plainText);

        return plainText;
    }
    
    private String unshuffle(String s)
    {
        String unshuffled = "";
        
        for(int i=0; i < s.length(); i+=2)
            unshuffled = unshuffled + s.charAt(i);
        for(int i=1; i < s.length(); i+=2)
            unshuffled = unshuffled + s.charAt(i);
        return unshuffled;
    }
}
