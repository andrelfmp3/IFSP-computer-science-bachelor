package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
// import aesd.algorithms.backtracking.LabyrinthSolver;  tentei utilizar mas nn consegui, decidi implementar no próprio Main 
import java.awt.Color;

public class Main extends EngineFrame {
    
    private int[][] matrizLabirinto; // Labirinto de paredes
    private boolean[][] visitado;    // Labirinto dos visitados

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
    }

    @Override
    public void update(double delta) {
  
        resolverLabirinto(0, 1); // tecnicamente começa no 0, 0, mas para manter azul, deixa do lado. Na prática é a mesma coisa
        repaint(); // Atualiza a tela para mostrar as mudanças
        
    }

    private boolean resolverLabirinto(int x, int y) { // backtracking adaptado REVER
        
        if (x < 0 || y < 0 || x >= 12 || y >= 16 || matrizLabirinto[x][y] == 1 || visitado[x][y]) {
            return false;
        }

        if (matrizLabirinto[x][y] == 3) { // Chegou ao destino
            return true;
        }

        visitado[x][y] = true;
        matrizLabirinto[x][y] = 4; // Marca o caminho percorrido de amarelo
        
        repaint(); // Pausa para visualizar o movimento
        try { Thread.sleep(100); } catch (InterruptedException e) { } // Pausa para visualizar o movimento
        
        if (resolverLabirinto(x, y + 1) || // Direita
            resolverLabirinto(x + 1, y) || // Baixo
            resolverLabirinto(x, y - 1) || // Esquerda
            resolverLabirinto(x - 1, y)) { // Cima
            return true;
        }
        
        // Movimentos possíveis (direita, baixo, esquerda, cima)
        if (resolverLabirinto(x, y + 1) || // Direita
            resolverLabirinto(x + 1, y) || // Baixo
            resolverLabirinto(x, y - 1) || // Esquerda
            resolverLabirinto(x - 1, y)) { // Cima
            return true;
        }

        matrizLabirinto[x][y] = 0; // Marca o retrocesso, pinta de cinza de novo
        
        repaint();
        try { Thread.sleep(100); } catch (InterruptedException e) { } // Pausa para visualizar o retrocesso
        
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
                    case 0 -> Color.GRAY;     // caminho livre (tbm utilizada para retrocesso)
                    case 1 -> Color.BLACK;    // "parede"
                    case 2 -> Color.BLUE;     // falso inicio
                    case 3 -> Color.RED;      // fim    
                    case 4 -> Color.YELLOW;   // caminho percorrido
                    default -> Color.MAGENTA;
                }; 
                
                fillRectangle(j * 50, i * 50, 50, 50, cor);
                drawRectangle(j * 50, i * 50, 50, 50, Color.BLACK);
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
