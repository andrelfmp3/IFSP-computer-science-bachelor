/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exerciciopoo;

/**
 *
 * @author andrelf
 */
public class Biblioteca {
    
    // Atributos
    private String nome;
    
    // Construtor
    public Biblioteca(String nome){
        this.nome = nome;
    }
    
    // Métodos
    public void exibirInformações(){
        System.out.print("Biblioteca associada: " + nome);
    } 
}
