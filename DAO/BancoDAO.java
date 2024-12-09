package DAO;

import java.util.ArrayList;
import java.io.*;
import model.*;;


public class BancoDAO {
    private ArrayList<Funcionario> funcionarios;
    private final String ARQUIVO_FUNCIONARIOS = "funcionarios.ser";
    private static BancoDAO banco;

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    private BancoDAO(){
        funcionarios = (ArrayList<Funcionario>) carregarDados(ARQUIVO_FUNCIONARIOS);
        //funcionario = new ArrayList<>();
    }

    public static BancoDAO getIntance(){
        if(banco == null){
            banco = new BancoDAO();
        }
        return banco;
    }

    public ArrayList<Funcionario> getArrayFuncionarios() {
        return this.funcionarios;
    }

    public void salvarDados(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_FUNCIONARIOS))) {
            oos.writeObject(funcionarios);
            System.out.println("Dados salvos com sucesso no arquivo: " + ARQUIVO_FUNCIONARIOS);
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados no arquivo: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    private ArrayList<Funcionario> carregarDados(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (ArrayList<Funcionario>) ois.readObject();  
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + filePath + ". Criando lista nova.");
            return new ArrayList<>();  
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar dados do arquivo: " + e.getMessage());
            return new ArrayList<>();  
        }
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        salvarDados();
    }

    public void removerFuncionario(int matricula) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getMatricula() == matricula) {
                funcionarios.remove(i);
                break;
            }
        }
        salvarDados();
    }
}
