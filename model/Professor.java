package model;
import java.time.LocalDate;
import java.util.List;

import Enum.*;

public class Professor extends Pessoa implements Funcionario{
    Nivel nivelProfessor;
    Formacao formacaoProfessor;
    List<String> disciplinas;

    public Professor(){
        super();
    }

    public Professor(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco, Nivel nivelProfessor, Formacao formacaoProfessor, List<String> disciplinas, int matricula, Double salario, String departamento, Integer cargaHoraria,LocalDate dataIngresso){
        super(nome, cpf, dataNascimento, genero, endereco, matricula,salario, departamento, cargaHoraria, dataIngresso);

        this.nivelProfessor = nivelProfessor;
        this.formacaoProfessor = formacaoProfessor;
        this.disciplinas = disciplinas;
        this.matricula = matricula;
        this.salario = salario;
        this.departamento = departamento;
        this.cargaHoraria = cargaHoraria;
        this.dataIngresso = dataIngresso;
    }
    
    @Override
    public Double calculaSalario(){
        //...
        return salario;
    }

    public Nivel getNivelProfessor() {
        return nivelProfessor;
    }

    public void setNivelProfessor(Nivel nivelProfessor) {
        this.nivelProfessor = nivelProfessor;
    }

    public Formacao getFormacaoProfessor() {
        return formacaoProfessor;
    }

    public void setFormacaoProfessor(Formacao formacaoProfessor) {
        this.formacaoProfessor = formacaoProfessor;
    }

    public List<String> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<String> disciplinas) {
        this.disciplinas = disciplinas;
    }

}
