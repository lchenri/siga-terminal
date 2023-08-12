package com.example;

import java.util.ArrayList;
import java.util.List;

public class Gerenciamento {
    
    private List<Aluno> listaAlunos = new ArrayList<>();

    private List<Materia> listaMaterias = new ArrayList<>();

    public Gerenciamento(){

    }

    public void listarMaterias(){
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
    }

    public void addAluno(Aluno aluno){
        listaAlunos.add(aluno);
    }

    public void addMateria(Materia materia){
        listaMaterias.add(materia);
    }

    public boolean materiaIsEmpty(){
        return listaMaterias.isEmpty();
    }

    public List<Aluno> getListaAlunos() {
        return this.listaAlunos;
    }

    public void imprimeAlunos(){
        if(this.listaAlunos.isEmpty()){
            System.out.println("Não há alunos cadastrados");
        } else {
            for (Aluno aluno : listaAlunos) {
                System.out.println("--------------------------------------------------");
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Matrícula: " + aluno.getMatricula());
                System.out.println("--------------------------------------------------");
            }
        }
    }

    public List<Materia> getListaMaterias() {
        return this.listaMaterias;
    }
    
}
