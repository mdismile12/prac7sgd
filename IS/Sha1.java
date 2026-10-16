class Sha1 {
    public static String message = "Hello World";

    // Initial Hash Values (H0 to H4)
    public static int H0 = 0x67452301;
    public static int H1 = 0xEFCDAB89;
    public static int H2 = 0x98BADCFE;
    public static int H3 = 0x10325476;
    public static int H4 = 0xC3D2E1F0;

    public static String hashResult = "";

    // Circular left shift operation
    public static int leftRotate(int value, int count) {
        return (value << count) | (value >>> (32 - count));
    }

    // Step 1: Message Padding (512-bit alignment)
    public static byte[] padMessage(byte[] data) {
        long originalBitLength = (long) data.length * 8;
        int initialLength = data.length;

        int k = (56 - (initialLength + 1) % 64 + 64) % 64;
        int paddedLength = initialLength + 1 + k + 8;

        byte[] padded = new byte[paddedLength];

        for (int i = 0; i < initialLength; i++) {
            padded[i] = data[i];
        }

        // Append '1' bit (0x80)
        padded[initialLength] = (byte) 0x80;

        // Append 64-bit original length in bits
        for (int i = 0; i < 8; i++) {
            padded[paddedLength - 1 - i] = (byte) ((originalBitLength >>> (i * 8)) & 0xFF);
        }

        return padded;
    }

    // Step 2: Hash Computation over 512-bit blocks
    public static void computeHash() {
        byte[] data = message.getBytes();
        byte[] paddedData = padMessage(data);

        int numBlocks = paddedData.length / 64;

        for (int b = 0; b < numBlocks; b++) {
            int blockOffset = b * 64;
            int[] W = new int[80];

            // Break block into 16 32-bit words
            for (int t = 0; t < 16; t++) {
                int index = blockOffset + (t * 4);
                W[t] = ((paddedData[index] & 0xFF) << 24)
                     | ((paddedData[index + 1] & 0xFF) << 16)
                     | ((paddedData[index + 2] & 0xFF) << 8)
                     | (paddedData[index + 3] & 0xFF);
            }

            // Extend 16 words to 80 words
            for (int t = 16; t < 80; t++) {
                W[t] = leftRotate(W[t - 3] ^ W[t - 8] ^ W[t - 14] ^ W[t - 16], 1);
            }

            int A = H0;
            int B = H1;
            int C = H2;
            int D = H3;
            int E = H4;

            // 80 rounds processing
            for (int t = 0; t < 80; t++) {
                int F = 0;
                int K = 0;

                if (t <= 19) {
                    F = (B & C) | ((~B) & D);
                    K = 0x5A827999;
                } else if (t <= 39) {
                    F = B ^ C ^ D;
                    K = 0x6ED9EBA1;
                } else if (t <= 59) {
                    F = (B & C) | (B & D) | (C & D);
                    K = 0x8F1BBCDC;
                } else {
                    F = B ^ C ^ D;
                    K = 0xCA62C1D6;
                }

                int temp = leftRotate(A, 5) + F + E + K + W[t];
                E = D;
                D = C;
                C = leftRotate(B, 30);
                B = A;
                A = temp;
            }

            H0 += A;
            H1 += B;
            H2 += C;
            H3 += D;
            H4 += E;
        }

        hashResult = String.format("%08x%08x%08x%08x%08x", H0, H1, H2, H3, H4);
    }

    public static void main(String[] args) {
        computeHash();
        System.out.println("Input Message : " + message);
        System.out.println("SHA-1 Hash    : " + hashResult);
    }
}