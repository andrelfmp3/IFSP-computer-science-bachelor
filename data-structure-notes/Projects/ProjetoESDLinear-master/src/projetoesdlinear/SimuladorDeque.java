package projetoesdlinear;

import projetoesdlinear.engine.Engine;

/**
 * Simulador de deque:
 *     Simula as operações de inserir no início e no fim e remover do início
 *     e do fim de uma deque encadeada/ligada/dinâmica.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class SimuladorDeque extends Engine {

    // declaração de variáveis

    public SimuladorDeque() {

        // cria a janela do jogo ou simulação
        super( 
            800,                  // 800 pixels de largura
            600,                  // 600 pixels de largura
            "Simulador de Deque", // título da janela
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
        new SimuladorDeque();
    }
    
}
