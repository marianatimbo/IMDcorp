import utils.*;
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
        
    public static void main(String[] args) {
        
        Menu();
        int op = 2;
        
        while (op != 10) {
            switch (op) {
                case 1: //cadastrarProfessor();
                    break;
                default:
                    break;
            }
        }
        //cadastrarProfessor
        //cadastrarTecnicoADM
        //listarProfessores
        //listarTecnicosADM
        //deletarProfessor
        //deletarTecnicoADM
        //buscarProfessor
        //buscarTecnicoADM
        //CalcularSalario
    }
}
