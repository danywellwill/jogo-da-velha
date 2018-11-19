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
public class Partida {
    private Integer cdPartidaId; 
    private Integer cdUsuarioId; 
    private LocalDateTime dtPartida = LocalDateTime.of(1900, 01, 01, 01, 01, 01); 
    private String deResultado; 
    private Integer versao; 

    public Integer getCdPartidaId() {
        return cdPartidaId;
    }

    public void setCdPartidaId(Integer cdPartidaId) {
        this.cdPartidaId = cdPartidaId;
    }

    public Integer getCdUsuarioId() {
        return cdUsuarioId;
    }

    public void setCdUsuarioId(Integer cdUsuarioId) {
        this.cdUsuarioId = cdUsuarioId;
    }

    public String getDtPartida() {
        String aData = this.dtPartida.toString();
        return aData;
    }

    public void setDtPartida(LocalDateTime dtPartida) {
        this.dtPartida = dtPartida;
    }

    public String getDeResultado() {
        return deResultado;
    }

    public void setDeResultado(String deResultado) {
        this.deResultado = deResultado;
    }

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }
}
