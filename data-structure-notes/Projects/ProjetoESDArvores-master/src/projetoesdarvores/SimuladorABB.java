package projetoesdarvores;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import projetoesdarvores.esd.ArvoreBinariaBusca;

/**
 * Simulador de árvores binárias de busca:
 *     Simula as operações de inserir e remover chaves;
 *     Simula os percursos (pré-ordem, em ordem, pós-ordem e em nível).
 * 
 * @author Prof. Dr. David Buzatto
 */
public class SimuladorABB extends EngineFrame {
    
    private ArvoreBinariaBusca<Integer, String> arvore;

    public SimuladorABB() {
        super( 800, 600, "Simulador de Árvores Binárias de Busca", 60, true );
    }

    @Override
    public void create() {
        arvore = new ArvoreBinariaBusca<>();
        arvore.put (5, "cinco");
        arvore.put (2, "dois");
        arvore.put (10, "dez");
        System.out.println(arvore);
    }

    @Override
    public void update() {
                            
    }

    @Override
    public void draw() {
        
    }
    
    private void desenharNo( ArvoreBinariaBusca.Node<Integer, String> no){
        
    }
    
    public static void main( String[] args ) {
        new SimuladorABB();
    }
    
}
