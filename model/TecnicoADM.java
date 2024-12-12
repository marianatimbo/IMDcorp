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

    public TecnicoADM(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco, int matricula, String departamento, Integer cargaHoraria,LocalDate dataIngresso,Nivel nivelTecnico, Formacao formacaoTecnico, Boolean insalubridade, Boolean funcaoGratificada) {
        super(nome, cpf, dataNascimento, genero, endereco, matricula, departamento, cargaHoraria, dataIngresso, 0.0);
        
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
        Double salarioBase = 2500.00;
        Double salarioFinal;
        double percentualNivel = (0.05 * (this.nivelTecnico.ordinal()) * salarioBase);
        Double percentualFormacao = 0.0;
        Double percentualInsalubridade = 0.0; 
        Double percentualFGratificada = 0.0 ; 

        switch (this.formacaoTecnico) {
            case ESPECIALIZACAO:
                percentualFormacao = salarioBase * 0.25; 
                break;

            case MESTRADO:
                percentualFormacao =  salarioBase * 0.5; 
                break;

            case DOUTORADO:
                percentualFormacao = salarioBase * 0.75; 
                break;
        
            default:
                break;
        }
        
        if(this.insalubridade == true){
            percentualInsalubridade = salarioBase * 0.5;
        }

        if(this.funcaoGratificada == true){
            percentualFGratificada = salarioBase * 0.5;
        }
        
        salarioFinal = salarioBase + percentualNivel + percentualFormacao + percentualInsalubridade + percentualFGratificada;
        this.setSalario(salarioFinal);

        return salarioFinal;
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
