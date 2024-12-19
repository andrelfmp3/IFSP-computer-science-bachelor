package projetoesdgrafos.grafo;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import java.awt.Color;
import projetoesdgrafos.SimuladorBuscaLargura;

/**
 * Uma aresta de um grafo.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Aresta {
    
    public Vertice origem;
    public Vertice destino;

    public Aresta(Vertice origem, Vertice destino) {
        this.origem = origem;
        this.destino = destino;
    }

    // Método que desenha a aresta no gráfico
    public void draw(EngineFrame e) {
        e.drawLine(origem.pos, destino.pos, Color.GRAY);
    }

    // Retorna o vértice origem
    public Vertice getOrigem() {
        return origem;
    }

    // Retorna o vértice destino
    public Vertice getDestino() {
        return destino;
    }
    
    // Método para destacar visualmente a aresta (com cor e espessura)
    public static void destacaCaminho(Aresta aresta, EngineFrame e) {
        // Obtém a origem e o destino da aresta
        Vertice origem = aresta.getOrigem();
        Vertice destino = aresta.getDestino();

        // Desenha a linha entre origem e destino, com cor verde e espessura maior
        e.drawLine(origem.pos, destino.pos, Color.red); // Desenha a linha com cor verde
        // PRECISA VER FRAMEWORK
    }
}
