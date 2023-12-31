package com.example;

import java.util.List;
import java.util.Scanner;

public class App 
{

    private static Scanner scan = new Scanner(System.in);

    public static void inicio() {
        int escolha;
        do {
            System.out.println("Bem vindo ao sistema de gerenciamento de matrícula: ");
            System.out.println("1 - Logar como aluno.");
            System.out.println("2 - Logar como administrador.");
            System.out.println("3 - Sair.");
            System.out.println("Sua escolha: ");
            escolha = scan.nextInt();
            scan.nextLine();
            if(escolha == 1){
                System.out.println("Digite sua matrícula: ");
                String matricula = scan.nextLine();
                boolean achouAluno = false;
                List<Aluno> listaAlunos = Aluno.getListaAlunos();
                for (Aluno aluno : listaAlunos) {
                    if(aluno.getMatricula().equals(matricula)){
                        System.out.println("Logado como aluno.");
                        achouAluno = true;
                        aluno.listaOpcoesAluno();
                    }
                }
                if(!achouAluno){
                    System.out.println();
                    System.out.println("Aluno não encontrado!");
                    System.out.println();
                }
            } else if(escolha == 2){
                System.out.println("Digite seu login: ");
                String login = scan.nextLine();
                System.out.println("Digite sua senha: ");
                String senha = scan.nextLine();
                if(login.equals("admin") && senha.equals("admin")){
                    System.out.println("Logado como administrador.");
                    Administrador admin = new Administrador();
                } else {
                    System.out.println("Login ou senha incorretos.");
                }
            } else if(escolha == 3){
                System.out.println("Saindo...");
            } else {
                System.out.println("Escolha inválida.");
            }
        } while (escolha != 3);

    }
    public static void main(String[] args) {
        inicio();
    }
}
