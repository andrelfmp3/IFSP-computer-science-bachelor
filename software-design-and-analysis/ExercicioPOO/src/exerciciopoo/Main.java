/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exerciciopoo;

/**
 *
 * @author andrelf
 */
public class Main {

    public static void main(String[] args) {

        Professor professor = new Professor("Dr. Joao", "Matematica", 15);
        Biblioteca biblioteca = new Biblioteca("Biblioteca do Curso Engenharia de Software");
        Curso curso = new Curso("Engenharia de Software", 24, professor, biblioteca); // Professor e Biblioteca são objetos
        CursoOnline cursoOnline = new CursoOnline("Programação Java", 6, professor, biblioteca, "Plataforma Moodle IFSP");
        Aluno aluno = new Aluno("Maria", 20, curso);

        aluno.exibirDados();
        curso.exibirInformacoes();
        curso.iniciarAulas();
        cursoOnline.exibirInformacoes();
        professor.exibirPerfil();
    }
}



