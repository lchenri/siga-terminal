package com.example;

import java.util.Scanner;

public class Administrador {

    private Scanner scan = new Scanner(System.in);
    
    public Administrador(){
        System.out.println("Logado como administrador");
        listaOpcoes();
    }

    private void listaOpcoes() {
        int escolha;
        do {
            System.out.println("1 - Cadastrar matéria");
            System.out.println("2 - Cadastrar aluno");
            System.out.println("3 - Alunos Cadastrados");
            System.out.println("4 - Sair");
            System.out.println("Sua escolha: ");
            escolha = scan.nextInt();
            if(escolha == 1){
                Materia materia = new Materia();
                App.gerenciamento.addMateria(materia);
            } else if(escolha == 2){
                Aluno aluno = new Aluno();
                App.gerenciamento.addAluno(aluno);
            } else if(escolha == 3){
                App.gerenciamento.imprimeAlunos();
            } else if(escolha == 4){
                System.out.println("Saindo...");
            } else {
                System.out.println("Escolha inválida");
            }
        } while (escolha != 4);
    }

}
