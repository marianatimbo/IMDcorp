package DAO;
import java.util.ArrayList;

import model.*;;


public class BancoDAO {
    ArrayList<Pessoa> funcionario;

    public ArrayList<Pessoa> getFuncionario() {
        return funcionario;
    }
    
    private static BancoDAO banco;
    private BancoDAO(){
        funcionario = new ArrayList<>();
    }

    public static BancoDAO getIntance(){
        if(banco == null){
            banco = new BancoDAO();
        }
        return banco;
    }
}
