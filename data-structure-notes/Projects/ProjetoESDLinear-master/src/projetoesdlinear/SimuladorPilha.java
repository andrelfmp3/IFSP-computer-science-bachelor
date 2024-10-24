package projetoesdlinear;

import aesd.ds.exceptions.EmptyStackException;
import aesd.ds.implementations.linear.LinkedStack;
import aesd.ds.interfaces.Stack;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import projetoesdlinear.engine.Engine;

public class SimuladorPilha extends Engine {

    private Stack<String> pilha;
    private String valorDesempilhado;
    private Color fonte = BLACK;
    private int raio;
    private int distanciaEntreElementos;
    private int tamanhoFonte;
    private int margemBaixo;

    public SimuladorPilha() {

        super( 
            800,                
            600,                  
            "Simulador de Pilha", 
            true,                 
            60 );                 
    }

    @Override
    public void criar() {
       
        pilha = new LinkedStack<>();
        
        raio = 30;
        distanciaEntreElementos = 20;
        tamanhoFonte = 20;
        margemBaixo = 80;
        
        pilha.push( "a" );
        pilha.push( "b" );
        pilha.push( "c" );
    }

    @Override
    public void atualizar() {
    }

    @Override
    public void desenhar() {
        desenharOpcoesEstadoPilha();
        desenharPilha();
    }

    private void desenharOpcoesEstadoPilha() {
        
        int yInicial = 30;
        
        drawText( "1) Empilhar", 10, yInicial, tamanhoFonte, fonte );
        drawText( "2) Desempilhar", 10, yInicial += 30, tamanhoFonte, fonte );
        drawText( "3) Modo noturno", 10, yInicial += 30, tamanhoFonte, fonte );
        
        drawText( "Desempilhou: " + ( valorDesempilhado == null ? "nenhum" : valorDesempilhado ), 10, yInicial += 30, tamanhoFonte, BLUE );
        
        if ( pilha.isEmpty() ) {
            drawText( "Pilha vazia!", 10, yInicial += 30, tamanhoFonte, RED );
        }
    }
    
    private void desenharPilha() {
        
        int elementoAtual = 0;
        int xCentroAnterior = getScreenWidth() / 2;
        int xCentro = xCentroAnterior;
        int tamanho = pilha.getSize();
        int yInicialPilha = getScreenHeight() - margemBaixo - ( raio * 2  + distanciaEntreElementos ) * tamanho;
        
        for ( String valor : pilha ) {
            
            int yCentro = yInicialPilha + ( raio * 2  + distanciaEntreElementos ) * (elementoAtual+1);
            int yCentroAnterior = yInicialPilha + ( raio * 2  + distanciaEntreElementos ) * (elementoAtual+2);
            
            drawCircleLines( xCentro, yCentro, raio, fonte );
            drawText( valor, 
                    xCentro - measureText( valor, tamanhoFonte ) / 2, 
                    yCentro + 5,
                    tamanhoFonte,
                    fonte );
            
            // arcos    
            // ponto do início (arco de 45 graus)
            int xInicial = xCentro + (int) ( Math.cos( Math.toRadians( 45 ) ) * raio );
            int yInicial = yCentro + (int) ( Math.sin( Math.toRadians( 45 ) ) * raio );
            
            // ponto do fim (arco de 315 graus)
            int xFinal = xCentroAnterior + (int) ( Math.cos( Math.toRadians( 315 ) ) * raio );
            int yFinal = yCentroAnterior + (int) ( Math.sin( Math.toRadians( 315 ) ) * raio );

            int xControle = ( xInicial + xFinal ) / 2 + 20;
            int yControle = ( yInicial + yFinal ) / 2;
            
            drawSplineSegmentBezierQuadratic( 
                    xInicial, yInicial, 
                    xControle, yControle,
                    xFinal, yFinal, 
                    1, BLUE );
            
            if ( elementoAtual == tamanho - 1 ) {
                drawLine( xFinal - 5, yFinal, xFinal + 5, yFinal, BLUE );
                drawLine( xFinal - 10, yFinal + 5, xFinal + 10, yFinal + 5, BLUE );
            } else {
                desenharSeta( xFinal, yFinal, 8, 135, BLUE );
            }
            
            drawText( "anterior", xControle, yControle, tamanhoFonte, BLUE );
            
            elementoAtual++;
            
        }
        
        if ( elementoAtual == pilha.getSize() || pilha.isEmpty() ) {
                
            int comp = 20;
            int xFinal = xCentro - raio;
            int xInicial = xFinal - comp;
            int yCentro = yInicialPilha + ( raio * 2  + distanciaEntreElementos );
            
            if ( pilha.isEmpty() ) {
                yCentro = yInicialPilha;
            }

            drawLine( xInicial, yCentro, xFinal, yCentro, fonte );
            
            if ( pilha.isEmpty() ) {
                drawLine( xFinal, yCentro - 5, xFinal, yCentro + 5, fonte );
                drawLine( xFinal + 5, yCentro - 10, xFinal + 5, yCentro + 10, fonte );
            } else {
                desenharSeta( xFinal, yCentro, 8, 0, fonte );
            }
            
            String tLabel = "topo";
            drawText( 
                    tLabel, 
                    xInicial - measureText( tLabel, tamanhoFonte ) - 10, 
                    yCentro + 5, 
                    tamanhoFonte, 
                    fonte );

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
    
    
    @Override
    public void tratarTeclado( KeyEvent e, KeyboardEventType ket ) {
        
        if ( ket == KeyboardEventType.PRESSED ) {
            
            String valor;
            
            switch ( e.getKeyCode() ) {
                
                case KeyEvent.VK_1:
                case KeyEvent.VK_NUMPAD1:
                    simularEmpilhar();
                    break;
                    
                case KeyEvent.VK_2:
                case KeyEvent.VK_NUMPAD2:
                    simularDesempilhar();
                    break;
                    
                case KeyEvent.VK_3:
                case KeyEvent.VK_NUMPAD3:
                    modoNoturno();
                    break;
                    
            }
            
        }
        
    }

    private void simularEmpilhar() {
        
        String valor = JOptionPane.showInputDialog( "Valor a empilhar:" );
        
        if ( valor != null && !valor.isBlank() ) {
            pilha.push( valor );
        }
                    
    }
    
    private void simularDesempilhar() {
        
        try {
            valorDesempilhado = pilha.pop();
        } catch ( EmptyStackException exc ) {
            // pilha vazia, o retorno será visual
        }
                    
    }
    
    private void desenharSeta( double x, double y, int tamanho, double graus, Color cor ) {
        
        drawLine( 
                x, y, 
                x + Math.cos( Math.toRadians( graus - 135 ) ) * tamanho,
                y + Math.sin( Math.toRadians( graus - 135 ) ) * tamanho,
                cor
        );
        
        drawLine( 
                x, y, 
                x + Math.cos( Math.toRadians( graus + 135 ) ) * tamanho,
                y + Math.sin( Math.toRadians( graus + 135 ) ) * tamanho,
                cor
        );
        
    }
    
    public static void main( String[] args ) {
        new SimuladorPilha();
    }
    
}
