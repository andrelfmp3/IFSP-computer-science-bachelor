/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exerciciopoo;

/**
 *
 * @author andrelf
 */
public class Curso {

    private String nome;
    private int duracaoMeses;
    private Professor professor;
    private Biblioteca biblioteca;

    public Curso(String nome, int duracaoMeses, Professor professor, Biblioteca biblioteca) {
        this.nome = nome;
        this.duracaoMeses = duracaoMeses;
        this.professor = professor;
        this.biblioteca = biblioteca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracaoMeses() {
        return duracaoMeses;
    }

    public void setDuracaoMeses(int duracaoMeses) {
        this.duracaoMeses = duracaoMeses;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void iniciarAulas() {
        System.out.println("Iniciando aula do curso " + nome);
    }
        
    public void exibirInformacoes() {
    System.out.printf("Curso: %s, Duração: %d meses, Professor: %s%n", nome, duracaoMeses, professor.getNome());
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
            
