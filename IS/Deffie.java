class Deffie
{
    public static int Xa=3;
    public static int Xb=4;
    public static int q=7;
    public static int alpha;
    public static int Ya;
    public static int Yb;
    public static int SharedKeyA;
    public static int SharedKeyB;
    public static void cal_alpha()
    {
        int temp = 2;
int[] arr = new int[q - 1];

while (true) {

    int value = 1;
    boolean isPrimitiveRoot = true;

    for (int i = 0; i < q - 1; i++) {
        value = (value * temp) % q;
        // Check whether value already exists
        for (int j = 0; j < i; j++) {
            if (arr[j] == value) {
                isPrimitiveRoot = false;
                break;
            }
        }
        if (!isPrimitiveRoot)
            break;
        arr[i] = value;
    }
    if (isPrimitiveRoot) {
        alpha = temp;
        break;
    }
    temp++;
}
    }
    public static void cal_Ya()
    {
        Ya = (int) ((Math.pow(alpha,Xa))%q);
    }
    public static void cal_Yb()
    {
        Yb = (int) ((Math.pow(alpha,Xb))%q);
    }
    public static void cal_SharedKey()
    {
        SharedKeyA = (int) ((Math.pow(Yb,Xa))%q);
        SharedKeyB = (int) ((Math.pow(Ya,Xb))%q);
    }
    public static void main(String[]args)
    {
        cal_alpha();
        cal_Ya();
        cal_Yb();
        cal_SharedKey();
        System.out.println("q is : "+q);
        System.out.println("alpha is : "+alpha);
        System.out.println("Xa is : "+Xa);
        System.out.println("Xb is : "+Xb);
        System.out.println("Ya is : "+Ya);
        System.out.println("Yb is : "+Yb);
        System.out.println("Shared Key A is : "+SharedKeyA);
        System.out.println("Shared Key B is : "+SharedKeyB);
        if(SharedKeyA==SharedKeyB)
        {
            System.out.println("Shared Key is same for both A and B");
        }
        else
        {
            System.out.println("Shared Key is not same for both A and B");
        }
    }
}