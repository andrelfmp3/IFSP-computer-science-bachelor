/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exerciciopoo;

/**
 *
 * @author andrelf
 */
public class Aluno {
    
    // Atributos
    private String nome;
    private int idade;
    private Curso curso;
    
    // Construtor
    public Aluno(String nome, int idade, Curso curso){
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
    }
    
    // Métodos
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public int getIdade(){
        return idade;
    }
    
    public void setIdade(int idade){
        this.idade = idade;
    }
    
  
    public Curso getCurso(){
        return curso;
    }
    
    public void setCurso(Curso curso){
        this.curso = curso;
    }
    
    public void exibirDados(){
        System.out.printf("Nome: %s, Idade: %s, Curso: %d", nome, idade, curso);
    }
    
    public void estudar(){
        System.out.println("Aluno estudando");
    }
}
