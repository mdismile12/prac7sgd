import java.util.*;
class Dfa1
{
    public static int dfa = 0;
    public static void isAccepted(String str)
    {
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='1')
            {
                dfa = 1;
                break;
            }
            else
            {
                continue;
            }
        }
    }
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter String: ");
        String str = input.nextLine();
        isAccepted(str);
        if(dfa == 1)
        {
            System.out.println("String is accepted");
        }
        else
        {
            System.out.println("String is not accepted");
        }
    }
}