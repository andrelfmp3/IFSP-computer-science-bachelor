package esdc4aula02;

import aesd.ds.implementations.linear.ResizingArrayStack;
import static esdc4aula02.Exercicioi2p2.infixToPostfix;
import static esdc4aula02.Exercicioi2p2.isOperand;
import static esdc4aula02.Exercicioi2p2.isOperator;
import static esdc4aula02.Exercicioi2p2.prefixToPostfix;

/**
 * Resolução do Exercício i2.3
 * 
 * Avalia uma expressão aritmética em qualquer forma (pré-fixada, infixa ou pós-fixada),
 * e retorna o resultado da avaliação. Suporta as operações de adição, subtração, 
 * multiplicação e divisão.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Exercicioi2p3 {
    
    /**
     * Avalia uma expressão aritmética fornecida.
     * 
     * @param expression Expressão a ser avaliada.
     * @return O valor resultante após a avaliação.
     * @throws IllegalArgumentException Se a expressão for inválida.
     */
    public static double evaluate(String expression) throws IllegalArgumentException {
        expression = expression.trim();

        // Verifica o tipo da expressão e avalia a correspondente
        if (isOperator(expression.charAt(0))) {
            // Expressão prefixada
            return evaluatePostfix(prefixToPostfix(expression));
        } else if (isOperator(expression.charAt(expression.length() - 1))) {
            // Expressão posfixada
            return evaluatePostfix(expression);
        } else {
            // Expressão infixa
            return evaluatePostfix(infixToPostfix(expression));
        }
    }
    
    /**
     * Avalia uma expressão posfixada.
     * 
     * @param postfix Expressão posfixada.
     * @return Resultado da avaliação.
     * @throws IllegalArgumentException Se ocorrer erro na expressão.
     */
    private static double evaluatePostfix(String postfix) {
        ResizingArrayStack<Double> stack = new ResizingArrayStack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char currentChar = postfix.charAt(i);

            if (Character.isWhitespace(currentChar)) {
                continue;
            }

            // Se for operando, constrói o número
            if (isOperand(currentChar)) {
                StringBuilder number = new StringBuilder();

                while (i < postfix.length() && Character.isDigit(postfix.charAt(i))) {
                    number.append(postfix.charAt(i));
                    i++;
                }
                i--; // Ajusta o índice
                stack.push(Double.valueOf(number.toString()));
                
            } else if (isOperator(currentChar)) {
                // Realiza operação com os dois valores no topo da pilha
                double val2 = stack.pop();
                double val1 = stack.pop();
                double result = 0;

                switch (currentChar) {
                    case '+':
                        result = val1 + val2;
                        break;
                    case '-':
                        result = val1 - val2;
                        break;
                    case '*':
                        result = val1 * val2;
                        break;
                    case '/':
                        if (val2 == 0) {
                            throw new IllegalArgumentException("Divisão por zero.");
                        }
                        result = val1 / val2;
                        break;
                    default:
                        throw new IllegalArgumentException("Operador inválido: " + currentChar);
                }
                
                stack.push(result);
            }
        }

        return stack.pop();
    }
}
