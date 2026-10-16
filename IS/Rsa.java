import java.util.*;
import java.math.BigInteger;
class Rsa
{
    public static int M = 2;
    public static int p = 3;
    public static int q = 11;
    public static int phi=(p-1)*(q-1);
    public static int n=p*q;
    public static int e;
    public static int d;
    public static int Ct;
    public static int De;
    public static void cal_e()
    {
        int temp=2;
        while(temp<phi)
        {
            int gcd = BigInteger.valueOf(temp).gcd(BigInteger.valueOf(phi)).intValue();
            if(gcd==1)
            {
                e=temp;
                break;
            }
            temp++;
        }
    }
    public static void cal_d()
    {
        int temp=2;
        while(true)
        {
            if((temp*e)%phi==1)
            {
                d=temp;
                break;
            }
            temp++;
        }
    }
    public static void encrypt()
    {
        Ct = (int) ((Math.pow(M,e))%n);
    }
    public static void decrypt()
    {
        De = (int) ((Math.pow(Ct,d))%n);

    }
    public static void main(String[]args)
    {
        cal_e();
        cal_d();
        System.out.println("p is : "+p);
        System.out.println("q is : "+q);
        System.out.println("n is : "+n);
        System.out.println("phi is : "+phi);
        System.out.println("e is : "+e);
        System.out.println("d is : "+d);
        System.out.println("Original message is: "+M);
        encrypt();
        System.out.println("Encrypted message is : "+Ct);
        decrypt();
        System.out.println("Decrypted message is : "+De);
    }
}