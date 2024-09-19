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

    private String nome;

    public Biblioteca(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }

    public void exibirInformacoes() {
        System.out.println("Biblioteca associada: " + nome);
    }
}