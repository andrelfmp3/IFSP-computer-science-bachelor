package algoritmos.implementation;

import algoritmos.dependents.trie.Trie;

public class Trie_Impl {

    public static void main(String[] args) {

        Trie<Integer> trie = new Trie<>();

        trie.put("cachorro", 1);
        trie.put("gato", 2);
        trie.put("casa", 3);

        System.out.println("Tamanho da trie: " + trie.getSize());

        System.out.println("Busca 'gato': " + trie.get("gato"));
        System.out.println("Busca 'casa': " + trie.get("casa"));
        System.out.println("Busca 'passaro': " + trie.get("passaro"));

        System.out.println("Todas as chaves:");
        for (String key : trie.getKeys()) {
            System.out.println(key);
        }
    }
}
