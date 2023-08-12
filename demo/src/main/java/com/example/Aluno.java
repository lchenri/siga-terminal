package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aluno {

    private String nome;

    private String matricula;

    private Scanner scan = new Scanner(System.in);

    private List<Materia> listaMaterias = new ArrayList<>();

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

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void listaOpcoesAluno() {
        int escolha;
        System.out.println("--------------------------------------------------");
        System.out.println("Bem vindo " + this.nome + " ao sistema de gerenciamento de matrícula: ");
        do {
            System.out.println("1 - Listar matérias");
            System.out.println("2 - Solicitar matrícula");
            System.out.println("3 - Matérias matriculadas");
            System.out.println("4 - Sair");
            System.out.println("Sua escolha: ");
            escolha = scan.nextInt();
            scan.nextLine();
            if(escolha == 1){
                System.out.println("Listando matérias...");
                App.gerenciamento.listarMaterias();
            } else if(escolha == 2){
                solicitaMatricula();
            } else if(escolha == 3){
                System.out.println("Listando matérias matriculadas...");
                for (Materia materia : listaMaterias) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("Nome: " + materia.getNome());
                    System.out.println("Código: " + materia.getCodigo());
                    System.out.println("Professor: " + materia.getProfessor());
                    System.out.println("Dia: " + materia.getDia());
                    System.out.println("Horário: " + materia.getHorario());
                    System.out.println("Sala: " + materia.getSala());
                    System.out.println("--------------------------------------------------");
                }
            } else if (escolha ==4) {
                System.out.println("Saindo...");
            } else {
                System.out.println("Escolha inválida");
            }
        } while (escolha != 4);
    }

    private boolean verificaHora(Materia solicitada, Materia cadastrada){
        String horarioSolicitada = solicitada.getHorario();
        String horarioSolicitadaSplit[] = horarioSolicitada.split("/");
        String horarioCadastrada = cadastrada.getHorario();
        String horarioCadastradaSplit[] = horarioCadastrada.split("/");
        if(horarioSolicitadaSplit[0].trim().equals(horarioCadastradaSplit[0].trim()) || horarioSolicitadaSplit[1].trim().equals(horarioCadastradaSplit[1].trim())){
            return true;
        }
        return false;
    }

    private boolean verificaDia(Materia solicitada, Materia cadastrada){
        String diaSolicitada = solicitada.getDia();
        String diaSolicitadaSplit[] = diaSolicitada.split("/");
        String diaCadastrada = cadastrada.getDia();
        String diaCadastradaSplit[] = diaCadastrada.split("/");

        if(diaSolicitadaSplit[0].trim().equals(diaCadastradaSplit[0].trim()) || diaSolicitadaSplit[1].trim().equals(diaCadastradaSplit[1].trim())){
            return verificaHora(solicitada, cadastrada);
        }
        return false;
    }

    private void verificaConflitoHorario(Materia materia){
        boolean conflito = false;
        for (Materia materiaAluno : listaMaterias) {
            if(verificaDia(materia, materiaAluno)){
                conflito = true;
            }
        }
        if(conflito){
            System.out.println("Conflito de horário");
        } else {
            listaMaterias.add(materia);
            System.out.println("Matrícula realizada com sucesso");
        }
    }

    private void solicitaMatricula(){
        System.out.println("Digite o código da matéria que deseja se matricular");
        String codigo = scan.nextLine();
        boolean achouMateria = false;
        List<Materia> listaMaterias = App.gerenciamento.getListaMaterias();
        for (Materia materia : listaMaterias) {
            if(materia.getCodigo().equals(codigo)){
                achouMateria = true;
                verificaConflitoHorario(materia);
            }
        }
        if(!achouMateria){
            System.out.println("Matéria não encontrada");
        }
    }

}
