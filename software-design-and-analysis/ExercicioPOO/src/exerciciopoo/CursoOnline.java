/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exerciciopoo;

/**
 *
 * @author andrelf
 */
public class CursoOnline extends Curso {
    
    // Atributos
    private String plataforma;
    
    // Construtor
    public CursoOnline(String nome, int duracaoMeses, Professor professor, Biblioteca biblioteca, String plataforma) {
        super(nome, duracaoMeses, professor, biblioteca); // construtor da classe base
        this.plataforma = plataforma;
    }
    
    // Métodos
    public String getPlataforma(){
        return plataforma;
    }
    
    public void setPlataforma(String plataforma){
        this.plataforma = plataforma;
    }
    
    @Override
    public void exibirInformacoes(){
        System.out.printf("Curso: %s, Duração: %d meses, Professor: %s, Plataforma do curso online: %s", getNome(), getDuracaoMeses(), getProfessor(), plataforma);
    }
    
}
