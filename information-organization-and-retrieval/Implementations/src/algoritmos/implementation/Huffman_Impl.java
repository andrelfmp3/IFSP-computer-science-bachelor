package algoritmos.implementation;

import algoritmos.dependents.huffman.Huffman;

public class Huffman_Impl {

    public static void main(String[] args) {
        
        if ("compress".equalsIgnoreCase(args[0])) {
            Huffman.compress();
        } else if ("expand".equalsIgnoreCase(args[0])) {
            Huffman.expand();
        }
    }
}
