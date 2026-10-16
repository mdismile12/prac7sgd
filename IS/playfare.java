class playfare
{
    public static String key = "PASCAL";
    public static String plaintext = "PASCL";
    public static int length = plaintext.length();
    public static int sind = 0;
    public static String[][] matrix = {
        {"P", "A", "S", "C", "L"},
        {"B", "D", "E", "F", "G"},
        {"H", "I/J", "K", "M", "N"},
        {"O", "Q", "R", "T", "U"},
        {"V", "W", "X", "Y", "Z"}
    };
    public static String Ct(String actaulPT)
    {
        sind = 0;

        String ctext = "";

        while(sind < actaulPT.length())
        {
            String arr[] = new String[2];
            for(int i = 0; i < 2; i++)
            {
                arr[i] = String.valueOf(actaulPT.charAt(sind));
                sind++;
            }
            System.out.print("Blocks : arr[0]: " + arr[0]+" arr[1]: " + arr[1]);
            System.out.println("");
            
            int r1 = 0;
            int c1 = 0;

            int r2 = 0;
            int c2 = 0;

            for(int i = 0; i < 5; i++)
            {
                for(int j = 0; j < 5; j++)
                {
                    String current = matrix[i][j];
                    if(current.equals("I/J"))
                    {
                        if(arr[0].equals("I") || arr[0].equals("J"))
                        {
                            r1 = i;
                            c1 = j;
                        }

                        if(arr[1].equals("I") || arr[1].equals("J"))
                        {
                            r2 = i;
                            c2 = j;
                        }
                    }
                    else
                    {
                        if(current.equals(arr[0]))
                        {
                            r1 = i;
                            c1 = j;
                        }

                        if(current.equals(arr[1]))
                        {
                            r2 = i;
                            c2 = j;
                        }
                    }
                }
            }
            if(r1 == r2)
            {
                c1 = (c1 + 1) % 5;
                c2 = (c2 + 1) % 5;
                ctext = ctext + matrix[r1][c1];
                ctext = ctext + matrix[r2][c2];
            }
            else if(c1 == c2)
            {
                r1 = (r1 + 1) % 5;
                r2 = (r2 + 1) % 5;

                ctext = ctext + matrix[r1][c1];
                ctext = ctext + matrix[r2][c2];
            }
            else
            {
                ctext = ctext + matrix[r1][c2];
                ctext = ctext + matrix[r2][c1];
            }
        }
        return ctext;
    }
    public static String At(String Ct)
    {
        // Reset index every time encryption starts
        sind = 0;

        String ptext = "";

        while(sind < Ct.length())
        {
            String arr[] = new String[2];
            for(int i = 0; i < 2; i++)
            {
                arr[i] = String.valueOf(Ct.charAt(sind));
                sind++;
            }
            System.out.print("Blocks : arr[0]: " + arr[0]+" arr[1]: " + arr[1]);
            System.out.println("");
            
            int r1 = 0;
            int c1 = 0;

            int r2 = 0;
            int c2 = 0;

            for(int i = 0; i < 5; i++)
            {
                for(int j = 0; j < 5; j++)
                {
                    String current = matrix[i][j];
                    if(current.equals("I/J"))
                    {
                        if(arr[0].equals("I") || arr[0].equals("J"))
                        {
                            r1 = i;
                            c1 = j;
                        }

                        if(arr[1].equals("I") || arr[1].equals("J"))
                        {
                            r2 = i;
                            c2 = j;
                        }
                    }
                    else
                    {
                        if(current.equals(arr[0]))
                        {
                            r1 = i;
                            c1 = j;
                        }

                        if(current.equals(arr[1]))
                        {
                            r2 = i;
                            c2 = j;
                        }
                    }
                }
            }
            if(r1 == r2)
            {
                c1 = (c1 - 1 + 5) % 5;
                c2 = (c2 - 1 + 5) % 5;
                ptext = ptext + matrix[r1][c1];
                ptext = ptext + matrix[r2][c2];
            }
            else if(c1 == c2)
            {
                r1 = (r1 - 1 + 5) % 5;
                r2 = (r2 - 1 + 5) % 5;

                ptext = ptext + matrix[r1][c1];
                ptext = ptext + matrix[r2][c2];
            }
            else
            {
                ptext = ptext + matrix[r1][c2];
                ptext = ptext + matrix[r2][c1];
            }
        }
        return ptext;
    }
    public static String encrypt()
    {
        String ciphertext = "";
        String actaulPT = "";

        int i = 0;

        while(i < plaintext.length())
        {
            if(i == plaintext.length() - 1)
            {
                actaulPT = actaulPT + plaintext.charAt(i);
                actaulPT = actaulPT + "X";
                i++;
            }
            else if(plaintext.charAt(i) == plaintext.charAt(i + 1))
            {
                actaulPT = actaulPT + plaintext.charAt(i);
                actaulPT = actaulPT + "X";
                i++;
            }
            else
            {
                actaulPT = actaulPT + plaintext.charAt(i);
                actaulPT = actaulPT + plaintext.charAt(i + 1);
                i = i + 2;
            }
        }
        ciphertext = Ct(actaulPT);
        return ciphertext;
    }
    public static String decrypt(String dcr)
    {
        String plainT = At(dcr);
        int i = 0;
        String actaulPT = "";
        while(i < plainT.length())
        {
            if(i == plainT.length() - 1)
            {
                if(plainT.charAt(i) == 'X')
                {
                    actaulPT = actaulPT + "";
                    
                }
                else
                {
                    actaulPT = actaulPT + plainT.charAt(i);
                }
                i++;
            }
            else if(plainT.charAt(i) == 'X')
            {
                actaulPT = actaulPT + "";
                i++;
            }
            else
            {
                actaulPT = actaulPT + plainT.charAt(i);
                i = i + 1;
            }
        }
        return actaulPT;
    }
    public static void main(String[] args)
    {
        String encstr = encrypt();
        System.out.println("Ciphertext: " + encstr);
        String dcrstr = decrypt(encstr);
        System.out.println("Decrypted plain text: "+dcrstr);
    }
}