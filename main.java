import utils.*;
import model.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import Enum.*;


public class main {
    public static void Menu(){
        System.out.println("=-=-=-=-= IMD CORP =-=-=-=-=");
        System.out.println("Digite a opção que deseja:");
        System.out.println("1- Cadastrar Professor");
        System.out.println("2- Cadastrar Tecnico ADM");
        System.out.println("3- Listar Professores");
        System.out.println("4- listar Tecnicos ADM");
        System.out.println("5- Deletar Professor");
        System.out.println("6- Deletar Tecnicos ADM");
        System.out.println("7- Buscar Professor");
        System.out.println("8- Buscar Tecnico ADM");
        System.out.println("9- Calcular Salario");
        System.out.println("10- Encerrar sessão");
    }
        
    public static void  main(String[] args){
        Menu();

        Endereco endereco = new Endereco("rua", 123, "bairro", "cidade", "cep");

        List<String> disciplinas = Arrays.asList("Matematica", "Fisica");

        LocalDate dataNascimento = LocalDate.of(1997, 10, 10);

        Operacoes operacoes = new Operacoes();

        operacoes.cadastrarProfessor("Joao Silva", "12345678901", dataNascimento, Genero.MASC, endereco, Nivel.I, Formacao.ESPECIALIZACAO, disciplinas, 12345, 5000.0, "Matematica", 40, dataNascimento);

        operacoes.cadastrarProfessor("Joao Silva", "12345678901", dataNascimento, Genero.MASC, endereco, Nivel.I, Formacao.ESPECIALIZACAO, disciplinas, 12345, 5000.0, "Matematica", 40, dataNascimento);
        
    }
}
