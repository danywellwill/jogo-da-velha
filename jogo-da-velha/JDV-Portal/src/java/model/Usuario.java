/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author Jr
 */
public class Usuario {
    private Integer cdUsuariId; 
    private String deUsuario; 
    private String deSexo;
    private LocalDateTime dtNascimento = LocalDateTime.of(1900, 01, 01, 01, 01, 01); 
    private String deLogin; 
    private String deSenhaAcesso; 
    private LocalDateTime dtCriacao = LocalDateTime.of(1900, 01, 01, 01, 01, 01); 
    private LocalDateTime dtAlteracao = LocalDateTime.of(1900, 01, 01, 01, 01, 01); 
    private Integer versao; 

    public Integer getCdUsuariId() {
        return cdUsuariId;
    }

    public void setCdUsuariId(Integer cdUsuariId) {
        this.cdUsuariId = cdUsuariId;
    }

    public String getDeUsuario() {
        return deUsuario;
    }

    public void setDeUsuario(String deUsuario) {
        this.deUsuario = deUsuario;
    }

    public String getDeSexo() {
        return deSexo;
    }

    public void setDeSexo(String deSexo) {
        this.deSexo = deSexo;
    }

    public String getDtNascimento() {
        String aData = this.dtNascimento.toString();
        return aData;
    }

    public void setDtNascimento(LocalDateTime dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getDeLogin() {
        return deLogin;
    }

    public void setDeLogin(String deLogin) {
        this.deLogin = deLogin;
    }

    public String getDeSenhaAcesso() {
        return deSenhaAcesso;
    }

    public void setDeSenhaAcesso(String deSenhaAcesso) {
        this.deSenhaAcesso = deSenhaAcesso;
    }

    public String getDtCriacao() {
        String aData = this.dtCriacao.toString();
        return aData;
    }

    public void setDtCriacao(LocalDateTime dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public String getDtAlteracao() {
        String aData = this.dtAlteracao.toString();
        return aData;
    }

    public void setDtAlteracao(LocalDateTime dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }
}
