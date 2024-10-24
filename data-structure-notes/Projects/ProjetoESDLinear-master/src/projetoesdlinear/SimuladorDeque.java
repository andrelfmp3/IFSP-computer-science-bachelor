package projetoesdlinear;

import aesd.ds.exceptions.EmptyDequeException;
import aesd.ds.implementations.linear.LinkedDeque;
import aesd.ds.interfaces.Deque;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import projetoesdlinear.engine.Engine;

public class SimuladorDeque extends Engine {

    private Deque<String> deque;
    private String valorDesenfileirado;
    private Color fonte = BLACK;
    private int raio;
    private int distanciaEntreElementos;
    private int tamanhoFonte;

    public SimuladorDeque() {
        // cria a janela do jogo ou simulação
        super(800, 600, "Simulador de Deque", true, 60);
    }

    /**
     * Processa a entrada inicial fornecida pelo usuário e cria
     * e/ou inicializa os objetos/contextos/variáveis do jogo ou simulação.
     */
    @Override
    public void criar() {
        deque = new LinkedDeque<>();
        raio = 30;
        distanciaEntreElementos = 40; // Maior distância para a fila na horizontal
        tamanhoFonte = 20;

        deque.addFirst("a");
        deque.addLast("b");
        deque.addLast("c");
    }

    @Override
    public void atualizar() {
        // Atualizações em tempo real podem ser feitas aqui
    }

    /**
     * Desenha o estado dos objetos/contextos/variáveis do jogo ou simulação.
     */
    @Override
    public void desenhar() {
        desenharOpcoesEstadoDeque();
        desenharDeque();
    }

    public void desenharOpcoesEstadoDeque() {
        int yInicial = 30;
        drawText("1) Inserir no início  ", 10, yInicial, tamanhoFonte, fonte);
        drawText("2) Inserir no final  ", 10, yInicial += 30, tamanhoFonte, fonte);
        drawText("3) Remover do início ", 10, yInicial += 30, tamanhoFonte, fonte);
        drawText("4) Remover do final ", 10, yInicial += 30, tamanhoFonte, fonte);
        drawText("5) Modo noturno", 10, yInicial += 30, tamanhoFonte, fonte);

        drawText("Removeu: " + (valorDesenfileirado == null ? "nenhum" : valorDesenfileirado), 10, yInicial += 30, tamanhoFonte, BLUE);
        drawText("André Lyra Fernandes e Victoria Carolina Ferreira da Silva", 10, 590, tamanhoFonte, fonte);

        if (deque.isEmpty()) {
            drawText("Deque vazia!", 10, yInicial += 30, tamanhoFonte, RED);
        }
    }

    private void desenharDeque() {
        int elementoAtual = 0;
        int xInicialDeque = 200; // Posição inicial no eixo X
        int yCentro = getScreenHeight() / 2; // Centra a fila verticalmente

        for (String valor : deque) {
            int xCentro = xInicialDeque + (raio * 2 + distanciaEntreElementos) * elementoAtual;

            // Desenha o círculo e o valor
            drawCircleLines(xCentro, yCentro, raio, fonte);
            drawText(valor, xCentro - measureText(valor, tamanhoFonte) / 2, yCentro + 5, tamanhoFonte, fonte);

            // Desenha setas entre elementos
            if (elementoAtual > 0) {
                int xAnterior = xInicialDeque + (raio * 2 + distanciaEntreElementos) * (elementoAtual - 1);
                desenharSeta(xAnterior + raio, yCentro, xCentro - raio, yCentro, 8, BLUE, true, false);
                desenharSeta(xCentro - raio, yCentro + 10, xAnterior + raio, yCentro + 10, 8, BLUE, true, false);
                drawText("anterior", xAnterior + raio, yCentro - 40, tamanhoFonte - 4, BLUE);
                drawText("próximo", xAnterior + raio, yCentro + 55, tamanhoFonte - 4, BLUE);
            }

            elementoAtual++;
        }

        // Desenha o marcador de "inicio"
        int xPrimeiro = xInicialDeque - 40;
        int fim = xInicialDeque + (raio * 2 + distanciaEntreElementos) * (deque.getSize() - 1);
        if (!deque.isEmpty()) {
            desenharSeta(xPrimeiro - raio, yCentro, 40 + xPrimeiro - raio, yCentro, 8, fonte, false, false);
            desenharSeta((deque.getSize() * 100) + xPrimeiro - raio, yCentro, (deque.getSize() * 100) + xPrimeiro + 40 - raio, yCentro, 8, BLUE, true, true);
        }
        drawText("inicio", xPrimeiro - raio - measureText("inicio", tamanhoFonte) - 10, yCentro + 5, tamanhoFonte, fonte);
        drawText("fim", xPrimeiro + (100 + 100 * deque.getSize()) - raio - measureText("fim", tamanhoFonte) - 10, yCentro + 5, tamanhoFonte, fonte);
    }

    @Override
    public void tratarTeclado(KeyEvent e, Engine.KeyboardEventType ket) {
        if (ket == Engine.KeyboardEventType.PRESSED) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_1, KeyEvent.VK_NUMPAD1 -> simularEnfileirarInicio();
                case KeyEvent.VK_2, KeyEvent.VK_NUMPAD2 -> simularEnfileirarFinal();
                case KeyEvent.VK_3, KeyEvent.VK_NUMPAD3 -> simularDesenfileirarInicio();
                case KeyEvent.VK_4, KeyEvent.VK_NUMPAD4 -> simularDesenfileirarFim();
                case KeyEvent.VK_5, KeyEvent.VK_NUMPAD5 -> modoNoturno(); // Chama o modo noturno
            }
        }
    }


    private void simularEnfileirarInicio() {
        String valor = JOptionPane.showInputDialog("Valor no início:");

        if (valor != null && !valor.isBlank()) {
            deque.addFirst(valor);
        }
    }

    private void simularEnfileirarFinal() {
        String valor = JOptionPane.showInputDialog("Valor no final:");

        if (valor != null && !valor.isBlank()) {
            deque.addLast(valor);
        }
    }

    private void simularDesenfileirarInicio() {
        try {
            valorDesenfileirado = deque.removeFirst();
        } catch (EmptyDequeException exc) {
            JOptionPane.showMessageDialog(null, "Não é possível remover. O deque está vazio.");
        }
    }

    private void simularDesenfileirarFim() {
        try {
            valorDesenfileirado = deque.removeLast();
        } catch (EmptyDequeException exc) {
            JOptionPane.showMessageDialog(null, "Não é possível desenfileirar. O deque está vazio.");
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
            if (vazio) {
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

            if (vazio) {
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

    public static void main(String[] args) {
        new SimuladorDeque();
    }
}
