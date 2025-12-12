package classes;

import java.util.Date;

public class Paciente {
    private String nome;
    private String cpf;
    private String telefone;
    private Date dataConsulta;
    private boolean eraPaciente;
    private boolean consultaRealizada;
    private String obsConsulta;
    

    public Paciente() {
    }

    public Paciente(String nome, String cpf, String telefone, Date dataConsulta, boolean eraPaciente, boolean consultaRealizada, String obsConsulta) {
        
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataConsulta = dataConsulta;
        this.eraPaciente = eraPaciente;
        this.consultaRealizada = consultaRealizada;
        this.obsConsulta = obsConsulta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public boolean isEraPaciente() {
        return eraPaciente;
    }

    public void setEraPaciente(boolean eraPaciente) {
        this.eraPaciente = eraPaciente;
    }

    public boolean isConsultaRealizada() {
        return consultaRealizada;
    }

    public void setConsultaRealizada(boolean consultaRealizada) {
        this.consultaRealizada = consultaRealizada;
    }

    public String getObsConsulta() {
        return obsConsulta;
    }

    public void setObsConsulta(String obsConsulta) {
        this.obsConsulta = obsConsulta;
    }
}
