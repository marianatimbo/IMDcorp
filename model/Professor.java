package model;
import java.time.LocalDate;
import java.util.List;
import java.io.Serializable;

import Enum.*;

public class Professor extends Pessoa implements Funcionario, Serializable{
    private int matricula;
    private Double salario;
    private String departamento;
    private Integer cargaHoraria;
    private LocalDate dataIngresso;

    Nivel nivelProfessor;
    Formacao formacaoProfessor;
    List<String> disciplinas;

    public Professor(){
        super();
    }

    public Professor(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco, Nivel nivelProfessor, Formacao formacaoProfessor, List<String> disciplinas, int matricula, Double salario, String departamento, Integer cargaHoraria,LocalDate dataIngresso){
        super(nome, cpf, dataNascimento, genero, endereco);
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

    @Override
    public int getMatricula() {
        return matricula;
    }

    @Override
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public Double getSalario() {
        return salario;
    }

    @Override
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String getDepartamento() {
        return departamento;
    }

    @Override
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public LocalDate getDataIngresso() {
        return dataIngresso;
    }

    @Override
    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

}
