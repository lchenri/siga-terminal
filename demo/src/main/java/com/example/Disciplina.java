package com.example;

import java.util.List;
import java.util.Scanner;

public class Disciplina {

    private String nome;
    
    private String codigo;

    private String professor;

    private String dia;

    private String horario;

    private String sala;


    private Scanner scan = new Scanner(System.in);

    public Disciplina(){
        setNome();
        setCodigo();
        setProfessor();
        setDia();
        setHorario();
        setSala();
    }

    private void setNome() {
        System.out.println("Digite o nome da disciplina: ");
        this.nome = scan.nextLine();
    }

    private boolean verificaDepartamento(){
        String codigoDepartamento = this.codigo.substring(0, 3);
        for (char caractere : codigoDepartamento.toCharArray()) {
            if(!Character.isLetter(caractere)){
                return false;
            }
        }
        return true;
    }

    private boolean verificaDisciplina(){
        String codigoDisciplina = this.codigo.substring(3, 6);
        for (char caractere : codigoDisciplina.toCharArray()) {
            if(!Character.isDigit(caractere)){
                System.out.println(caractere +"Não é dígito");
                return false;
            }
        }
        System.out.println("Deu certo. Retorna True");
        return true;
    }

    private boolean verificaDisponibilidadeCodigo(){
        List<Disciplina> listaDisciplinas = App.gerenciamento.getListaDisciplinas();
        for (Disciplina materia : listaDisciplinas) {
            if(materia.getCodigo().equals(this.codigo)){
                return false;
            }
        }
        if(this.codigo.length() != 6){
            return false;
        }
        if(!verificaDepartamento() || !verificaDisciplina()){
            return false;
        }
        return true;
    }

    private void setCodigo() {
        System.out.println("Digite o código da disciplina: ");
        this.codigo = scan.nextLine();
        while(!verificaDisponibilidadeCodigo()){
            System.out.println("Código indisponível ou código inválido. O formato deve ser(XXX000), onde XXX é o departamento e 000 é o número da disciplina (Ex: MAT123)");
            System.out.println("Digite o código da disciplina: ");
            this.codigo = scan.nextLine();        
        }
    }

    private void setProfessor() {
        System.out.println("Digite o nome do professor: ");
        this.professor = scan.nextLine();
    }

    private void setDia(){
        System.out.println("Digite o dia da disciplina: ");
        this.dia = scan.nextLine();
    }

    private void setHorario() {
        System.out.println("Digite o horário da disciplina: ");
        this.horario = scan.nextLine();
    }

    private boolean verificaDisponibilidadeSala(){
        List<Disciplina> listadisciplinas = App.gerenciamento.getListaDisciplinas();
        for (Disciplina disciplina : listadisciplinas) {
            if(disciplina.getDia().equals(this.dia) && disciplina.getHorario().equals(this.horario) && disciplina.getSala().equals(this.sala)){
                return false;
            }
        }
        return true;
    }

    private void setSala() {

        System.out.println("Digite a sala da disciplina: ");
        this.sala = scan.nextLine();
        while(!verificaDisponibilidadeSala()){
            System.out.println("Sala indisponível!");
            this.sala = scan.nextLine();
        }
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
