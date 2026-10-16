class vegener
{
    public static String key = "PASCAL";
    public static String plaintext = "SHEISGOOD";
    public static String actKey = "";
    public static String cypher = "";
    public static String decrypted = "";
    public static void encrypt()
    {
        for(int i=0;i<plaintext.length();i++)
        {
            int k = (actKey.charAt(i)-65);
            int p = (plaintext.charAt(i)-65);
            int c = (p+k)%26;
            int ct = c+65;
            char ch = (char)ct;
            cypher = cypher+ch;
        }
    }
    public static void decrypt()
    {
        for(int i = 0;i<cypher.length();i++)
        {
            int s = cypher.charAt(i);
            int k = actKey.charAt(i);
            int c = (s-k+26)%26;
            c = c+65;
            char ch = (char)c;
            decrypted = decrypted + ch;
        }
    }
    public static void main(String[]args)
    {
        for(int i=0;i<plaintext.length();i++)
        {
            int pos = i%6;
            actKey = actKey+key.charAt(pos);
        }
        System.out.println("Actual key "+actKey);
        encrypt();
        System.out.println("Encrypted message is : "+cypher);
        decrypt();
        System.out.println("Decrypted message is : "+decrypted);
    }
}