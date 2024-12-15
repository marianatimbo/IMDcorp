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
            Double salario = CalcularSalario(professor);
            professor.setSalario(salario);
        
            banco.getArrayPessoas().add(professor);
            
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
            Double salario = CalcularSalario(tecnicoADM);
            tecnicoADM.setSalario(salario);
            banco.getArrayPessoas().add(tecnicoADM);
            System.out.println("Técnico ADM cadastrado com sucesso!");
       }
       else{
            System.out.println("Essa matrícula já está cadastrado!");
       }
        
    }

    public static void listarProfessores(){
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
            System.out.println("\nProfessor encontrado: ");
            imprimirProfessor((Professor)pessoa);
            banco.getArrayPessoas().remove(pessoa);
            System.out.println("\nProfessor removido com sucesso!");
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
            System.out.println("\nTecnico encontrado: ");
            imprimirTecnicoADM((TecnicoADM)pessoa);
            banco.getArrayPessoas().remove(pessoa);
            System.out.println("\nTécnico removido com sucesso!");
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
            System.out.println("Nome: "+ professor.getNome());
            System.out.println("CPF: " + professor.getCpf());
            System.out.println("Data de nasciemnto:" + professor.getDataNascimento().toString());
            System.out.println("Genero: " + professor.getGenero());
            System.out.println("Endereço: ");
            System.out.println("Rua: " + professor.getEndereco().getRua());
            System.out.println("Numero: " + professor.getEndereco().getNumero());
            System.out.println("Bairro: " + professor.getEndereco().getBairro());
            System.out.println("Cidade: " + professor.getEndereco().getCidade());
            System.out.println("CEP: " + professor.getEndereco().getCep());
            System.out.println("Nivel : " + professor.getNivelProfessor());
            System.out.println("Formação profissional:" + professor.getFormacaoProfessor());
            System.out.println("Disciplinas: " + professor.getDisciplinas());
            System.out.println("Matricula: " + professor.getMatricula());
            if(professor.getSalario() == 0.0){
                System.out.println("Salario: > a calcular <");
            }
            else{
                System.out.println("Salario: "+ professor.getSalario());
            }
            System.out.println("Departamento: " + professor.getDepartamento());
            System.out.println("Carga Horário: "+ professor.getCargaHoraria());
            System.out.println("Data de Ingresso: " + professor.getDataIngresso());
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
            System.out.println("Nome: "+ tecnicoADM.getNome());
            System.out.println("CPF: " + tecnicoADM.getCpf());
            System.out.println("Data de nasciemnto:" + tecnicoADM.getDataNascimento().toString());
            System.out.println("Genero: " + tecnicoADM.getGenero());
            System.out.println("Endereço: ");
            System.out.println("Rua: " + tecnicoADM.getEndereco().getRua());
            System.out.println("Numero: " + tecnicoADM.getEndereco().getNumero());
            System.out.println("Bairro: " + tecnicoADM.getEndereco().getBairro());
            System.out.println("Cidade: " + tecnicoADM.getEndereco().getCidade());
            System.out.println("CEP: " + tecnicoADM.getEndereco().getCep());
            System.out.println("NivelProfessor: " + tecnicoADM.getNivelTecnico());
            System.out.println("Formação profissional:" + tecnicoADM.getFormacaoTecnico());
            System.out.println("Insalubridade: " + tecnicoADM.getInsalubridade());
            System.out.println("Matricula: " + tecnicoADM.getMatricula());
            if(tecnicoADM.getSalario() == 0.0){
                System.out.println("Salario: > a calcular<");
            }
            else{
                System.out.println("Salario: "+ tecnicoADM.getSalario());
            }
            System.out.println("Departamento: " +   tecnicoADM.getDepartamento());
            System.out.println("Carga Horário: "+   tecnicoADM.getCargaHoraria());
            System.out.println("Data de Ingresso: " + tecnicoADM.getDataIngresso());
        }
        else{
            System.out.println("Matrícula não associada a técnico.");
        }
    }

    public static Double CalcularSalario(Pessoa pessoa){
        Double salario = 0.0;

        if(pessoa instanceof Professor professor){
            salario = professor.calculaSalario();            
        }
        if(pessoa instanceof TecnicoADM tecnico){
            salario = tecnico.calculaSalario();
        }

        return salario;
    }

    public static void exibirSalario(int matricula){
        Pessoa pessoa = buscarFuncionario(matricula);
        if(pessoa instanceof Professor professor){
            System.out.println("Professor encontrado: ");
            imprimirProfessor(professor);
            System.out.println("Salario: " + professor.getSalario());
        }
        if(pessoa instanceof TecnicoADM tecnico){
            System.out.println("Tecnico encontrado: ");
            imprimirTecnicoADM(tecnico);
            System.out.println("Salario: " + tecnico.getSalario());;
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
        System.out.println("\nNome: " + professor.getNome());
        System.out.println("Disciplinas: " + professor.getDisciplinas());
        System.out.println("Matricula: " + professor.getMatricula());
    }

    public static void imprimirTecnicoADM(TecnicoADM tecnicoADM){
        System.out.println("\nNome: " + tecnicoADM.getNome());
        System.out.println("Função: " + tecnicoADM.getDepartamento());
        System.out.println("Matricula: " + tecnicoADM.getMatricula());
    }
}
