package projetoesdlinear;

import aesd.ds.implementations.linear.ResizingArrayList;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import projetoesdlinear.engine.Engine;

public class SimuladorLista extends Engine {
    private ResizingArrayList<Object> lista; // Lista de elementos
    private String valorDesenfileirado; // Último valor removido
    private Color fonte = BLACK;
    private int raio = 30;
    private int distanciaEntreElementos = 40;
    private int tamanhoFonte = 20;

    public SimuladorLista() {
        super(800, 600, "Simulador de Lista", true, 60);
        lista = new ResizingArrayList<>();
        lista.add("a");
        lista.add("b");
        lista.add("c");
        valorDesenfileirado = null;
    }

    @Override
    public void criar() {
        // Inicializações, se necessário
    }

    @Override
    public void atualizar() {
        // Atualizações do estado
    }

    @Override
    public void desenhar() {
        desenharOpcoesEstadodaLista();
        desenharLista();
    }

    public void desenharOpcoesEstadodaLista() {
        int yInicial = 30;
        drawText("1) Inserir no início  ", 10, yInicial, tamanhoFonte, fonte);
        drawText("2) Inserir no final  ", 10, yInicial += 30, tamanhoFonte, fonte);
        drawText("3) Inserir em posição especificada ", 10, yInicial += 30, tamanhoFonte, fonte);
        drawText("4) Remover de posição especificada ", 10, yInicial += 30, tamanhoFonte, fonte);
        drawText("5) Alterar em posição especificada", 10, yInicial += 30, tamanhoFonte, fonte);
        drawText("6) Modo noturno", 10, yInicial += 30, tamanhoFonte, fonte);
        
        // Exibe o valor removido
        drawText("Removeu: " + (valorDesenfileirado == null ? "nenhum" : valorDesenfileirado), 10, yInicial += 30, tamanhoFonte, BLUE);
        
        drawText("André Lyra Fernandes e Victoria Carolina Ferreira da Silva", 10, 590, tamanhoFonte, fonte);

        // Exibe mensagem se a lista estiver vazia
        if (lista.isEmpty()) {
            drawText("Lista vazia!", 10, yInicial += 30, tamanhoFonte, RED);
        }
    }

    private void desenharLista() {
        int elementoAtual = 0;
        int xInicialLista = 200; // Posição inicial no eixo X
        int yCentro = getScreenHeight() / 2; // Centra a lista verticalmente

        for (Object valor : lista) {
            int xCentro = xInicialLista + (raio * 2 + distanciaEntreElementos) * elementoAtual;

            // Desenha o círculo e o valor
            drawCircleLines(xCentro, yCentro, raio, fonte);
            drawText(valor.toString(), xCentro - measureText(valor.toString(), tamanhoFonte) / 2, yCentro + 5, tamanhoFonte, fonte);

            // Desenha setas entre elementos
            if (elementoAtual > 0) {
                int xAnterior = xInicialLista + (raio * 2 + distanciaEntreElementos) * (elementoAtual - 1);
                desenharSeta(xAnterior + raio, yCentro, xCentro - raio, yCentro, 8, BLUE, true, false);
                desenharSeta(xCentro - raio, yCentro + 10, xAnterior + raio, yCentro + 10, 8, BLUE, true, false);
                drawText("anterior", xAnterior + raio, yCentro - 40, tamanhoFonte - 4, BLUE);
                drawText("próximo", xAnterior + raio, yCentro + 55, tamanhoFonte - 4, BLUE);
            }

            elementoAtual++;
        }
        
        int xPrimeiro = xInicialLista - 40;
        if (!lista.isEmpty()) {
            desenharSeta(xPrimeiro - raio, yCentro, xPrimeiro + 40 - raio, yCentro, 8, fonte, false, false);
            desenharSeta((lista.getSize() * 100) + xPrimeiro - raio, yCentro, (lista.getSize() * 100) + xPrimeiro + 40 - raio, yCentro, 8, BLUE, true, true);
        }

        drawText("inicio", xPrimeiro - raio - measureText("inicio", tamanhoFonte) - 10, yCentro + 5, tamanhoFonte, fonte);
        drawText("fim", xPrimeiro + (100 + 100 * lista.getSize()) - raio - measureText("fim", tamanhoFonte) - 10, yCentro + 5, tamanhoFonte, fonte);
    }

