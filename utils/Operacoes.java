package utils;

import java.util.List;

import DAO.BancoDAO;
import Enum.*;
import model.*;


public class Operacoes {
    static BancoDAO banco = BancoDAO.getInstance();


    public static void cadastrarProfessor(Pessoa pessoa, Nivel nivelProfessor, Formacao formacaoProfessor, List<String> disciplinas){

    Pessoa pessoa2 = buscarFuncionario(pessoa.getMatricula());
        if(pessoa2 == null){
            Professor professor = new Professor(pessoa.getNome(), pessoa.getCpf(), pessoa.getDataNascimento(), pessoa.getGenero(), pessoa.getEndereco(), pessoa.getMatricula(), pessoa.getDepartamento(), pessoa.getCargaHoraria(), pessoa.getDataIngresso(), nivelProfessor, formacaoProfessor, disciplinas);

            banco.getArrayPessoas().add(professor);
            // banco.salvarDados();
            System.out.println("Professor cadastrado com sucesso!");
        }
        else{
            System.out.println("Essa matrícula já está cadastrado!");
        }
        
    }

    public static void cadastrarTecnicoADM(Pessoa pessoa, Nivel nivelTecnico, Formacao formacaoTecnico, Boolean insalubridade, Boolean funcaoGratificada) {
        
        Pessoa pessoa2 = buscarFuncionario(pessoa.getMatricula());
        if(pessoa2 == null){
            TecnicoADM tecnicoADM = new TecnicoADM(pessoa.getNome(), pessoa.getCpf(), pessoa.getDataNascimento(), pessoa.getGenero(), pessoa.getEndereco(), pessoa.getMatricula(), pessoa.getDepartamento(), pessoa.getCargaHoraria(), pessoa.getDataIngresso(), nivelTecnico, formacaoTecnico, insalubridade, funcaoGratificada);

            banco.getArrayPessoas().add(tecnicoADM);
            System.out.println("Técnico ADM cadastrado com sucesso!");
       }
       else{
            System.out.println("Essa matrícula já está cadastrado!");
       }
        
    }

    public static void listarProfessores(){
        System.out.println(banco.getArrayPessoas().size());
        for(Pessoa pessoa : banco.getArrayPessoas()){
            if(pessoa instanceof Professor professor){
                imprimirProfessor(professor);
            }
        }
    }

    public static void listarTecnicosADM(){
        for(Pessoa pessoa : banco.getArrayPessoas()){
            if(pessoa instanceof TecnicoADM tecnicoADM){
                imprimirTecnicoADM(tecnicoADM);
            }
        }
    }

    public static void deletarProfessor(int matricula){
        Pessoa pessoa = buscarFuncionario(matricula);

        if(pessoa == null){
            System.out.println("Funcionário não encontrado");
        }
        else if(pessoa instanceof Professor){
            banco.getArrayPessoas().remove(pessoa);
            // banco.salvarDados();

            System.out.println("Professor removido com sucesso!");
        }
        else{
            System.out.println("Matrícula não associada a professor.");
        }
    }

    public static void deletarTecnicoADM(int matricula){
        Pessoa pessoa = buscarFuncionario(matricula);

        if(pessoa == null){
            System.out.println("Funcionário não encontrado");
        }
        else if(pessoa instanceof TecnicoADM){
            banco.getArrayPessoas().remove(pessoa);
            // banco.salvarDados();

            System.out.println("Técnico removido com sucesso!");
        }
        else{
            System.out.println("Matrícula não associada a Técnico ADM.");
        }
    }
        

    public static void buscarProfessor(int matricula){
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

    public static void buscarTecnicoADM(int matricula){
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

    public static void CalcularSalario(int matricula){
        Pessoa pessoa = buscarFuncionario(matricula);
        Double salario;

        if(pessoa instanceof Professor professor){
            salario = professor.calculaSalario();
            System.out.println(salario);
        }
        if(pessoa instanceof TecnicoADM tecnico){
            salario = tecnico.calculaSalario();
            System.out.println(salario);
        }
    }

    public static Pessoa buscarFuncionario(int matricula){
        for(Pessoa p : banco.getArrayPessoas()){
            if(p.getMatricula() == matricula){
                return p;
            }
        }
        return null;
    }

    public static void imprimirProfessor(Professor professor){
        System.out.println("Nome: " + professor.getNome());
        System.out.println("Disciplinas: " + professor.getDisciplinas());
    }

    public static void imprimirTecnicoADM(TecnicoADM tecnicoADM){
        System.out.println("Nome: " + tecnicoADM.getNome());
        System.out.println("Função: " + tecnicoADM.getFuncaoGratificada());
    }
}
