package utils;

import java.time.LocalDate;
import java.util.List;

import DAO.BancoDAO;
import Enum.*;
import model.Endereco;
import model.Funcionario;
import model.Professor;
import model.TecnicoADM;


public class Operacoes {
    static BancoDAO banco = BancoDAO.getIntance();

    public void cadastrarProfessor(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco, Nivel nivelProfessor, Formacao formacaoProfessor, List<String> disciplinas, int matricula, Double salario, String departamento, Integer cargaHoraria,LocalDate dataIngresso){

        Funcionario FuncionarioExistente = buscarFuncionario(matricula);
        if(FuncionarioExistente == null){
            Professor professor = new Professor(nome, cpf, dataNascimento, genero, endereco, nivelProfessor, formacaoProfessor, disciplinas, matricula, salario, departamento, cargaHoraria, dataIngresso);

            banco.adicionarFuncionario(professor);
            System.out.println("Professor cadastrado com sucesso!");
        }
        else{
            System.out.println("Esse Professor já está cadastrado!");
        }
        
    }

    public void cadastrarTecnicoADM(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco,Nivel nivelTecnico, Formacao formacaoTecnico, Boolean insalubridade, Boolean funcaoGratificada, int matricula, Double salario, String departamento, Integer cargaHoraria,LocalDate dataIngresso) {
        
        Funcionario FuncionarioExistente = buscarFuncionario(matricula);
        if(FuncionarioExistente == null){
            TecnicoADM tecnicoADM = new TecnicoADM(nome, cpf, dataNascimento, genero, endereco, nivelTecnico, formacaoTecnico, insalubridade, funcaoGratificada, matricula, salario, departamento, cargaHoraria,dataIngresso );

            banco.adicionarFuncionario(tecnicoADM);
            System.out.println("Tecnico ADM cadastrado com sucesso!");
       }
       else{
            System.out.println("Esse Tecnico ADM já está cadastrado!");
       }
        
    }

    public void listarTecnicosADM(){
        
    }

    public void deletarProfessor(int matricula){
        
    }

    public void deletarTecnicoADM(int matricula){}
        

    public void buscarProfessor(int matricula){

    }

    public void buscarTecnicoADM(int matricula){

    }

    public void CalcularSalario(){
        
    }

    public Funcionario buscarFuncionario(int matricula){
        for(Funcionario f : banco.getArrayFuncionarios()){
                if(f.getMatricula() == matricula){
                    return f;
                }
            }
        return null;
    }
}
