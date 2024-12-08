package model;

import java.time.LocalDate;

public interface Funcionario {
    Long getMatricula();
    Double getSalario();
    String getDepartamento();
    int getCargaHoraria();
    LocalDate getDataIngresso();

    Double calculaSalario();
}
