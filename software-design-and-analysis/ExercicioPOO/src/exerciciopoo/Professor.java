/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exerciciopoo;

/**
 *
 * @author andrelf
 */
public class Professor {
    
    // Atributos
    private String nome;
    private String especialidade;
    private int anosExperiencia;
    
    // Construtor
    public Professor(String nome, String especialidade, int anosExperiencia){
        this.nome = nome;
        this.especialidade = especialidade;
        this.anosExperiencia = anosExperiencia;
    }
    
    //Métodos
    public String getNome() {
            return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getEspecialidade(){
        return especialidade;
    }
    
    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }
    
    public int getAnosExperiencia(){
        return anosExperiencia;
    }
    
    public void setAnosExperiencia(int anosExperiencia){
        this.anosExperiencia = anosExperiencia;
    }
    
    public void ensinar(){
        System.out.print(nome + "está ensinando.");
    }
    
    public void avaliarAluno(Aluno aluno){
        System.out.print("Avaliano o aluno " + aluno.getNome());
    }
    
    public void exibirPerfil(){
        System.out.printf("Professor: %s, Especialidade: %s, Anos de experiência: %d", nome, especialidade, anosExperiencia);
    }

}
