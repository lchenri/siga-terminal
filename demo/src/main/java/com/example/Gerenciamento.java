package com.example;

import java.util.ArrayList;
import java.util.List;

public class Gerenciamento {
    
    private List<Aluno> listaAlunos = new ArrayList<>();

    private List<Disciplina> listaDisciplinas = new ArrayList<>();

    public Gerenciamento(){

    }

    public void listarDisciplinas(){
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
    }

    public void addAluno(Aluno aluno){
        listaAlunos.add(aluno);
    }

    public void addDisciplina(Disciplina disciplina){
        listaDisciplinas.add(disciplina);
    }

    public boolean disciplinaIsEmpty(){
        return listaDisciplinas.isEmpty();
    }

    public List<Aluno> getListaAlunos() {
        return this.listaAlunos;
    }

    public void imprimeAlunos(){
        if(this.listaAlunos.isEmpty()){
            System.out.println("Não há alunos cadastrados.");
        } else {
            for (Aluno aluno : listaAlunos) {
                System.out.println("--------------------------------------------------");
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Matrícula: " + aluno.getMatricula());
            }
        }
    }

    public List<Disciplina> getListaDisciplinas() {
        return this.listaDisciplinas;
    }

    
}
