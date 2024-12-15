import utils.*;
import model.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.BancoDAO;
import Enum.*;

public class Main {
    public static void Menu() {
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
        System.out.println("9- Exibir Salario");
        System.out.println("10- Encerrar sessão");
    }

    public static void informacoesBasicas(Pessoa pessoa, Scanner scanner) {

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        pessoa.setNome(nome);

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        pessoa.setCpf(cpf);

        System.out.print("Data de Nascimento (yyyy-MM-dd): ");
        String dataNascimentoInput = scanner.nextLine();
        LocalDate dataNascimento;

        try {
            dataNascimento = LocalDate.parse(dataNascimentoInput);
        } catch (Exception e) {
            System.out.println("Data inválida.");
            return;
        }
        pessoa.setDataNascimento(dataNascimento);

        System.out.print("Gênero (MASC/FEM/OUTRO): ");
        String generoInput = scanner.nextLine().toUpperCase();
        Genero genero;
        try {
            genero = Genero.valueOf(generoInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Gênero inválido.");
            return;
        }
        pessoa.setGenero(genero);

        System.out.println("------ ENDEREÇO ------- ");

        System.out.print("Rua: ");
        String rua = scanner.nextLine();

        System.out.print("Número: ");
        int numero;
        try {
            numero = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Número inválido. ");
            return;
        }

        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();

        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);
        pessoa.setEndereco(endereco);
        System.out.println("-----------------------");

        System.out.print("Departamento: ");
        String departamento = scanner.nextLine();
        pessoa.setDepartamento(departamento);

        System.out.print("Carga Horária: ");
        Integer cargaHoraria;
        try {
            cargaHoraria = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Carga horária inválida.");
            return;
        }
        pessoa.setCargaHoraria(cargaHoraria);

        System.out.print("Data de Ingresso (yyyy-MM-dd): ");
        String dataIngressoInput = scanner.nextLine().trim();
        LocalDate dataIngresso;
        try {
            dataIngresso = LocalDate.parse(dataIngressoInput);
            
        } catch (DateTimeParseException e) {
            System.out.println("Data inválida. Use o formato yyyy-MM-dd.");
            return;
        }
        pessoa.setDataIngresso(dataIngresso);

        System.out.print("Digite a matrícula: ");
        int matricula;
        try {
            matricula = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Matrícula inválida.");
            return;
        }
        pessoa.setMatricula(matricula);
    }

