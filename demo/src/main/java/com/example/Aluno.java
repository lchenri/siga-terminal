package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aluno {

    private String nome;

    private String matricula;

    private Scanner scan = new Scanner(System.in);

    private List<Disciplina> listaDisciplinas = new ArrayList<>();

    private static List<Aluno> listaAlunos = new ArrayList<>();

    public Aluno(){
        setNome();
        setMatricula();
    }

    public static void addAluno(Aluno aluno){
        listaAlunos.add(aluno);
    }

    public static List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public static void imprimeAlunos(){
        if(listaAlunos.isEmpty()){
            System.out.println("Não há alunos cadastrados.");
        } else {
            for (Aluno aluno : listaAlunos) {
                System.out.println("--------------------------------------------------");
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Matrícula: " + aluno.getMatricula());
            }
        }
    }

    private void setNome() {
        System.out.println("Digite o nome do aluno:");
        this.nome = scan.nextLine();
    }

    private boolean verificaMatricula(){
        if(this.matricula.length() != 9){
            return false;
        }
        for (char caractere : this.matricula.toCharArray()) {
            if(!Character.isDigit(caractere)){
                return false;
            }
        }
        String ano = this.matricula.substring(0, 4);
        int anoAuxiliar = Integer.parseInt(ano);
        if(anoAuxiliar <= 2010 || anoAuxiliar >= 2024){
            return false;
        }
        String curso = this.matricula.substring(4, 6);
        for(char caractere : curso.toCharArray()){
            if(!Character.isDigit(caractere)){
                return false;
            }
        }
        return true;
    }

    private void setMatricula() {
        System.out.println("Digite a matrícula do aluno:");
        this.matricula = scan.nextLine();
        while(!verificaMatricula()){
            System.out.println("Matrícula inválida. O formato da matrícula deve ser: AAAACCLLL, onde AAAA é o ano de ingresso, CC é o código do curso e LLL é o número da matrícula.");
            System.out.println("Digite a matrícula do aluno:");
            this.matricula = scan.nextLine();
        }
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
            System.out.println("1 - Listar disciplinas.");
            System.out.println("2 - Solicitar disciplina.");
            System.out.println("3 - Disciplinas matriculadas.");
            System.out.println("4 - Sair.");
            System.out.println("Sua escolha: ");
            escolha = scan.nextInt();
            scan.nextLine();
            if(escolha == 1){
                if(Disciplina.disciplinaIsEmpty()){
                    System.out.println("Não há disciplinas cadastradas.");
                } else{
                    System.out.println("Listando disciplinas...");
                    Disciplina.listarDisciplinas();
                }
            } else if(escolha == 2){
                solicitaMatricula();
            } else if(escolha == 3){
                System.out.println("Listando disciplinas matriculadas...");
                for (Disciplina disciplina : listaDisciplinas) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("Nome: " + disciplina.getNome());
                    System.out.println("Código: " + disciplina.getCodigo());
                    System.out.println("Professor: " + disciplina.getProfessor());
                    String auxiliarDia[] = disciplina.getDia().split("/");
                    String auxiliarHora[] = disciplina.getHorario().split("/");
                    System.out.println("Dias de aula: ");
                    for(int i = 0; i < 2; i++){
                        auxiliarDia[i] = auxiliarDia[i].trim();
                        auxiliarHora[i] = auxiliarHora[i].trim();
                        System.out.println(auxiliarDia[i] + " : " + auxiliarHora[i]);
                    }
                    System.out.println("Sala: " + disciplina.getSala());
                    System.out.println("--------------------------------------------------");
                }
            } else if (escolha ==4) {
                System.out.println("Saindo...");
            } else {
                System.out.println("Escolha inválida.");
            }
        } while (escolha != 4);
    }

    private boolean verificaHora(Disciplina solicitada, Disciplina cadastrada){
        String horarioSolicitada = solicitada.getHorario();
        String horarioSolicitadaSplit[] = horarioSolicitada.split("/");
        String horarioCadastrada = cadastrada.getHorario();
        String horarioCadastradaSplit[] = horarioCadastrada.split("/");
        if(horarioSolicitadaSplit[0].trim().equals(horarioCadastradaSplit[0].trim()) || horarioSolicitadaSplit[1].trim().equals(horarioCadastradaSplit[1].trim())){
            return true;
        }
        return false;
    }

    private boolean verificaDia(Disciplina solicitada, Disciplina cadastrada){
        String diaSolicitada = solicitada.getDia();
        String diaSolicitadaSplit[] = diaSolicitada.split("/");
        String diaCadastrada = cadastrada.getDia();
        String diaCadastradaSplit[] = diaCadastrada.split("/");

        if(diaSolicitadaSplit[0].trim().equals(diaCadastradaSplit[0].trim()) || diaSolicitadaSplit[1].trim().equals(diaCadastradaSplit[1].trim())){
            return verificaHora(solicitada, cadastrada);
        }
        return false;
    }

    private void verificaConflitoHorario(Disciplina disciplina){
        boolean conflito = false;
        for (Disciplina disciplinaAluno : listaDisciplinas) {
            if(verificaDia(disciplina, disciplinaAluno)){
                conflito = true;
            }
        }
        if(conflito){
            System.out.println("Conflito de horário!");
        } else {
            listaDisciplinas.add(disciplina);
            System.out.println("Matrícula realizada com sucesso.");
        }
    }

    private void solicitaMatricula(){
        System.out.println("Digite o código da disciplina que deseja se matricular:");
        String codigo = scan.nextLine();
        boolean achouMateria = false;
        List<Disciplina> listaDisciplinas = Disciplina.getListaDisciplinas();
        for (Disciplina disciplina : listaDisciplinas) {
            if(disciplina.getCodigo().equals(codigo)){
                achouMateria = true;
                verificaConflitoHorario(disciplina);
            }
        }
        if(!achouMateria){
            System.out.println("Disciplina não encontrada.");
        }
    }

}
