package DAO;

import java.util.ArrayList;
import java.io.*;
import model.*;;


public class BancoDAO implements Serializable {
    private static final long serialVersionUID = 4839783881463727079L;

    private ArrayList<Pessoa> funcionarios;
    private final static String ARQUIVO_FUNCIONARIOS = "funcionarios.ser";
    private static BancoDAO banco;

    
    private BancoDAO(){
        funcionarios = new ArrayList<>();
    }
    
    public static BancoDAO getInstance(){
           if(banco == null){
               banco = new BancoDAO();
           }
           return banco;
    }
    
    public ArrayList<Pessoa> getArrayPessoas() {
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
    public void carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_FUNCIONARIOS))) {
            funcionarios =  (ArrayList<Pessoa>) ois.readObject();  
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + ARQUIVO_FUNCIONARIOS + ". Criando lista nova.");  
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar dados do arquivo: " + e.getMessage());  
        }
    }

}
