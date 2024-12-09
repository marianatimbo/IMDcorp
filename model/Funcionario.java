package model;

import java.time.LocalDate;

public interface Funcionario {
    int getMatricula();
    void setMatricula(int matricula);

    Double getSalario();
    void setSalario(Double salario);

    String getDepartamento();
    void setDepartamento(String departamento);

    Integer getCargaHoraria();
    void setCargaHoraria(Integer cargaHoraria);

    LocalDate getDataIngresso();
    void setDataIngresso(LocalDate dataIngresso);

    Double calculaSalario();
}
