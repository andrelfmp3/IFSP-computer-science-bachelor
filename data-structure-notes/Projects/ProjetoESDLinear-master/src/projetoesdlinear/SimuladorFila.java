package projetoesdlinear;

import aesd.ds.exceptions.EmptyQueueException;
import aesd.ds.implementations.linear.LinkedQueue;
import aesd.ds.interfaces.Queue;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import projetoesdlinear.engine.Engine;

public class SimuladorFila extends Engine {

    private Queue<String> fila;
    private String valorDesenfileirado;
    private int raio;
    private int distanciaEntreElementos;
    private int tamanhoFonte;

    public SimuladorFila() {
        super(
                800,
                600,
                "Simulador de Fila",
                true,
                60);
    }

    @Override
    public void criar() {
        fila = new LinkedQueue<>();
        raio = 30;
        distanciaEntreElementos = 40; // Maior distância para a fila na horizontal
        tamanhoFonte = 20;
        
        fila.enqueue("a");
        fila.enqueue("b");
        fila.enqueue("c");
    }

    @Override
    public void atualizar() {
    }

    @Override
    public void desenhar() {
        desenharOpcoesEstadoFila();
        desenharFila();
    }

    public void desenharOpcoesEstadoFila() {
        int yInicial = 30;
        drawText("1) Enfileirar", 10, yInicial, tamanhoFonte, BLACK);
        drawText("2) Desenfileirar", 10, yInicial += 30, tamanhoFonte, BLACK);

        drawText("Desenfileirou: " + (valorDesenfileirado == null ? "nenhum" : valorDesenfileirado), 10, yInicial += 30, tamanhoFonte, BLUE);

        if (fila.isEmpty()) {
            drawText("Fila vazia!", 10, yInicial += 30, tamanhoFonte, RED);
        }
    }

    private void desenharFila() {
        int elementoAtual = 0;
        int xInicialFila = 200; // Posição inicial no eixo X
        int yCentro = getScreenHeight() / 2; // Centra a fila verticalmente
        
        for (String valor : fila) {
            int xCentro = xInicialFila + (raio * 2 + distanciaEntreElementos) * elementoAtual;

            // Desenha o círculo e o valor
            drawCircleLines(xCentro, yCentro, raio, BLACK);
            drawText(valor, xCentro - measureText(valor, tamanhoFonte) / 2, yCentro + 5, tamanhoFonte, BLACK);

            // Desenha setas entre elementos
            if (elementoAtual > 0) {
                int xAnterior = xInicialFila + (raio * 2 + distanciaEntreElementos) * (elementoAtual - 1);
                desenharSeta(xAnterior + raio, yCentro, xCentro - raio, yCentro, 8, BLUE);
            }

            elementoAtual++;
        }

        // Desenha o marcador de "inicio" da fila¨
        if (!fila.isEmpty()) {
            int xPrimeiro = xInicialFila - 40;
            desenharSeta(xPrimeiro - raio , yCentro, 40 + xPrimeiro - raio, yCentro, 8, BLACK);
            drawText("inicio", xPrimeiro - raio - measureText("inicio", tamanhoFonte) - 10, yCentro + 5, tamanhoFonte, BLACK);
            int fim = 100 + 100 * fila.getSize();
            drawText("fim", xPrimeiro + fim - raio - measureText("fim", tamanhoFonte) - 10, yCentro + 5, tamanhoFonte, BLACK);
        }
    }

    private void desenharSeta(double xInicial, double yInicial, double xFinal, double yFinal, int tamanho, Color cor) {
        // Desenha linha principal da seta
        drawLine(xInicial, yInicial, xFinal, yFinal, cor);

        // Calcula o ângulo da seta
        double angulo = Math.atan2(yFinal - yInicial, xFinal - xInicial);

        // Desenha as duas linhas que formam a ponta da seta
        drawLine(xFinal, yFinal, 
                xFinal - Math.cos(angulo - Math.PI / 6) * tamanho,
                yFinal - Math.sin(angulo - Math.PI / 6) * tamanho, 
                cor);

        drawLine(xFinal, yFinal, 
                xFinal - Math.cos(angulo + Math.PI / 6) * tamanho,
                yFinal - Math.sin(angulo + Math.PI / 6) * tamanho, 
                cor);
    }

    private void simularEnfileirar() {
        String valor = JOptionPane.showInputDialog("Valor a enfileirar:");
        if (valor != null && !valor.isBlank()) {
            fila.enqueue(valor);
        }
    }

    @Override
    public void tratarTeclado(KeyEvent e, KeyboardEventType ket) {
        if (ket == KeyboardEventType.PRESSED) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_1, KeyEvent.VK_NUMPAD1 -> simularEnfileirar();
                case KeyEvent.VK_2, KeyEvent.VK_NUMPAD2 -> simularDesenfileirar();
            }
        }
    }

    private void simularDesenfileirar() {
        try {
            valorDesenfileirado = fila.dequeue();
        } catch (EmptyQueueException exc) {
            // fila vazia, o retorno será visual
        }
    }

    public static void main(String[] args) {
        new SimuladorFila();
    }
}
