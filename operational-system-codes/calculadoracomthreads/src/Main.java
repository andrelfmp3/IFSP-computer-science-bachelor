import java.util.Scanner;

class CalculadoraSomaLinha extends Thread {
    
    int[] linha;
    int soma;

    public CalculadoraSomaLinha(int[] linha) { //pode ser exercutada por uma thread separada
        this.linha = linha;
        this.soma = 0;
    }

    public void run() {  //pode ser exercutada por uma thread separada "ponto de entrada da thread". Implementa
        for (int valor : linha) {
            soma += valor;
        }
        System.out.println("Soma das linhas: " + soma);
    }

}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite a quantidade de linhas da matriz: ");
        int numLinhas = teclado.nextInt();

        int[][] matriz = new int[numLinhas][];

        for (int i = 0; i < numLinhas; i++) { // "preenche array"
            System.out.print("Digite a quantidade de elementos na linhas " + (i + 1) + ": "); // + 1 para corrigir tamanhao
            int numElementos = teclado.nextInt();
            matriz[i] = new int[numElementos];

            System.out.println("Digite os elementos da linha " + (i + 1) + " separados por espaço:"); //insere todos de uma vez

            for (int j = 0; j < numElementos; j++) {
                matriz[i][j] = teclado.nextInt();
            }
        }

        CalculadoraSomaLinha[] threads = new CalculadoraSomaLinha[numLinhas]; //cria qntd de linhas, de threads

        for (int i = 0; i < numLinhas; i++) {
            threads[i] = new CalculadoraSomaLinha(matriz[i]);
            threads[i].start(); //executa
        }

        // Imprimir quantidade de threads
        System.out.println("Quantidade de threads: " + threads.length);

        for (int i = 0; i < numLinhas; i++){  //tratamento de exceção
            threads[i].join();
        }

        teclado.close();
    }
}
