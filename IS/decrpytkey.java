class decrpytkey
{
    public static void main(String[]args)
    {
        String str = "XLILSYWIMWRSAJSVWEPIJSVJSYVQMPPMSRHSPPEVWMXMWASVXLQSVILYVVCFIJSVIXLIWIPPIVVIGIMZIWQSVISJJIVW";
        for(int key=1;key<=25;key++)
        {        
        String decrypted = "";
        for(int i = 0;i<str.length();i++)
        {
            int s = str.charAt(i);
            int c = ((((s - 65) - key + 26) % 26) + 65);
            char ch = (char)c;
            decrypted = decrypted + ch;
        }
        System.out.println("Sentence formed: "+decrypted+" For key "+key);
        }
    }
}