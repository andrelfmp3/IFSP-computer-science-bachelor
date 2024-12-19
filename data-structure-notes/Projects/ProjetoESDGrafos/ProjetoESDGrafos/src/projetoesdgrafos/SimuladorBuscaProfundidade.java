package projetoesdgrafos;

import projetoesdgrafos.utils.Utils;
import projetoesdgrafos.grafo.Grafo;
import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import static br.com.davidbuzatto.jsge.core.engine.EngineFrame.BLACK;
import static br.com.davidbuzatto.jsge.core.engine.EngineFrame.MOUSE_BUTTON_LEFT;
import static br.com.davidbuzatto.jsge.core.engine.EngineFrame.STROKE_CAP_ROUND;
import static br.com.davidbuzatto.jsge.core.engine.EngineFrame.WHITE;
import br.com.davidbuzatto.jsge.geom.Line;
import br.com.davidbuzatto.jsge.math.Vector2;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import projetoesdgrafos.grafo.Aresta;
import projetoesdgrafos.grafo.Vertice;

public class SimuladorBuscaProfundidade extends EngineFrame {

    private Grafo grafo;
    private List<Aresta> resultado; // lista com o caminho feito

    public SimuladorBuscaProfundidade() {
        super(650, 500, "Busca em Profundidade", 60, true);
    }

    @Override
    public void create() {
        grafo = Utils.criarGrafoTeste();
        resultado = null; // caminho inicia vazio
        System.out.println(grafo);
        setDefaultFontSize(20);
        setDefaultStrokeLineWidth(2);
        setDefaultStrokeEndCap(STROKE_CAP_ROUND);
    }
    
    private void funçõesPainel () {
        
        String valor = JOptionPane.showInputDialog("Valor inicial:"); // valor selecionado em string
        
        if (valor == null || valor.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Valor inserido incorreto. Valor nulo inserido.");
        } else if (isNumeric(valor) == false) {
            JOptionPane.showMessageDialog(null, "Valor inserido incorreto. Insira um número.");
        } else {
            
            int valorInt = Integer.parseInt(valor); // valor convertido p int (era string para tratar erro de letra)
            
            // Verifica se o id pertence ao grafo
            if (!grafo.vertices.containsKey(valorInt)) {
                JOptionPane.showMessageDialog(null, "Valor inserido incorreto. Não pertence ao grafo.");
            } else {
                Vertice verticeInicial = grafo.vertices.get(valorInt); // define o ponto inicial. Considera valorInt" como valor. Muda para tipo "vértice"
                resultado = grafo.buscaProfundidade(verticeInicial); // cria uma lista "aresta" com resultados se referenciando
                imprimirResultado(resultado);
                repaint();
            }
        }
    }

    // Saída teste, terminal
    private void imprimirResultado(List<Aresta> resultado) {
        System.out.println("\nArestas visitadas:");
        for (int i = 0; i < resultado.size(); i++) {
            Aresta aresta = resultado.get(i); 
            System.out.println("De " + aresta.origem.id + " para " + aresta.destino.id);
            //Aresta.destacaCaminho(aresta);
        }
    }   

    
    // Verifica se a string é numérica (obtido via stackoverflow)
    private boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
  
    @Override
    public void update(double delta) {
        Vector2 mousePos = getMousePositionPoint();
        
        if (isMouseButtonPressed(MOUSE_BUTTON_LEFT)) {
            funçõesPainel();
        }
    }

  @Override
public void draw() {
    clearBackground(BLACK);  // Limpa o fundo
    drawText("Clique para escolher a fonte e executar o algoritmo.", 10, 10, WHITE);  // Instruções
    drawText("André Lyra e Victória Carolina.", 10, 480, WHITE);  // Assinatura
    grafo.draw(this);  // Desenha o grafo

    if (resultado != null) {
        int espessura = 3; // Ajuste da espessura da linha
        
        for (int i = 0; i < resultado.size(); i++) {
            Aresta aresta = resultado.get(i);

            Vector2 origem = aresta.origem.pos;
            Vector2 destino = aresta.destino.pos;

            double angulo = Math.atan2(destino.y - origem.y, destino.x - origem.x);

            int tamanhoSeta = 15; // Tamanho da ponta da seta
            int tamanhoLinha = 30; // Tamanho da linha para não sobrepor o vértice

            Vector2 origemAjustada = origem.add(destino.subtract(origem).normalize().scale(tamanhoLinha)); 
            Vector2 destinoAjustado = destino.subtract(destino.subtract(origem).normalize().scale(tamanhoLinha)); 

            // Desenhar linha principal com espessura manual
            for (int offset = -espessura / 3; offset <= espessura / 3; offset++) {
                drawLine(origemAjustada.x + offset, origemAjustada.y + offset, 
                         destinoAjustado.x + offset, destinoAjustado.y + offset, Color.red);
            }

            // Desenhar pontas da seta 
            for (int offset = -espessura / 2; offset <= espessura / 2; offset++) {
                drawLine(
                    destinoAjustado.x + offset,
                    destinoAjustado.y + offset,
                    destinoAjustado.x - Math.cos(angulo - Math.PI / 6) * tamanhoSeta + offset,
                    destinoAjustado.y - Math.sin(angulo - Math.PI / 6) * tamanhoSeta + offset, 
                    Color.red
                );

                drawLine(
                    destinoAjustado.x + offset,
                    destinoAjustado.y + offset,
                    destinoAjustado.x - Math.cos(angulo + Math.PI / 6) * tamanhoSeta + offset,
                    destinoAjustado.y - Math.sin(angulo + Math.PI / 6) * tamanhoSeta + offset, 
                    Color.red
                );
            }
        }
    }
}


    public static void main(String[] args) {
        new SimuladorBuscaProfundidade();
    }
}
