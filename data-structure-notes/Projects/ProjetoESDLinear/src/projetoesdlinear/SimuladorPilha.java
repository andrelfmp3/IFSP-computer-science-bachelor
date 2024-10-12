package projetoesdlinear;

import projetoesdlinear.engine.Engine;

/**
 *
 * @author Prof. Dr. David Buzatto
 */
public class SimuladorPilha extends Engine {

    private Stack<String> pilha; // ctlr shift i

    public SimuladorPilha() {

        // cria a janela do jogo ou simulação
        super( 
            800,                  // 800 pixels de largura
            600,                  // 600 pixels de largura
            "Simulador de Pilhas",// título da janela
            true,                 // ativa a suavização (antialiasing)
            60 );                 // 60 quadros por segundo

    }

    /**
     * Processa a entrada inicial fornecida pelo usuário e cria
     * e/ou inicializa os objetos/contextos/variáveis do jogo ou simulação.
     */
    @Override
    public void criar() {
    }

    /**
     * Atualiza os objetos/contextos/variáveis do jogo ou simulação.
     */
    @Override
    public void atualizar() {
    }

    /**
     * Desenha o estado dos objetos/contextos/variáveis do jogo ou simulação.
     */
    @Override
    public void desenhar() {
    }

    public static void main( String[] args ) {
        new SimuladorPilha();
    }
    
}
