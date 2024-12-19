package projetoesdgrafos.grafo;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import projetoesdgrafos.grafo.Aresta;
import projetoesdgrafos.grafo.Vertice;

/**
 * Um grafo implementado usando uma tabela de símbolos.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Grafo {

    public Map<Vertice, List<Aresta>> st;
    public Map<Integer, Vertice> vertices;

    public Grafo() {
        st = new TreeMap<>();
        vertices = new TreeMap<>();
    }

    public Vertice addVertice(double x, double y) {
        Vertice v = new Vertice(vertices.size(), x, y);
        vertices.put(v.id, v);
        return v;
    }

    public void addAresta(int origem, int destino) {
        Vertice vo = vertices.get(origem);
        Vertice vd = vertices.get(destino);
        if (!st.containsKey(vo)) {
            st.put(vo, new ArrayList<>());
        }
        if (!st.containsKey(vd)) {
            st.put(vd, new ArrayList<>());
        }
        st.get(vo).add(0, new Aresta(vo, vd));
        st.get(vd).add(0, new Aresta(vd, vo));
    }

    public List<Aresta> adjacentes(int origem) {
        return st.getOrDefault(vertices.get(origem), new ArrayList<>());
    }

    public int getQuantidadeVertices() {
        return vertices.size();
    }

    public void draw(EngineFrame e) {
        for (Map.Entry<Vertice, List<Aresta>> entry : st.entrySet()) {
            for (Aresta a : entry.getValue()) {
                a.draw(e);
            }
        }

        for (Map.Entry<Integer, Vertice> entry : vertices.entrySet()) {
            entry.getValue().draw(e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Vertice, List<Aresta>> entry : st.entrySet()) {
            sb.append(entry.getKey()).append(" -> ");
            boolean primeiro = true;
            for (Aresta a : entry.getValue()) {
                if (primeiro) {
                    primeiro = false;
                } else {
                    sb.append(", ");
                }
                sb.append(a.destino.id);
            }
            sb.append("\n");
        }

        return sb.toString().trim();
    }

    // dfs
    public List<Aresta> buscaProfundidade(Vertice verticeOrigem) {
        Set<Vertice> verticesVisitados = new HashSet<>();
        List<Aresta> arestasVisitadas = new ArrayList<>();
        buscaProfundidadeRecursivo(verticeOrigem, verticesVisitados, arestasVisitadas);
        return arestasVisitadas;
    }

    // Método auxiliar recursivo
    private void buscaProfundidadeRecursivo(Vertice verticeAtual, Set<Vertice> verticesVisitados, List<Aresta> arestasVisitadas) {
        verticesVisitados.add(verticeAtual);

        // Percorre as arestas do vértice atual
        for (Aresta aresta : st.getOrDefault(verticeAtual, new ArrayList<>())) {
            if (!verticesVisitados.contains(aresta.destino)) {
                arestasVisitadas.add(aresta);
                buscaProfundidadeRecursivo(aresta.destino, verticesVisitados, arestasVisitadas);  // Chamada recursiva
            }
        }
    }
    
    // Método de busca em largura (versão iterativa consolidada)
    public List<Aresta> buscaLargura(Vertice verticeOrigem) {
        // Inicialização das estruturas
        Map<Vertice, Boolean> visitados = new HashMap<>();
        Map<Vertice, Vertice> predecessores = new HashMap<>();
        Map<Vertice, Integer> distancias = new HashMap<>();
        List<Aresta> arestasVisitadas = new ArrayList<>();
        Queue<Vertice> fila = new LinkedList<>();

        // Marca o vértice de origem como visitado, define predecessores e distância inicial
        visitados.put(verticeOrigem, true);
        predecessores.put(verticeOrigem, null);  // O vértice inicial não tem predecessor
        distancias.put(verticeOrigem, 0);
        fila.add(verticeOrigem);

        // Processa a fila
        while (!fila.isEmpty()) {
            Vertice verticeAtual = fila.poll();

            // Explora todas as arestas adjacentes ao vértice atual
            for (Aresta aresta : st.getOrDefault(verticeAtual, new ArrayList<>())) {
                Vertice vizinho = aresta.destino;

                if (!visitados.getOrDefault(vizinho, false)) {
                    // Marca como visitado, registra predecessor e distância
                    visitados.put(vizinho, true);
                    predecessores.put(vizinho, verticeAtual);
                    distancias.put(vizinho, distancias.get(verticeAtual) + 1);

                    // Adiciona o vizinho na fila
                    fila.add(vizinho);

                    // Adiciona a aresta visitada
                    arestasVisitadas.add(aresta);
                }
            }
        }

        // Retorna a lista de arestas visitadas
        return arestasVisitadas;
    }


}

