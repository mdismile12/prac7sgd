class Multicipher
{
   public static int key = 3;
      public static String encrypt(String str)
    {
        String cypher = "";
        for(int i = 0;i<str.length();i++)
        {
            int s = str.charAt(i);
            int c = ((s*key)%26)+65;
            char ch = (char)c;
            cypher = cypher + ch;
        }
        return cypher;
    }
    public static int inverse(int arr[])
    {
        for(int i = 0; i<arr.length;i++)
        {
            if(((arr[i]*key)%26)==1)
            {
                return arr[i];
            }
        }
        return 0; 
    }
    public static String decrypt(String str,int inverse)
    {
        String decrypted = "";
        for(int i = 0;i<str.length();i++)
        {
            int s = str.charAt(i);
            int c = ((s *  inverse) % 26)+65;
            char ch = (char)c;
            decrypted = decrypted + ch;
        }
        return decrypted;
    }
    public static void main(String[]args)
    {
        int arr[]={1,3,5,7,9,11,15,17,19,21,23,25};
        String str = "HELLOTHISISJAVA";
        String encryp = encrypt(str);
        int inverse = inverse(arr);
        System.out.println("Inverse is "+inverse);
        System.out.println("Encrypted message:- "+encryp);
        String decryp = decrypt(encryp,inverse);
        System.out.println("Decrypted message:- "+decryp);
    }
}