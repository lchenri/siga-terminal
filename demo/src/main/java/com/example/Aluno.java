package com.example;

import java.util.Scanner;

public class Aluno {

    private String nome;

    private String matricula;

    private Scanner scan = new Scanner(System.in);

    public Aluno(){
        setNome();
        setMatricula();
    }

    private void setNome() {
        System.out.println("Digite seu nome");
        this.nome = scan.nextLine();
    }

    private void setMatricula() {
        System.out.println("Digite sua matrícula");
        this.matricula = scan.nextLine();
    }

    public String getMatricula() {
        return matricula;
    }

    public void listaOpcoesAluno() {
        int escolha;
        do {
            System.out.println("1 - Listar matérias");
            System.out.println("2 - Solicitar matrícula");
            System.out.println("3 - Sair");
            System.out.println("Sua escolha: ");
            escolha = scan.nextInt();
            if(escolha == 1){
                System.out.println("Listando matérias...");
                App.gerenciamento.listarMaterias();
            } else if(escolha == 2){
                System.out.println("Saindo...");
            } else {
                System.out.println("Escolha inválida");
            }
        } while (escolha != 2);
    }


}
