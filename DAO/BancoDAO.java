package DAO;

import java.util.ArrayList;
import java.io.*;
import model.*;;


public class BancoDAO implements Serializable {
    
    private ArrayList<Pessoa> funcionarios;
    private final static String ARQUIVO_FUNCIONARIOS = "funcionarios.ser";
    private static BancoDAO banco;

    
    private BancoDAO(){
        funcionarios = new ArrayList<>();
    }
    
    public static BancoDAO getInstance(){
        if(banco == null){
            banco = new BancoDAO();
            if(banco == null){
                banco = carregarDados();
            }
        }
        return banco;
    }
    
    public ArrayList<Pessoa> getArrayPessoas() {
        return this.funcionarios;
    }
    
    public void salvarDados(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_FUNCIONARIOS))) {
            oos.writeObject(banco);
            System.out.println("Dados salvos com sucesso no arquivo: " + ARQUIVO_FUNCIONARIOS);
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados no arquivo: " + e.getMessage());
        }
    }
        
    private static BancoDAO carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_FUNCIONARIOS))) {
            return (BancoDAO) ois.readObject();  
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + ARQUIVO_FUNCIONARIOS + ". Criando lista nova.");  
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar dados do arquivo: " + e.getMessage());  
        }
        return null;
    }

}
