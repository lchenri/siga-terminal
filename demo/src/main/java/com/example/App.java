package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App 
{

    private static Scanner scan = new Scanner(System.in);

    protected static Gerenciamento gerenciamento = new Gerenciamento();

    public static void inicio() {
        int escolha;
        do {
            System.out.println("Bem vindo ao sistema de gerenciamento de matrícula: ");
            System.out.println("1 - Logar como aluno");
            System.out.println("2 - Logar como administrador");
            System.out.println("3 - Sair");
            System.out.println("Sua escolha: ");
            escolha = scan.nextInt();
            scan.nextLine();
            if(escolha == 1){
                System.out.println("Digite sua matrícula: ");
                String matricula = scan.nextLine();
                boolean achouAluno = false;
                List<Aluno> listaAlunos = gerenciamento.getListaAlunos();
                for (Aluno aluno : listaAlunos) {
                    if(aluno.getMatricula().equals(matricula)){
                        System.out.println("Logado como aluno");
                        achouAluno = true;
                        aluno.listaOpcoesAluno();
                    }
                }
                if(!achouAluno){
                    System.out.println("Aluno não encontrado");
                }
            } else if(escolha == 2){
                Administrador admin = new Administrador();
            } else if(escolha == 3){
                System.out.println("Saindo...");
            } else {
                System.out.println("Escolha inválida");
            }
        } while (escolha != 3);

    }
    public static void main(String[] args) {
        inicio();
    }
}
