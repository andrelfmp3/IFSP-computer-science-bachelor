package implementation;

import dependents.BinarySearchTree;

public class BinarySearchTreeTest {

    public static void main(String[] args) {
        
        // instancia "bst"
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();

        // Inserindo elementos
        bst.put(50, "Root");
        bst.put(30, "Left Child");
        bst.put(70, "Right Child");
        bst.put(20, "Left-Left");
        bst.put(40, "Left-Right");
        bst.put(60, "Right-Left");
        bst.put(80, "Right-Right");

        // Imprimi arvore
        System.out.println("Arvore apos insercoes:");
        System.out.println(bst);
        
        // Verifica tamanho
        System.out.println("Tamanho atual da arvore: " + bst.getSize());

        // Recuperando valores
        System.out.println("Valor associado a chave 30: " + bst.get(30));
        System.out.println("Valor associado a chave 80: " + bst.get(80));

        // Verificando presença
        System.out.println("Contém chave 60? " + bst.contains(60));

        // Removendo elementos
        bst.delete(30); // remover um nó com dois filhos
        System.out.println("Arvore apos remover chave 30:");
        System.out.println(bst);

        bst.delete(20); // remover folha
        bst.delete(70); // remover nó com um filho
        System.out.println("Arvore apos remover chaves 20 e 70:");
        System.out.println(bst);

        // Limpando a árvore
        bst.clear();
        System.out.println("Árvore após limpar arvore:");
        System.out.println(bst);
        
    }

}
