class hill
{
    public static int [][]key = {{17,17,5},{21,18,21},{2,2,19}};
    public static int [][]inverse= new int[3][3];
    public static String plaintext = "PAYMOREMONEY";
    public static int [][]pT= new int[1][3]; 
    public static String cypher = "";
    public static String decrypted = "";
    public static int pos = 0;
    public static int poc = 0;
    public static void encrypt()
    {
        while(pos<plaintext.length())
        {
        int c[][] = new int[1][3];
        for(int i=0;i<3;i++)
        {
            int p = plaintext.charAt(pos)-65;
            pT[0][i]= p;
            pos++;
        }
        for(int i=0;i<1;i++)
        {
            for(int j=0;j<3;j++)
            {
                for(int k = 0;k<3;k++)
                {
                    c[i][j]= c[i][j]+(pT[i][k]*key[k][j]);
                }
            }
        }    
        for(int i=0;i<1;i++)
        {
            for(int j=0;j<3;j++)
            {
                c[i][j]= ((c[i][j]%26)+65);
                char ch = (char)c[i][j];
                cypher = cypher + ch;
            }
        }
    }
    }
    public static void inverse()
    {
        int det = key[0][0]*(key[1][1]*key[2][2]-key[1][2]*key[2][1]) -
          key[0][1]*(key[1][0]*key[2][2]-key[1][2]*key[2][0]) +
          key[0][2]*(key[1][0]*key[2][1]-key[1][1]*key[2][0]);

        det = (det % 26 + 26) % 26; 

        int invDet = 0;
        for(int i = 0; i < 26; i++) {
            if((det * i) % 26 == 1) {
            invDet = i;
            break;
            }
            }
            if (invDet == 0) {
                return;
            }

        inverse[0][0] = ((invDet * (key[1][1]*key[2][2] - key[1][2]*key[2][1])) % 26 + 26) % 26;
        inverse[0][1] = ((invDet * (key[0][2]*key[2][1] - key[0][1]*key[2][2])) % 26 + 26) % 26;
        inverse[0][2] = ((invDet * (key[0][1]*key[1][2] - key[0][2]*key[1][1])) % 26 + 26) % 26;

        inverse[1][0] = ((invDet * (key[1][2]*key[2][0] - key[1][0]*key[2][2])) % 26 + 26) % 26;
        inverse[1][1] = ((invDet * (key[0][0]*key[2][2] - key[0][2]*key[2][0])) % 26 + 26) % 26;
        inverse[1][2] = ((invDet * (key[0][2]*key[1][0] - key[0][0]*key[1][2])) % 26 + 26) % 26;

        inverse[2][0] = ((invDet * (key[1][0]*key[2][1] - key[1][1]*key[2][0])) % 26 + 26) % 26;
        inverse[2][1] = ((invDet * (key[0][1]*key[2][0] - key[0][0]*key[2][1])) % 26 + 26) % 26;
        inverse[2][2] = ((invDet * (key[0][0]*key[1][1] - key[0][1]*key[1][0])) % 26 + 26) % 26;
        System.out.println("Inverse matrix is : ");
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                System.out.print(inverse[i][j] + " ");
            }
            System.out.println();
        }

    }
     public static void decrypt()
    {
        inverse();
        while(poc<cypher.length())
        {
        int c[][] = new int[1][3];
        for(int i=0;i<3;i++)
        {
            int p = cypher.charAt(poc)-65;
            pT[0][i]= p;
            poc++;
        }
        for(int i=0;i<1;i++)
        {
            for(int j=0;j<3;j++)
            {
                for(int k = 0;k<3;k++)
                {
                    c[i][j]= c[i][j]+(pT[i][k]*inverse[k][j]);
                }
            }
        }    
        for(int i=0;i<1;i++)
        {
            for(int j=0;j<3;j++)
            {
                c[i][j]= ((c[i][j]%26)+65);
                char ch = (char)c[i][j];
                decrypted = decrypted + ch;
            }
        }
    }
    }
    public static void main(String[]args)
    {
        encrypt();
        System.out.println("Encrypted message is : "+cypher);
        decrypt();
        System.out.println("Decrypted message is : "+decrypted);
    }
}