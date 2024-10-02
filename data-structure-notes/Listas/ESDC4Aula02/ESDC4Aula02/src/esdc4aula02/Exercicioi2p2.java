package esdc4aula02;

import aesd.ds.implementations.linear.ResizingArrayStack;

/**
 * Resolução do Exercício i2.2
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Exercicioi2p2 {

    /**
     * Converte uma expressão prefixada para infixa.
     * 
     * @param prefix Expressão prefixada.
     * @return Expressão infixa correspondente.
     * @throws IllegalArgumentException Se a expressão for inválida.
     */
    public static String prefixToInfix(String prefix) throws IllegalArgumentException {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char token = prefix.charAt(i);

            if (isOperand(token)) {
                StringBuilder n = new StringBuilder();
                while (i >= 0 && Character.isDigit(prefix.charAt(i))) {
                    n.append(prefix.charAt(i));
                    i--;
                }
                i++;
                stack.push(n.reverse().toString());
            } else if (isOperator(token)) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String infix = "( " + op1 + " " + token + " " + op2 + " )";
                stack.push(infix);
            }
        }

        return stack.peek();
    }

    /**
     * Converte uma expressão prefixada para posfixada.
     * 
     * @param prefix Expressão prefixada.
     * @return Expressão posfixada correspondente.
     * @throws IllegalArgumentException Se a expressão for inválida.
     */
    public static String prefixToPostfix(String prefix) throws IllegalArgumentException {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char token = prefix.charAt(i);

            if (Character.isWhitespace(token)) {
                continue;
            }

            if (isOperand(token)) {
                StringBuilder n = new StringBuilder();
                while (i >= 0 && Character.isDigit(prefix.charAt(i))) {
                    n.append(prefix.charAt(i));
                    i--;
                }
                i++;
                stack.push(n.reverse().toString());
            } else if (isOperator(token)) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String postfix = op1 + " " + op2 + " " + token;
                stack.push(postfix);
            }
        }

        return stack.peek();
    }

    /**
     * Converte uma expressão posfixada para infixa.
     * 
     * @param postfix Expressão posfixada.
     * @return Expressão infixa correspondente.
     * @throws IllegalArgumentException Se a expressão for inválida.
     */
    public static String postfixToInfix(String postfix) throws IllegalArgumentException {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char token = postfix.charAt(i);

            if (Character.isWhitespace(token)) {
                continue;
            }

            if (isOperand(token)) {
                StringBuilder n = new StringBuilder();
                while (i < postfix.length() && Character.isDigit(postfix.charAt(i))) {
                    n.append(postfix.charAt(i));
                    i++;
                }
                i--;
                stack.push(n.toString());
            } else if (isOperator(token)) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String infix = "( " + op2 + " " + token + " " + op1 + " )";
                stack.push(infix);
            }
        }

        return stack.peek();
    }

    /**
     * Converte uma expressão posfixada para prefixada.
     * 
     * @param postfix Expressão posfixada.
     * @return Expressão prefixada correspondente.
     * @throws IllegalArgumentException Se a expressão for inválida.
     */
    public static String postfixToPrefix(String postfix) throws IllegalArgumentException {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char token = postfix.charAt(i);

            if (Character.isWhitespace(token)) {
                continue;
            }

            if (isOperand(token)) {
                StringBuilder n = new StringBuilder();
                while (i < postfix.length() && Character.isDigit(postfix.charAt(i))) {
                    n.append(postfix.charAt(i));
                    i++;
                }
                i--;
                stack.push(n.toString());
            } else if (isOperator(token)) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String prefix = token + " " + op2 + " " + op1;
                stack.push(prefix);
            }
        }

        return stack.peek();
    }

    /**
     * Converte uma expressão infixa para prefixada.
     * 
     * @param infix Expressão infixa.
     * @return Expressão prefixada correspondente.
     * @throws IllegalArgumentException Se a expressão for inválida.
     */
    public static String infixToPrefix(String infix) throws IllegalArgumentException {
        String postfix = infixToPostfix(infix);
        return postfixToPrefix(postfix);
    }

    /**
     * Converte uma expressão infixa para posfixada.
     * 
     * @param infix Expressão infixa.
     * @return Expressão posfixada correspondente.
     * @throws IllegalArgumentException Se a expressão for inválida.
     */
    public static String infixToPostfix(String infix) throws IllegalArgumentException {
        ResizingArrayStack<Character> stack = new ResizingArrayStack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char token = infix.charAt(i);

            if (Character.isWhitespace(token)) {
                continue;
            }

            if (isOperand(token)) {
                StringBuilder number = new StringBuilder();
                while (i < infix.length() && Character.isDigit(infix.charAt(i))) {
                    number.append(infix.charAt(i));
                    i++;
                }
                i--;
                postfix.append(number).append(" ");
            } else if (isLeftParenthesis(token)) {
                stack.push(token);
            } else if (isRightParenthesis(token)) {
                while (!stack.isEmpty() && !isLeftParenthesis(stack.peek())) {
                    postfix.append(stack.pop()).append(" ");
                }
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException();
                }
                stack.pop();
            } else if (isOperator(token)) {
                while (!stack.isEmpty() && getPrecedence(token) <= getPrecedence(stack.peek())) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            char op = stack.pop();
            if (isLeftParenthesis(op)) {
                throw new IllegalArgumentException();
            }
            postfix.append(op).append(" ");
        }

        return postfix.toString().trim();
    }

    // Métodos auxiliares

    public static boolean isLeftParenthesis(char token) {
        return token == '(';
    }

    public static boolean isRightParenthesis(char token) {
        return token == ')';
    }

    public static boolean isOperand(char token) {
        return token >= '0' && token <= '9';
    }

    public static boolean isOperator(char token) {
        return token == '+' || token == '-' || token == '*' || token == '/';
    }

    public static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
}
