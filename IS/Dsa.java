import java.math.BigInteger;

class Dsa {
    // DSA Parameters: p (prime), q (prime divisor of p-1), g (generator)
    public static BigInteger p = new BigInteger("23");
    public static BigInteger q = new BigInteger("11");
    public static BigInteger g = new BigInteger("4");

    // Private key x and Public key y
    public static BigInteger x = new BigInteger("7");
    public static BigInteger y;

    // Per-message random key k and Message Hash (HM)
    public static BigInteger k = new BigInteger("3");
    public static BigInteger HM = new BigInteger("9");

    // Signature components (r, s)
    public static BigInteger r;
    public static BigInteger s;

    // Key Generation: y = g^x mod p
    public static void generateKeys() {
        y = g.modPow(x, p);
    }

    // Signing: r = (g^k mod p) mod q, s = (k^-1 * (HM + x*r)) mod q
    public static void sign() {
        r = g.modPow(k, p).mod(q);

        BigInteger kInv = k.modInverse(q);
        BigInteger xr = x.multiply(r);
        BigInteger msgPlusXr = HM.add(xr);

        s = kInv.multiply(msgPlusXr).mod(q);
    }

    // Verification: v = ((g^u1 * y^u2) mod p) mod q
    public static boolean verify() {
        BigInteger w = s.modInverse(q);
        BigInteger u1 = HM.multiply(w).mod(q);
        BigInteger u2 = r.multiply(w).mod(q);

        BigInteger gu1 = g.modPow(u1, p);
        BigInteger yu2 = y.modPow(u2, p);
        BigInteger v = gu1.multiply(yu2).mod(p).mod(q);

        return v.equals(r);
    }

    public static void main(String[] args) {
        generateKeys();
        sign();

        System.out.println("p : " + p);
        System.out.println("q : " + q);
        System.out.println("g : " + g);
        System.out.println("Private Key (x)  : " + x);
        System.out.println("Public Key (y)   : " + y);
        System.out.println("Message Hash (HM): " + HM);
        System.out.println("Signature (r)    : " + r);
        System.out.println("Signature (s)    : " + s);

        boolean isValid = verify();
        if (isValid) {
            System.out.println("Signature Verification : SUCCESS");
        } else {
            System.out.println("Signature Verification : FAILED");
        }
    }
}
