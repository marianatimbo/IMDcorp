package model;
import java.time.LocalDate;
import java.util.List;

import Enum.*;

public class Professor extends Pessoa implements Funcionario{
    private Nivel nivelProfessor;
    private Formacao formacaoProfessor;
    private List<String> disciplinas;

    public Professor(){
        super();
    }

    public Professor(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco, int matricula, String departamento, Integer cargaHoraria,LocalDate dataIngresso, Nivel nivelProfessor, Formacao formacaoProfessor, List<String> disciplinas ){
        super(nome, cpf, dataNascimento, genero, endereco, matricula, departamento, cargaHoraria, dataIngresso, 0.0);

        this.nivelProfessor = nivelProfessor;
        this.formacaoProfessor = formacaoProfessor;
        this.disciplinas = disciplinas;
    }
    
    @Override
    public Double calculaSalario(){

        Double salarioBase = 4000.00;
        Double salarioFinal;
        double percentualNivel = (0.05 * (this.nivelProfessor.ordinal()) * salarioBase);
        Double percentualFormacao = 0.0;   

        switch (this.formacaoProfessor) {
            case ESPECIALIZACAO:
                percentualFormacao = salarioBase * 0.25; 
                break;

            case MESTRADO:
                percentualFormacao =  salarioBase * 0.5; 
                break;

            case DOUTORADO:
                percentualFormacao = salarioBase * 0.75; 
                break;
        
            default:
                break;
        }
        
        salarioFinal = salarioBase + percentualNivel + percentualFormacao;
        this.setSalario(salarioFinal);
        return salarioFinal;
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
