package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Disciplina {

    private String nome;

    private String codigo;

    private String professor;

    private String dia;

    private String horario;

    private String sala;

    private static List<Disciplina> listaDisciplinas = new ArrayList<>();

    private Scanner scan = new Scanner(System.in);

    public Disciplina(){
        setNome();
        setCodigo();
        setProfessor();
        setDia();
        setHorario();
        setSala();
    }

    public static void listarDisciplinas(){
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

    public static void addDisciplina(Disciplina disciplina){
        listaDisciplinas.add(disciplina);
    }

    public static List<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public static boolean disciplinaIsEmpty(){
        return listaDisciplinas.isEmpty();
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
                return false;
            }
        }
        return true;
    }

    private boolean verificaDisponibilidadeCodigo(){
        List<Disciplina> listaDisciplinas = Disciplina.getListaDisciplinas();
        for (Disciplina disciplina : listaDisciplinas) {
            if(disciplina.getCodigo().equals(this.codigo)){
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
        System.out.println("Digite os dias da disciplina (Exemplo: Segunda-Feira / Terca-feira): ");
        this.dia = scan.nextLine();
    }

    private void setHorario() {
        String auxiliarInput;
        String copiaDia = this.dia;
        String diasDeAula[] = copiaDia.trim().split("/");
        for(int i = 0; i < diasDeAula.length; i++){
            diasDeAula[i] = diasDeAula[i].trim();
            System.out.println("Digite o horário da disciplina para o dia " + diasDeAula[i] + " :");
            auxiliarInput = scan.nextLine();
            if(this.horario != null)
                //poderia usar String builder aqui!
                this.horario += auxiliarInput;
            else{
                this.horario = auxiliarInput + " / ";
            }
        }
    }

    private boolean verificaDisponibilidadeSala(){
        List<Disciplina> listadisciplinas = Disciplina.getListaDisciplinas();
        for (Disciplina disciplina : listadisciplinas) {
            if(disciplina.getDia().replace(" ", "").equals(this.dia.replace(" ", "")) && disciplina.getHorario().replace(" ", "").equals(this.horario.replace(" ", "")) && disciplina.getSala().replace(" ", "").equals(this.sala.replace(" ", ""))){
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
