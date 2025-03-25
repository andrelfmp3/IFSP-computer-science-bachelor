package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
//import aesd.ds.implementations.linear.LinkedQueue;

public class Main extends EngineFrame {
    
    private double tempoProximoSnapshot;
    private int[][] labirinto;
    
    public Main() {
        
        super (
            800,                  // largura                      
            600,                  // altura (modificada)              
            "Maze BackTracking",  // título (modificado)              
            60,                   // quadros por segundo desejado 
            true                  // suavizacao         
        );
        
    }
    
    
    /**
     * Cria o mundo do jogo.
     * Esse método executa apenas uma vez durante a inicialização da engine.
     */
    @Override
    public void create() {

        setDefaultFontSize(20); // qualquer texto fica com tamanho 20
        tempoProximoSnapshot = .05;
        
        // labirinto 12 x 16 
        labirinto = new int[][] {  
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        
    }

    
    
    
    
    /**
     * Lê a entrada do usuário e atualiza o mundo do jogo.
     * Os métodos de entrada devem ser usados aqui.
     * Atenção: Você NÃO DEVE usar nenhum dos métodos de desenho da engine aqui.
     */
    @Override
    public void update( double delta ) {
    }
    
    
    
    
    /**
     * Desenha o mundo do jogo.
     * Todas as operações de desenho DEVEM ser feitas aqui.
     */
    @Override
    public void draw() {
        
        clearBackground( GRAY );
    
    }
    
    /**
     * Instancia a engine e a inicia.
     */
    public static void main( String[] args ) {
        new Main();
    }
    
}