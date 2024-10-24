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
    private Color fonte = BLACK;
    private int raio;
    private int distanciaEntreElementos;
    private int tamanhoFonte;
    private int margemBaixo;


    public SimuladorFila() {
        super(800, 600, "Simulador de Fila", true, 60);
    }
    
    private void modoNoturno() {
    // Troca as cores
        if (getBackground().equals(BLACK)) {
            setBackground(Color.WHITE);  // Muda o fundo para branco
            fonte = Color.BLACK;          // Muda a fonte para preto
        } else {
            setBackground(BLACK);         // Retorna o fundo para preto
            fonte = Color.GRAY;           // Retorna a fonte para cinza
        }
    }

    @Override
    public void criar() {
        fila = new LinkedQueue<>();
        raio = 30;
        distanciaEntreElementos = 40;
        tamanhoFonte = 20;
        margemBaixo = 80;

        // Adiciona alguns valores iniciais à fila
        fila.enqueue("a");
        fila.enqueue("b");
        fila.enqueue("c");
         
    }

    @Override
    public void atualizar() {
        // Atualizações em tempo real podem ser feitas aqui
    }

    @Override
    public void desenhar() {
        desenharOpcoesEstadoFila();
        desenharFila();
    }

    private void desenharOpcoesEstadoFila() {
        int yInicial = 30;

        drawText("1) Enfileirar", 10, yInicial, tamanhoFonte, fonte);
        drawText("2) Desenfileirar", 10, yInicial += 30, tamanhoFonte, fonte);
        drawText("3) Modo noturno", 10, yInicial += 30, tamanhoFonte, fonte);
        
        
        drawText("Desenfileirou: " + (valorDesenfileirado == null ? "nenhum" : valorDesenfileirado), 10, yInicial += 30, tamanhoFonte, BLUE);
    
        drawText("André Lyra Fernandes e Victoria Carolina Ferreira da Silva", 10, 590, tamanhoFonte, fonte);
        
        if (fila.isEmpty()) {
            drawText("Fila vazia!", 10, yInicial += 30, tamanhoFonte, RED);
        }
    }

    private void desenharFila() {
        int elementoAtual = 0;
        int yCentro = getScreenHeight() / 2;
        int xInicialFila = 200;

        for (String valor : fila) {
            int xCentro = xInicialFila + (raio * 2 + distanciaEntreElementos) * elementoAtual;

            drawCircleLines(xCentro, yCentro, raio, fonte);
            drawText(valor, 
                    xCentro - measureText(valor, tamanhoFonte) / 2, 
                    yCentro + 5, 
                    tamanhoFonte, 
                    fonte);
            
            // Desenha a seta para o próximo elemento
            if (elementoAtual < fila.getSize() - 1) {
                int xProximo = xInicialFila + (raio * 2 + distanciaEntreElementos) * (elementoAtual + 1);
                desenharSeta(xCentro + raio, yCentro, xProximo - raio, yCentro, 8, BLUE, true, false);
                drawText("anterior", (xCentro + xProximo) / 2, yCentro - 40, tamanhoFonte - 3, BLUE);
            }

            elementoAtual++;
        }
        
        // Desenhar as extremidades da fila
        int xPrimeiro = xInicialFila - 40;
        if (!fila.isEmpty()) {
            desenharSeta(xPrimeiro - raio, yCentro, xPrimeiro + 40 - raio, yCentro, 8, fonte, false, false);
            desenharSeta((fila.getSize() * 100) + xPrimeiro - raio, yCentro, (fila.getSize() * 100) + xPrimeiro + 40 - raio, yCentro, 8, BLUE, true, true);
        }

        drawText("inicio", xPrimeiro - raio - measureText("inicio", tamanhoFonte) - 10, yCentro + 5, tamanhoFonte, fonte);
        drawText("fim", xPrimeiro + (100 + 100 * fila.getSize()) - raio - measureText("fim", tamanhoFonte) - 10, yCentro + 5, tamanhoFonte, fonte);
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



    private void simularEnfileirar() {
        String valor = JOptionPane.showInputDialog("Valor a enfileirar:");
        
        if (valor != null && !valor.isBlank()) {
            fila.enqueue(valor);
        } else {
            JOptionPane.showMessageDialog(null, "Valor inválido. Por favor, insira um valor não vazio.");
        }
    }

    private void simularDesenfileirar() {
        try {
            valorDesenfileirado = fila.dequeue();
        } catch (EmptyQueueException exc) {
            JOptionPane.showMessageDialog(null, "Não é possível desenfileirar. A fila está vazia.");
        }
    }

    @Override
    public void tratarTeclado(KeyEvent e, Engine.KeyboardEventType ket) {
        if (ket == Engine.KeyboardEventType.PRESSED) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_1, KeyEvent.VK_NUMPAD1 -> simularEnfileirar();
                case KeyEvent.VK_2, KeyEvent.VK_NUMPAD2 -> simularDesenfileirar();
                case KeyEvent.VK_3, KeyEvent.VK_NUMPAD3 -> modoNoturno();
            }
        }
    }


    public static void main(String[] args) {
        new SimuladorFila();
    }
}