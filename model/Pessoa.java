package model;
import java.io.Serializable;
import java.time.LocalDate;
import Enum.Genero;

public abstract class Pessoa implements Serializable {
    
    String nome;
    String cpf;
    LocalDate dataNascimento;
    Genero genero;
    Endereco endereco;
    int matricula;
    Double salario;
    String departamento;
    Integer cargaHoraria;
    LocalDate dataIngresso;
    
    

    public Pessoa(){

    }

    public Pessoa(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco, int matricula, Double salario, String departamento, Integer cargaHoraria, LocalDate dataIngresso){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.endereco = endereco;
        this.matricula = matricula;
        this.salario = salario;
        this.departamento = departamento;
        this.cargaHoraria = cargaHoraria;
        this.dataIngresso = dataIngresso;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public LocalDate getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

}
