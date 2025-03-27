package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
// import aesd.algorithms.backtracking.LabyrinthSolver;  tentei utilizar mas nn consegui, decidi implementar no próprio Main 
import java.awt.Color;

public class Main extends EngineFrame {
    
    private int[][] matrizLabirinto; // Labirinto de paredes
    private boolean[][] visitado;    // Labirinto dos visitados
    private char[][] direcaoMovimento;

    public Main() {
        super(800, 600, "Maze BackTracking - AndreLF", 60, true);
    }

    @Override
    public void create() {
                
        this.matrizLabirinto = new int[][] { // Definição do labirinto 12x16 
            {2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0},
            {0, 0, 1, 0, 1, 3, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0},
            {0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1},
            {0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1},
            {0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0}
        };

        visitado = new boolean[12][16]; // tudo false, se for visitado, vira true
        direcaoMovimento = new char[12][16]; // Inicializa a matriz de direções
    }

    @Override
    public void update(double delta) {
  
        resolverLabirinto(0, 0); // tecnicamente começa no 0, 0, mas para manter azul, deixa do lado. Na prática é a mesma coisa
        repaint(); // Atualiza a tela para mostrar as mudanças
        
    }

    private boolean resolverLabirinto(int x, int y) { 
        if (x < 0 || y < 0 || x >= 12 || y >= 16 || matrizLabirinto[x][y] == 1 || visitado[x][y]) {
            return false;
        }

        if (matrizLabirinto[x][y] == 3) { // Chegou ao destino
            return true;
        }

        visitado[x][y] = true;
        matrizLabirinto[x][y] = 4; 
        repaint();
        
        try { Thread.sleep(100); } catch (InterruptedException e) { }

      
        if (y + 1 < 16 && !visitado[x][y + 1] && matrizLabirinto[x][y + 1] != 1) {
            direcaoMovimento[x][y] = 'A'; // Direita
            if (resolverLabirinto(x, y + 1)) return true;
        }
        if (x + 1 < 12 && !visitado[x + 1][y] && matrizLabirinto[x + 1][y] != 1) {
            direcaoMovimento[x][y] = 'B'; // Baixo
            if (resolverLabirinto(x + 1, y)) return true;
        }
        if (y - 1 >= 0 && !visitado[x][y - 1] && matrizLabirinto[x][y - 1] != 1) {
            direcaoMovimento[x][y] = 'C'; // Esquerda
            if (resolverLabirinto(x, y - 1)) return true;
        }
        if (x - 1 >= 0 && !visitado[x - 1][y] && matrizLabirinto[x - 1][y] != 1) {
            direcaoMovimento[x][y] = 'D'; // Cima
            if (resolverLabirinto(x - 1, y)) return true;
        }

        matrizLabirinto[x][y] = 0; // Se não for possível continuar, volta ao estado anterior

        repaint();
        try { Thread.sleep(100); } catch (InterruptedException e) { }

        return false;
    }


    @Override
    public void draw() {
        clearBackground(Color.GRAY);
        desenhaLabirinto();
    }
    
    private void desenhaLabirinto() {
        Color cor;

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 16; j++) {
                cor = switch (matrizLabirinto[i][j]) {
                    case 0 -> Color.GRAY;     // caminho livre (também utilizada para retrocesso)
                    case 1 -> Color.BLACK;    // parede
                    case 2 -> Color.BLUE;     // falso início
                    case 3 -> Color.RED;      // fim    
                    case 4 -> Color.YELLOW;   // caminho percorrido
                    default -> Color.MAGENTA;
                }; 

                // Desenha os blocos do labirinto
                fillRectangle(j * 50, i * 50, 50, 50, cor);
                drawRectangle(j * 50, i * 50, 50, 50, Color.BLACK);

                // Se for um caminho percorrido (4), desenha o texto "Teste"
                if (matrizLabirinto[i][j] == 4) {
                    if (direcaoMovimento[i][j] == 'A'){
                        drawText("A", j * 50 + 35, i * 50 + 22, 16, Color.BLACK);
                    }  // Esquerda
                    if (direcaoMovimento[i][j] == 'B'){
                        drawText("A", j * 50 + 35, i * 50 + 22, 16, Color.GRAY);
                        drawText("B", j * 50 + 20, i * 50 + 38, 16, Color.BLACK);
                    } // Baixo
                    if (direcaoMovimento[i][j] == 'C'){
                        drawText("A", j * 50 + 35, i * 50 + 22, 16, Color.GRAY);
                        drawText("B", j * 50 + 20, i * 50 + 38, 16, Color.GRAY);
                        drawText("C", j * 50 + 5, i * 50 + 22, 16, Color.BLACK);
                    } // Direita
                    if (direcaoMovimento[i][j] == 'D'){
                        drawText("A", j * 50 + 35, i * 50 + 22, 16, Color.GRAY);
                        drawText("B", j * 50 + 20, i * 50 + 38, 16, Color.GRAY);
                        drawText("C", j * 50 + 5, i * 50 + 22, 16, Color.GRAY);
                        drawText("D", j * 50 + 20, i * 50 + 5, 16, Color.BLACK);
                    }
                }
            }
        }
    }

/*
                        drawText("A", j * 50 + 5, i * 50 + 22, 16, Color.GRAY);
                        drawText("B", j * 50 + 20, i * 50 + 38, 16, Color.GRAY);
                        drawText("C", j * 50 + 35, i * 50 + 22, 15, Color.GRAY);
                        drawText("D", j * 50 + 20, i * 50 + 5, 16, Color.BLACK);
*/

    public static void main(String[] args) {
        new Main();
    }
}
