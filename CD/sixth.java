import java.util.Scanner;
class sixth
{
    public static String input;
    public static char currChar;
    public static int currIndex = 0;
    public static void S()
    {
        if(currChar == '(')
        {
            currIndex++;
            currChar = input.charAt(currIndex);
            L();
            if(currChar == ')')
            {
                currIndex++;
                if(currIndex < input.length())
                {
                    currChar = input.charAt(currIndex);
                }
            }
            else
            {
                System.out.println("Error");
            }
        }
        else if(currChar == 'a')
        {
            currIndex++;
            currChar = input.charAt(currIndex);
        }
        else
        {
            System.out.println("Error");
        }
    }
   
    public static void LPrime()
    {
        if(currChar == ',')
        {
            currIndex++;
            currChar = input.charAt(currIndex);
            S();
            LPrime();
        }
    }
    public static void L()
    {
        S();
        LPrime();
    }
   
    public static void main(String args[])
    {
        while(true)
        {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the input string: ");
        input = sc.nextLine();
        currChar = input.charAt(currIndex);
        S();
        if(currChar == input.charAt(input.length() - 1))
        {
            System.out.println("Input string " + input + " is valid");
            currIndex = 0;
        }
        else
        {
            System.out.println("Input string " + input + " is invalid");
            currIndex = 0;
        }
        }
    }
}