import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.math.Vector2;
import java.awt.Color;

public class Jogo extends EngineFrame {
    
    private static final int TAMANHO_TELA = 600;
    private static final int DIMENSAO_GRADE = 50;
    private static final int LARGURA_CELULA = TAMANHO_TELA / DIMENSAO_GRADE;
    
    private boolean[][] grade;
    
    private static double tempoAtualizacao;
    private double contadorTempo;
    private boolean executando;
    private boolean mostrarAjuda;
    private static final Color COR_CELULA = Color.YELLOW;  // cor fixa para células vivas
    
    public Jogo() {
        super(TAMANHO_TELA, TAMANHO_TELA, "Jogo da Vida", 60, true);
    }
    
    @Override
    public void create() {
        setDefaultFontSize(20);
        
        grade = new boolean[DIMENSAO_GRADE][DIMENSAO_GRADE];
        tempoAtualizacao = 0.2;
        mostrarAjuda = true;
        
        initializeInitialScene();
    }
    
    @Override
    public void update(double delta) {
        if (executando) {
            contadorTempo += delta;

            if (contadorTempo >= tempoAtualizacao) {
                contadorTempo = 0; 
                advanceToNewGeneration();
            }
        }

        if (isKeyPressed(KEY_ENTER)) {
            executando = !executando;
        }

        if (isKeyPressed(KEY_UP)) {
            tempoAtualizacao += 0.05;
            if (tempoAtualizacao >= 2.0) {
                tempoAtualizacao = 2.0; 
            }
        }

        if (isKeyPressed(KEY_DOWN)) {
            tempoAtualizacao -= 0.05;
            if (tempoAtualizacao <= 0.05) {
                tempoAtualizacao = 0.05; 
            }
        }

        if (isKeyPressed(KEY_R)) {
            initializeInitialScene();
        }

        if (isKeyPressed(KEY_F1)) {
            mostrarAjuda = !mostrarAjuda;
        }

        if (isMouseButtonPressed(MOUSE_BUTTON_LEFT)) {
            Vector2 mousePos = getMousePositionPoint();
            int i = (int) mousePos.y / LARGURA_CELULA;
            int j = (int) mousePos.x / LARGURA_CELULA;
            grade[i][j] = !grade[i][j]; 
        }
    }

    @Override
    public void draw() {
        clearBackground(Color.BLACK);  // fundo preto

        for (int i = 0; i < DIMENSAO_GRADE; i++) {
            for (int j = 0; j < DIMENSAO_GRADE; j++) {
                if (grade[i][j]) {
                    fillRectangle(j * LARGURA_CELULA, i * LARGURA_CELULA, LARGURA_CELULA, LARGURA_CELULA, COR_CELULA);
                }
            }
        }

        for (int i = 0; i < DIMENSAO_GRADE; i++) {
            drawLine(i * LARGURA_CELULA, 0, i * LARGURA_CELULA, TAMANHO_TELA, Color.DARK_GRAY);
        }

        for (int i = 0; i < DIMENSAO_GRADE; i++) {
            drawLine(0, i * LARGURA_CELULA, TAMANHO_TELA, i * LARGURA_CELULA, Color.DARK_GRAY);
        }

        if (mostrarAjuda) {
            drawText("    <ENTER>: pausar/retomar", 20, 20, Color.YELLOW);
            drawText("<UP>/<DOWN>: acelerar/desacelerar", 20, 40, Color.YELLOW);
            drawText("        <R>: resetar e pausar", 20, 60, Color.YELLOW);
            drawText("       <F1>: esconder/mostrar essa ajuda", 20, 80, Color.YELLOW);
            drawText(String.format("Nova geração em %.2fs.", tempoAtualizacao), 20, getScreenHeight() - 40, Color.YELLOW);
        }
    }

    private void initializeInitialScene() {
        executando = false;

        for (int i = 0; i < DIMENSAO_GRADE; i++) {
            for (int j = 0; j < DIMENSAO_GRADE; j++) {
                grade[i][j] = false;
            }
        }

        int iIni = DIMENSAO_GRADE / 2 + 2;
        int jIni = DIMENSAO_GRADE / 2;

        // glider
        grade[iIni][jIni] = true;
        grade[iIni+1][jIni+1] = true;
        grade[iIni+2][jIni-1] = true;
        grade[iIni+2][jIni] = true;
        grade[iIni+2][jIni+1] = true;
    }

    private int countLiveNeighbors(int i, int j) {
        int count = 0;

        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                if (di == 0 && dj == 0) continue;

                int ni = i + di;
                int nj = j + dj;

                if (ni >= 0 && ni < DIMENSAO_GRADE && nj >= 0 && nj < DIMENSAO_GRADE) {
                    count += grade[ni][nj] ? 1 : 0;
                }
            }
        }

        return count;
    }

    private void advanceToNewGeneration() {
        boolean[][] novaGrade = new boolean[DIMENSAO_GRADE][DIMENSAO_GRADE];

        for (int i = 0; i < DIMENSAO_GRADE; i++) {
            for (int j = 0; j < DIMENSAO_GRADE; j++) {
                int vizinhosVivos = countLiveNeighbors(i, j);

                if (grade[i][j]) {
                    novaGrade[i][j] = (vizinhosVivos == 2 || vizinhosVivos == 3);
                } else {
                    novaGrade[i][j] = (vizinhosVivos == 3);
                }
            }
        }

        grade = novaGrade;
    }

    public static void main(String[] args) {
        new Jogo();
    }
}
