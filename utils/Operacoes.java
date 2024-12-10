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
            System.out.println("Esse Professor já está cadastrado!");
        }
        
    }

    public void cadastrarTecnicoADM(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco,Nivel nivelTecnico, Formacao formacaoTecnico, Boolean insalubridade, Boolean funcaoGratificada, int matricula, Double salario, String departamento, Integer cargaHoraria,LocalDate dataIngresso) {
        
        Pessoa pessoa = buscarFuncionario(matricula);
        if(pessoa == null){
            TecnicoADM tecnicoADM = new TecnicoADM(nome, cpf, dataNascimento, genero, endereco, nivelTecnico, formacaoTecnico, insalubridade, funcaoGratificada, matricula, salario, departamento, cargaHoraria,dataIngresso );

            banco.getArrayPessoas().add(tecnicoADM);
            System.out.println("Tecnico ADM cadastrado com sucesso!");
       }
       else{
            System.out.println("Esse Tecnico ADM já está cadastrado!");
       }
        
    }

    public void listarProfessore(){
        for(Pessoa pessoa : banco.getArrayPessoas()){
            if(pessoa instanceof Professor p){
                System.out.println("Nome: " + p.getNome());
                System.out.println("Disciplina: " + p.getDisciplinas());
            }
        }
    }

    public void listarTecnicosADM(){
        for(Pessoa pessoa : banco.getArrayPessoas()){
            if(pessoa instanceof TecnicoADM t){
                System.out.println("Nome: " + t.getNome());
                System.out.println("Disciplina: " + t.getFuncaoGratificada());
            }
        }
    }

    public void deletarProfessor(int matricula){
        Pessoa pessoa = buscarFuncionario(matricula);

        if(pessoa == null){
            System.out.println("Funcionario não encontrado");
        }
        else if(pessoa instanceof Professor){
            banco.getArrayPessoas().remove(pessoa);
            banco.salvarDados();

            System.out.println("Professor removido com sucesso!");
        }
        else{
            System.out.println("Matricula não associada a professor.");
        }
    }

    public void deletarTecnicoADM(int matricula){
        Pessoa pessoa = buscarFuncionario(matricula);

        if(pessoa == null){
            System.out.println("Funcionario não encontrado");
        }
        else if(pessoa instanceof TecnicoADM){
            banco.getArrayPessoas().remove(pessoa);
            banco.salvarDados();

            System.out.println("Professor removido com sucesso!");
        }
        else{
            System.out.println("Matricula não associada a Tecnico ADM.");
        }
    }
        

    public void buscarProfessor(int matricula){
       Pessoa pessoa = buscarFuncionario(matricula);

        if(pessoa == null){
            System.out.println("Funcionario não encontrado.");
        }
        else if(pessoa instanceof Professor p){
            System.out.println("Nome: " + p.getNome());
            System.out.println("Disciplinas: " + p.getDisciplinas());
        }
        else{
            System.out.println("Matricula não associada a professor.");
        }
    }

    public void buscarTecnicoADM(int matricula){
        Pessoa pessoa = buscarFuncionario(matricula);

        if(pessoa == null){
            System.out.println("Funcionario não encontrado.");
        }
        else if(pessoa instanceof TecnicoADM f){
            System.out.println("Nome: " + f.getNome());
            System.out.println("Função: " + f.getFuncaoGratificada());
        }
        else{
            System.out.println("Matricula não associada a professor.");
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
}
