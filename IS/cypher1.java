import java.util.*;
class cypher1
{
    public static String encrypt(String str)
    {
        int key = 15;
        String cypher = "";
        for(int i = 0;i<str.length();i++)
        {
            int s = str.charAt(i);
            int c = (((s-65)+key)%26)+65;
            char ch = (char)c;
            cypher = cypher + ch;
        }
        return cypher;
    }
    public static String decrypt(String str)
    {
        
        int key = 15;
        String decrypted = "";
        for(int i = 0;i<str.length();i++)
        {
            int s = str.charAt(i);
            int c = ((((s - 65) - key + 26) % 26) + 65);
            char ch = (char)c;
            decrypted = decrypted + ch;
        }
        return decrypted;
    }
    public static void main(String[]args)
    {
       String str = "HELLO";
       System.out.println("Original message:- "+str);
       String encryp = encrypt(str);
       System.out.println("Encrypted message:- "+encryp);
       String decryp = decrypt(encryp);
       System.out.println("Decrypted message:- "+decryp);
    }
}