package utils;

import java.time.LocalDate;
import java.util.List;

import DAO.BancoDAO;
import Enum.*;
import model.*;


public class Operacoes {
    static BancoDAO banco = BancoDAO.getInstance();

    public void cadastrarProfessor(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco, Nivel nivelProfessor, Formacao formacaoProfessor, List<String> disciplinas, int matricula, Double salario, String departamento, Integer cargaHoraria,LocalDate dataIngresso){

        Pessoa pessoa = buscarFuncionario(matricula);
        if(pessoa == null){
            Professor professor = new Professor(nome, cpf, dataNascimento, genero, endereco, nivelProfessor, formacaoProfessor, disciplinas, matricula, salario, departamento, cargaHoraria, dataIngresso);

            banco.getArrayPessoas().add(professor);
            banco.salvarDados();
            System.out.println("Professor cadastrado com sucesso!");
        }
        else{
            System.out.println("Essa matrícula já está cadastrado!");
        }
        
    }

    public void cadastrarTecnicoADM(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco,Nivel nivelTecnico, Formacao formacaoTecnico, Boolean insalubridade, Boolean funcaoGratificada, int matricula, Double salario, String departamento, Integer cargaHoraria,LocalDate dataIngresso) {
        
        Pessoa pessoa = buscarFuncionario(matricula);
        if(pessoa == null){
            TecnicoADM tecnicoADM = new TecnicoADM(nome, cpf, dataNascimento, genero, endereco, nivelTecnico, formacaoTecnico, insalubridade, funcaoGratificada, matricula, salario, departamento, cargaHoraria,dataIngresso );

            banco.getArrayPessoas().add(tecnicoADM);
            System.out.println("Técnico ADM cadastrado com sucesso!");
       }
       else{
            System.out.println("Essa matrícula já está cadastrado!");
       }
        
    }

    public void listarProfessores(){
        for(Pessoa pessoa : banco.getArrayPessoas()){
            if(pessoa instanceof Professor professor){
                imprimirProfessor(professor);
            }
        }
    }

    public void listarTecnicosADM(){
        for(Pessoa pessoa : banco.getArrayPessoas()){
            if(pessoa instanceof TecnicoADM tecnicoADM){
                imprimirTecnicoADM(tecnicoADM);
            }
        }
    }

    public void deletarProfessor(int matricula){
        Pessoa pessoa = buscarFuncionario(matricula);

        if(pessoa == null){
            System.out.println("Funcionário não encontrado");
        }
        else if(pessoa instanceof Professor){
            banco.getArrayPessoas().remove(pessoa);
            banco.salvarDados();

            System.out.println("Professor removido com sucesso!");
        }
        else{
            System.out.println("Matrícula não associada a professor.");
        }
    }

    public void deletarTecnicoADM(int matricula){
        Pessoa pessoa = buscarFuncionario(matricula);

        if(pessoa == null){
            System.out.println("Funcionário não encontrado");
        }
        else if(pessoa instanceof TecnicoADM){
            banco.getArrayPessoas().remove(pessoa);
            banco.salvarDados();

            System.out.println("Técnico removido com sucesso!");
        }
        else{
            System.out.println("Matrícula não associada a Técnico ADM.");
        }
    }
        

    public void buscarProfessor(int matricula){
       Pessoa pessoa = buscarFuncionario(matricula);

        if(pessoa == null){
            System.out.println("Funcionário não encontrado.");
        }
        else if(pessoa instanceof Professor professor){
            imprimirProfessor(professor);
        }
        else{
            System.out.println("Matrícula não associada a professor.");
        }
    }

    public void buscarTecnicoADM(int matricula){
        Pessoa pessoa = buscarFuncionario(matricula);

        if(pessoa == null){
            System.out.println("Funcionário não encontrado.");
        }
        else if(pessoa instanceof TecnicoADM tecnicoADM){
            imprimirTecnicoADM(tecnicoADM);
        }
        else{
            System.out.println("Matrícula não associada a técnico.");
        }
    }

    public void CalcularSalario(){
                
    }

    public Pessoa buscarFuncionario(int matricula){
        for(Pessoa p : banco.getArrayPessoas()){
            if(p.getMatricula() == matricula){
                return p;
            }
        }
        return null;
    }

    public void imprimirProfessor(Professor professor){
        System.out.println("Nome: " + professor.getNome());
        System.out.println("Disciplinas: " + professor.getDisciplinas());
    }

    public void imprimirTecnicoADM(TecnicoADM tecnicoADM){
        System.out.println("Nome: " + tecnicoADM.getNome());
        System.out.println("Função: " + tecnicoADM.getFuncaoGratificada());
    }
}
