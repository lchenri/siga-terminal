package com.example;

import java.util.Scanner;

public class Materia {

    private String nome;
    
    private String codigo;

    private String professor;

    private String dia;

    private String horario;

    private String sala;


    private Scanner scan = new Scanner(System.in);

    public Materia(){
        setNome();
        setCodigo();
        setProfessor();
        setDia();
        setHorario();
        setSala();
    }

    private void setNome() {
        System.out.println("Digite o nome da matéria: ");
        this.nome = scan.nextLine();
    }

    private void setCodigo() {
        System.out.println("Digite o código da matéria: ");
        this.codigo = scan.nextLine();
    }

    private void setProfessor() {
        System.out.println("Digite o nome do professor: ");
        this.professor = scan.nextLine();
    }

    private void setDia(){
        System.out.println("Digite o dia da matéria: ");
        this.dia = scan.nextLine();
    }

    private void setHorario() {
        System.out.println("Digite o horário da matéria: ");
        this.horario = scan.nextLine();
    }

    private void setSala() {
        System.out.println("Digite a sala da matéria: ");
        this.sala = scan.nextLine();
    }

    public String getNome() {
        return nome;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public String getProfessor() {
        return professor;
    }

    public String getDia() {
        return dia;
    }

    public String getHorario() {
        return horario;
    }

    public String getSala() {
        return sala;
    }


}
