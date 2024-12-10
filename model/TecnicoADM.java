package model;
import java.time.LocalDate;
import Enum.Formacao;
import Enum.Genero;
import Enum.Nivel;

public class TecnicoADM extends Pessoa implements Funcionario{

    private Nivel nivelTecnico;
    private Formacao formacaoTecnico;
    private Boolean insalubridade;
    private Boolean funcaoGratificada;

    public TecnicoADM(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco,Nivel nivelTecnico, Formacao formacaoTecnico, Boolean insalubridade, Boolean funcaoGratificada, int matricula, Double salario, String departamento, Integer cargaHoraria,LocalDate dataIngresso) {
        super(nome, cpf, dataNascimento, genero, endereco, matricula, salario, departamento, cargaHoraria, dataIngresso);
        
        this.nivelTecnico = nivelTecnico;
        this.formacaoTecnico = formacaoTecnico;
        this.insalubridade = insalubridade;
        this.funcaoGratificada = funcaoGratificada;
    }
    
    public TecnicoADM(){
        super();
    }
    
    @Override
    public Double calculaSalario(){
        //...
        Double salario = 900.0;
        return salario;
    }

    public Nivel getNivelTecnico() {
        return nivelTecnico;
    }

    public void setNivelTecnico(Nivel nivelTecnico) {
        this.nivelTecnico = nivelTecnico;
    }

    public Formacao getFormacaoTecnico() {
        return formacaoTecnico;
    }

    public void setFormacaoTecnico(Formacao formacaoTecnico) {
        this.formacaoTecnico = formacaoTecnico;
    }

    public Boolean getInsalubridade() {
        return insalubridade;
    }

    public void setInsalubridade(Boolean insalubridade) {
        this.insalubridade = insalubridade;
    }

    public Boolean getFuncaoGratificada() {
        return funcaoGratificada;
    }

    public void setFuncaoGratificada(Boolean funcaoGratificada) {
        this.funcaoGratificada = funcaoGratificada;
    }

}
