# IMD Corp - Sistema de Gestão de Funcionários
## Sobre o Projeto

O IMD Corp é um sistema de gestão para cadastro e gerenciamento de professores e técnicos administrativos em uma organização fictícia. O sistema permite realizar operações como cadastro, busca, listagem, exclusão e cálculo de salário de funcionários. A aplicação é escrita em Java e foi desenvolvida com foco na interação via terminal, utilizando classes e estruturas organizadas para representar os diferentes elementos do sistema.
### Funcionalidades
  1. **Cadastrar Professor**: Permite cadastrar professores com informações básicas da classe Pessoa e inclui detalhes como nível, formação e disciplinas associadas, e chama a função CalcularSalario para preencher seu salario.
  2. **Cadastrar Técnico Administrativo (Técnico ADM):** Realiza o cadastro de técnicos administrativos, incluindo detalhes como insalubridade e função gratificada, e chama a função CalcularSalario para preencher seu salario.
  3. **Listar Professores:** Exibe uma lista de todos os professores cadastrados, com informações de nome, disciplinas e matrícula.
  4. **Listar Técnicos ADM:** Mostra todos os técnicos administrativos registrados no sistema, com informações de nome, do departamento e da matrícula..
  5. **Deletar Professor:** Remove um professor com base na matrícula informada.
  6. **Deletar Técnico ADM:** Remove um técnico administrativo pelo número de matrícula.
  7. **Buscar Professor:** Localiza um professor a partir de sua matrícula e imprime todas suas informações.
  8. **Buscar Técnico ADM:** Localiza um técnico administrativo pelo número de matrícula e exibe todas suas informações.
  9. **Exibir Salário:** exibe o salário de um funcionário, considerando as regras específicas para cada tipo de funcionário.
  10. **Encerrar Sessão:** Finaliza a execução do programa, garantindo a persistência de dados.
##### Metodos auxiliares:
  1.buscarFuncionario:
  Localiza uma pessoa na lista do banco com base na matrícula. Retornar a pessoa correspondente ou null.

  2.Métodos de Impressão
  Os métodos imprimirProfessor e imprimirTecnicoADM exibem informações resumidas de professores e técnicos, respectivamente.
## Como Executar:
  1. Certifique-se de ter o Java configurado no seu computador.
  2. Compile o projeto com o seguinte comando no terminal:
     ```bash
     javac Main.java
  3. Execute o programa:
     ```bash
     java Main
  4. Interaja com o sistema seguindo as instruções apresentadas no menu.
## Estrutura do Código


  ### Pacotes Importados:
        utils: Contém classe auxiliar para manipulação de dados (Operações).
        model: Define os modelos principais do sistema ( Professor, TecnicoADM , Pessoa, Funcionário e Endereço).
        DAO.BancoDAO: Responsável pela persistência de dados.
        Enum: Define os enumeradores utilizados (Genero, Nivel, Formacao).

  ### Classe Main:
        A classe principal que contém o método main, gerenciando a interação do usuário com o sistema por meio de um menu.
        Inclui o método Menu, que apresenta as opções disponíveis, e o método informacoesBasicas, utilizado para coletar informações básicas do tipo "Pessoa" sobre os funcionários.
        
## Considerações do Projeto:
  Pelo arquivo de direcionamento do professor, foi levado em consideração a matricula sendo do tipo INT.
  Também a de evidenciar que ao cadatrar um funcionario, seu salario será calculado automaticamente pela função **calcularSalario**.
