import java.awt.event.MouseEvent;

/**
 * Modelo para desenvolvimento de exercícios criativos em Java 2D.
 * 
 * @author Prof. Dr. David Buzatto
 * @copyright Copyright (c) 2024
 */

public class Main extends Engine {


    private class Bolinha {

        Point2D pos;
        Point2D vel;
        double raio;
        double atrito;
        double elasticidade;
        boolean emArraste;

        void atualizar (double delta){

        if (!emArraste){
            pos.x += vel.x * delta;
            pos.y += vel.y * delta;

            if (pos.x + raio >= getScreenWidth()){
                pos.x = getScreenWidth() - raio;
                vel.x = -vel.x * elasticidade;
            } else if (pos.x - raio <= 0){
                pos.x = raio;
                vel.x = -vel.x * elasticidade;
            }

            if (pos.y+ raio >= getScreenHeight()){
                pos.y = getScreenHeight() - raio;
                vel.y = -vel.y * elasticidade;
            } else if (pos.y - raio <= 0){
                pos.y = raio;
                vel.y = -vel.y * elasticidade;
            }

            vel.x = vel.x * atrito;
            vel.y = vel.y * atrito + GRAVIDADE;

            }
        }

        void desenhar(){
            drawCircle( pos.x, pos.y, raio, BLUE );
        }

        boolean intercepta( double x, double y ){

            double cat1 = x - pos.x;
            double cat2 = y - pos.y;

            return cat1 * cat1 + cat2 * cat2 <= raio * raio;
        }
    }

    private static final double GRAVIDADE = 50;
    private Bolinha bolinha;

    private double xOffset;
    private double yOffset;

    private double xAnterior;
    private double yAnterior;

    public Main() {

        // cria a janela do jogo ou simulação
        super( 
            800,                  // 800 pixels de largura
            600,                  // 600 pixels de largura
            "Título da Janela",   // título da janela
            true,                 // ativa a suavização (antialiasing)
            30 );                 // 60 quadros por segundo

    }

    /**
     * Processa a entrada inicial fornecida pelo usuário e cria
     * e/ou inicializa os objetos/contextos/variáveis do jogo ou simulação.
     */
    @Override
    public void criar() { // Executado uma vez, antes de criar tabela

        bolinha = new Bolinha();

        bolinha.pos = new Point2D (getScreenWidth() / 2, getScreenHeight() / 2);
        bolinha.vel = new Point2D(300, 300);
        bolinha.raio = 50;
        bolinha.atrito = 0.99;
        bolinha.elasticidade = 0.9;

    }

    /**
     * Atualiza os objetos/contextos/variáveis do jogo ou simulação.
     */
    @Override
    public void atualizar() {

        double delta = getFrameTime();
        bolinha.atualizar( delta );
        

        
    }

    /**
     * Desenha o estado dos objetos/contextos/variáveis do jogo ou simulação.
     */
    @Override
    public void desenhar() {
        bolinha.desenhar();
    }

    @Override
    public void tratarMouse( MouseEvent e, MouseEventType met ) {
        
        if ( met == MouseEventType.PRESSED){
            if (bolinha.intercepta( e.getX(), e.getY())){
                bolinha.emArraste = true;
                xOffset = bolinha.pos.x - e.getX();
                yOffset = bolinha.pos.y - e.getX();
            }
        } else if (met == MouseEventType.RELEASED){
            bolinha.emArraste = false;
        } else if (met == MouseEventType.DRAGGED){
            if (bolinha.emArraste){
                bolinha.pos.x = e.getX() + xOffset;
                bolinha.pos.y = e.getY() + yOffset;

                double delta = getFrameTime();
                bolinha.vel.x = (bolinha.pos.x - xAnterior) / delta;
                bolinha.vel.y = (bolinha.pos.y - yAnterior) / delta;

                xAnterior = bolinha.pos.x;
                yAnterior = bolinha.pos.x;
            }

        }

    }

    public static void main( String[] args ) {
        new Main();
    }

}