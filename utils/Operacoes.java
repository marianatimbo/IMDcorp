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

    public void listarFuncionarios() {
    }

    public void deletarProfessor(int matricula){
        
    }

    public void deletarTecnicoADM(int matricula){}
        

    public void buscarProfessor(int matricula){
       Pessoa p = buscarFuncionario(matricula);
        if(p != null){
            System.out.println("Nome: "+ p.getNome());
            System.out.println("CPF: " + p.getCpf());
            System.out.println("Data de nasciemnto:" + p.getDataNascimento().toString());
            System.out.println("Genero: " + p.getGenero());
            System.out.println("Endereço: " + p.getEndereco().getRua() + p.getEndereco().getNumero() +  p.getEndereco().getBairro() + p.getEndereco().getCidade() + p.getEndereco().getCep() );
            System.out.println("NivelProfessor: " + ((Professor)p).getNivelProfessor());
            System.out.println("Formação profissional:" + ((Professor)p).getFormacaoProfessor());
            System.out.println("Disciplinas: " + ((Professor)p).getDisciplinas());
            System.out.println("Matricula: " + ((Professor)p).getMatricula());
            System.out.println("Salario: " + ((Professor)p).getSalario());
            System.out.println("Departamento: " + ((Professor)p).getDepartamento());
            System.out.println("Carga Horário: "+ ((Professor)p).getCargaHoraria());
       } 
    }

    public void buscarTecnicoADM(int matricula){

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