    public void tratarTeclado(KeyEvent e, Engine.KeyboardEventType ket) {
        if (ket == Engine.KeyboardEventType.PRESSED) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_1, KeyEvent.VK_NUMPAD1 -> simularEnfileirarInicio();
                case KeyEvent.VK_2, KeyEvent.VK_NUMPAD2 -> simularEnfileirarFinal();
                case KeyEvent.VK_3, KeyEvent.VK_NUMPAD3 -> simularInserirEmPosicaoEspecifica();
                case KeyEvent.VK_4, KeyEvent.VK_NUMPAD4 -> simularRemoverDePosicaoEspecifica();
                case KeyEvent.VK_5, KeyEvent.VK_NUMPAD5 -> simularAlterarPosicaoEspecifica();
                case KeyEvent.VK_6, KeyEvent.VK_NUMPAD6 -> modoNoturno();
            }
        }
    }

    private void simularEnfileirarInicio() {
        String valor = JOptionPane.showInputDialog("Valor a inserir:");
        if (valor != null && !valor.isBlank()) {
            lista.add(0, valor); // Insere no início
        }
    }

    private void simularEnfileirarFinal() {
        String valor = JOptionPane.showInputDialog("Valor a inserir:");
        if (valor != null && !valor.isBlank()) {
            lista.add(valor); // Adiciona ao final
        }
    }

    private void simularInserirEmPosicaoEspecifica() {
        try {
            String valor = JOptionPane.showInputDialog("Valor a inserir:");
            String indiceStr = JOptionPane.showInputDialog("Posição para inserir:");
            if (valor != null && !valor.isBlank() && indiceStr != null) {
                int indice = Integer.parseInt(indiceStr);
                if (indice >= 0 && indice <= lista.getSize()) { // Verifica se o índice é válido
                    lista.add(indice, valor); // Insere na posição especificada
                } else {
                    JOptionPane.showMessageDialog(null, "Índice inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(null, "Valor do índice inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void simularRemoverDePosicaoEspecifica() {
        try {
            String indiceStr = JOptionPane.showInputDialog("Posição para remover:");
            if (indiceStr != null) {
                int indice = Integer.parseInt(indiceStr);
                if (indice >= 0 && indice < lista.getSize()) { // Verifica se o índice é válido
                    valorDesenfileirado = lista.remove(indice).toString(); // Remove e guarda o valor removido
                    JOptionPane.showMessageDialog(null, "Removido: " + valorDesenfileirado);
                } else {
                    JOptionPane.showMessageDialog(null, "Índice inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(null, "Valor do índice inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void simularAlterarPosicaoEspecifica() {
        String indiceStr = JOptionPane.showInputDialog("Posição para alterar:");
        String valor = JOptionPane.showInputDialog("Valor a adicionar:");
        
        if (valor != null && !valor.isBlank() && indiceStr != null) {
            try {
                int indice = Integer.parseInt(indiceStr);
                if (indice >= 0 && indice < lista.getSize()) { 
                    lista.set(indice, valor); // Altera na posição especificada
                } else {
                    JOptionPane.showMessageDialog(null, "Índice inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException exc) {
                JOptionPane.showMessageDialog(null, "Valor do índice inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


private void desenharSeta(double xInicial, double yInicial, double xFinal, double yFinal, int tamanho, Color cor, boolean curva, boolean vazio) {
    if (xInicial == xFinal && yInicial == yFinal) {
        return; // Não desenha se os pontos forem iguais.
    }

    if (curva) {
        // Desenha a seta curvada
        int controleX = (int) ((xInicial + xFinal) / 2);
        int controleY = (int) (yInicial - 10); // Ajuste a altura da curva para 10 pixels

        // Desenha a curva usando Bezier
        drawSplineSegmentBezierQuadratic(xInicial, yInicial, controleX, controleY, xFinal, yFinal, 1, cor);

        // Calcula o ângulo para a ponta da seta na extremidade da curva
        if (vazio){
            drawLine(xFinal, yFinal + 5, xFinal + 5, yFinal - 5, cor);
            drawLine(xFinal, yFinal + 15, xFinal + 10, yFinal - 5, cor); 
        } else {
            double angulo = Math.atan2(yFinal - controleY, xFinal - controleX);
            drawLine(xFinal, yFinal,
                    xFinal - Math.cos(angulo - Math.PI / 6) * tamanho,
                    yFinal - Math.sin(angulo - Math.PI / 6) * tamanho,
                    cor);
            drawLine(xFinal, yFinal,
                    xFinal - Math.cos(angulo + Math.PI / 6) * tamanho,
                    yFinal - Math.sin(angulo + Math.PI / 6) * tamanho,
                    cor);
        }
    } else {
        // Desenha uma seta reta
        drawLine(xInicial, yInicial, xFinal, yFinal, cor);

        if (vazio){
            drawLine(xFinal, yFinal + 5, xFinal + 5, yFinal - 5, cor);
            drawLine(xFinal, yFinal + 15, xFinal + 10, yFinal - 5, cor); 
        } else {
            // Desenha a ponta da seta
            double angulo = Math.atan2(yFinal - yInicial, xFinal - xInicial);
            drawLine(xFinal, yFinal,
                    xFinal - Math.cos(angulo - Math.PI / 6) * tamanho,
                    yFinal - Math.sin(angulo - Math.PI / 6) * tamanho,
                    cor);
            drawLine(xFinal, yFinal,
                    xFinal - Math.cos(angulo + Math.PI / 6) * tamanho,
                    yFinal - Math.sin(angulo + Math.PI / 6) * tamanho,
                    cor);
        }
    }
}

    private void modoNoturno() {
        // Troca as cores
        if (getBackground().equals(BLACK)) {
            setBackground(WHITE);  // Muda o fundo para branco
            fonte = BLACK;          // Muda a fonte para preto
        } else {
            setBackground(BLACK);   // Retorna o fundo para preto
            fonte = GRAY;           // Muda a fonte para branco
        }
    }
   
    public static void main( String[] args ) {
        new SimuladorLista();
    }
}