    public static void main(String[] args) {
        BancoDAO banco = BancoDAO.getInstance();
        banco.carregarDados();
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;
        
        while (opcao != 10) {
            Menu();

            System.out.print("Escolha uma opção: ");
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Por favor, insira um número válido.");
                scanner.next();
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("\n=-=-==-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("CADASTRAR PROFESSOR:");
                    System.out.println("Preencha as seguintes informações:");

                    Professor newProf = new Professor();
                    informacoesBasicas(newProf, scanner);

                    System.out.print("Nível (I, II, III, etc.): ");
                    String nivelInput = scanner.nextLine().toUpperCase();
                    Nivel nivelProfessor;

                    try {
                        nivelProfessor = Nivel.valueOf(nivelInput);

                    } catch (IllegalArgumentException e) {
                        System.out.println("Nível inválido.");
                        break;
                    }

                    System.out.print("Formação (ESPECIALIZACAO, MESTRADO, DOUTORADO): ");
                    String formacaoInput = scanner.nextLine().toUpperCase();
                    Formacao formacaoProfessor;
                    try {
                        formacaoProfessor = Formacao.valueOf(formacaoInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Formação inválida. Tente novamente.");
                        break;
                    }

                    System.out.print("Disciplinas (separe por vírgulas): ");
                    String disciplinasInput = scanner.nextLine();
                    List<String> disciplinas = new ArrayList<>();
                    for (String disciplina : disciplinasInput.split(",")) {
                        disciplinas.add(disciplina.trim());
                    }

                    Operacoes.cadastrarProfessor(newProf, nivelProfessor, formacaoProfessor, disciplinas);
                    System.out.println("=-=-==-=-=-=-=-=-=-=-=-=-=-\n");

                    break;

                case 2:
                    System.out.println("\n=-=-==-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("CADASTRAR TECNICO ADM:");
                    System.out.println("Preencha as seguintes informações:");

                    TecnicoADM newTecnicoADM = new TecnicoADM();
                    informacoesBasicas(newTecnicoADM, scanner);

                    System.out.print("Nível (I, II, III, etc.): ");
                    nivelInput = scanner.nextLine().toUpperCase();
                    Nivel nivelTecnicoADM;
                    try {
                        nivelTecnicoADM = Nivel.valueOf(nivelInput);

                    } catch (IllegalArgumentException e) {
                        System.out.println("Nível inválido. Tente novamente.");
                        break;
                    }

                    System.out.print("Formação (ESPECIALIZACAO, MESTRADO, DOUTORADO): ");
                    formacaoInput = scanner.nextLine().toUpperCase();
                    Formacao formacaoTecnicoADM;
                    try {
                        formacaoTecnicoADM = Formacao.valueOf(formacaoInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Formação inválida. Tente novamente.");
                        break;
                    }

                    System.out.println("Insalubridade (true/false): ");
                    boolean insalubridade;
                    try {
                        insalubridade = Boolean.parseBoolean(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Valor inválido. Insira 'true' ou 'false'.");
                        break;
                    }

                    System.out.println("Função gratificada (true/false): ");
                    boolean funcaoGratificada;
                    try {
                        funcaoGratificada = Boolean.parseBoolean(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Valor inválido. Insira 'true' ou 'false'.");
                        break;
                    }

                    Operacoes.cadastrarTecnicoADM(newTecnicoADM, nivelTecnicoADM, formacaoTecnicoADM, insalubridade,
                            funcaoGratificada);
                    System.out.println("=-=-==-=-=-=-=-=-=-=-=-=-=-\n");

                    break;
                case 3:
                    System.out.println("\n=-=-==-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("LISTAR TODOS OS PROFESSORES: ");

                    Operacoes.listarProfessores();
                    System.out.println("=-=-==-=-=-=-=-=-=-=-=-=-=-\n");
                    break;

                case 4:
                    System.out.println("\n=-=-==-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("LISTAR TODOS OS TECNICOS ADM: ");

                    Operacoes.listarTecnicosADM();
                    System.out.println("=-=-==-=-=-=-=-=-=-=-=-=-=-\n");
                    break;

                case 5:
                    System.out.println("\n=-=-==-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("DELETAR PROFESSOR: ");

                    System.out.print("Digite a matrícula: ");
                    int matricula;
                    try {
                        matricula = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Matrícula inválida.");
                        break;
                    }

                    Operacoes.deletarProfessor(matricula);
                    System.out.println("=-=-==-=-=-=-=-=-=-=-=-=-=-\n");
                    break;

                case 6:
                    System.out.println("\n=-=-==-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("DELETAR TECNICO ADM: ");

                    System.out.print("Digite a matrícula: ");
                    try {
                        matricula = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Matrícula inválida.");
                        break;
                    }

                    Operacoes.deletarTecnicoADM(matricula);
                    System.out.println("=-=-==-=-=-=-=-=-=-=-=-=-=-\n");
                    break;

                case 7:
                    System.out.println("\n=-=-==-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("BUSCAR UM PROFESSOR: ");

                    System.out.print("Digite a matrícula: ");
                    try {
                        matricula = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Matrícula inválida.");
                        break;
                    }

                    Operacoes.buscarProfessor(matricula);
                    System.out.println("=-=-==-=-=-=-=-=-=-=-=-=-=-\n");
                    break;

                case 8:
                    System.out.println("\n=-=-==-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("BUSCAR UM TECNICO ADM: ");

                    System.out.print("Digite a matrícula: ");
                    try {
                        matricula = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Matrícula inválida.");
                        break;
                    }

                    Operacoes.buscarTecnicoADM(matricula);
                    System.out.println("=-=-==-=-=-=-=-=-=-=-=-=-=-\n");
                    break;

                case 9:
                    System.out.println("\n=-=-==-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("MOSTRAR SALÁRIO DE FUNCIONÁRIO: ");

                    System.out.print("Digite a matrícula: ");
                    try {
                        matricula = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Matrícula inválida.");
                        break;
                    }

                    Operacoes.exibirSalario(matricula);
                    System.out.println("=-=-==-=-=-=-=-=-=-=-=-=-=-\n");
                    break;
                case 10:
                    System.out.println("Finalizando operação...");
                    banco.salvarDados();
                    break;

                default:
                    System.out.println("Opção inválida ou não implementada. Tente novamente.");
                    break;
            }

        }
        scanner.close();
    }
}
