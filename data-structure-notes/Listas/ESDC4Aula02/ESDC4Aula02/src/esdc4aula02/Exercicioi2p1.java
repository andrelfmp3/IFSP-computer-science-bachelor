package esdc4aula02;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

/**
 * Resolução do Exercício i2.1
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Exercicioi2p1 {

    /**
     * Verifica se uma expressão composta por pares de símbolos arbitrários está
     * balanceada.
     * 
     * @param expression A expressão a ser verificada.
     * @param pairs Um conjunto de caracteres em que cada dois representam um
     * par de caracteres usados na verificação.
     * @return Se a expressão está balanceada.
     * @throws IllegalArgumentException Caso os pares forem fornecidos de forma
     * errada, ou seja, se houver uma quantidade ímpar de elementos, faltando 
     * assim a dupla de fechamento de um par.
     */
    public static boolean isBalanced(String expression, char... pairs) throws IllegalArgumentException {
        // Verifica se o número de pares é ímpar
        if (pairs.length % 2 != 0) {
            throw new IllegalArgumentException("Número ímpar de caracteres!");
        }

        // Cria um HashMap para mapear os símbolos de abertura e fechamento
        Map<Character, Character> pairMap = new HashMap<>();
        for (int i = 0; i < pairs.length; i += 2) {
            pairMap.put(pairs[i], pairs[i + 1]);
        }

        // Declara a pilha para armazenar os símbolos de abertura
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (pairMap.containsKey(ch)) { // Se for um símbolo de abertura
                stack.push(ch);
            } else if (pairMap.containsValue(ch)) { // Se for um símbolo de fechamento
                if (stack.isEmpty() || pairMap.get(stack.pop()) != ch) {
                    return false; // Não balanceado
                }
            }
        }

        return stack.isEmpty();
    }

    // Método principal para testar o código
    public static void main(String[] args) {
        String expression = "{[()]}";
        boolean result = isBalanced(expression, '{', '}', '[', ']', '(', ')');
        System.out.println("A expressão está balanceada? " + result);
    }
}
