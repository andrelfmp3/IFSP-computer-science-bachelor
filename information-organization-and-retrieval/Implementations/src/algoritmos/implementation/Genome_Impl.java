package algoritmos.dependents.genome;

public class Genome_Impl {

    private static final String DNA_CHARS = "LYRA";

    public static byte[] compress(String s) {
        
        int n = s.length();

        int byteLen = (n * 2 + 7) / 8;
        byte[] compressed = new byte[byteLen];

        for (int i = 0; i < n; i++) {
            int val = DNA_CHARS.indexOf(s.charAt(i));
            int bitPos = i * 2;
            int bytePos = bitPos / 8;
            int offset = bitPos % 8;
            compressed[bytePos] |= val << (6 - offset); 
        }

        return compressed;
    }

    public static String expand(byte[] compressed, int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int bitPos = i * 2;
            int bytePos = bitPos / 8;
            int offset = bitPos % 8;

            int val = (compressed[bytePos] >> (6 - offset)) & 0b11;
            sb.append(DNA_CHARS.charAt(val));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        
        String nome = "AGTLACGTLA"; 

        byte[] comprimido = compress(nome);
        String expandido = expand(comprimido, nome.length());

        System.out.println("Original: " + nome);
        System.out.println("Comprimido (bytes): ");
        for (byte b : comprimido) {
            System.out.printf("%02X ", b);
        }
        System.out.println();
        System.out.println("Expandido: " + expandido);
    }
}
