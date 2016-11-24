/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDProjeto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mariano
 */
@Entity
@Table(name = "move_banco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MoveBanco.findAll", query = "SELECT m FROM MoveBanco m"),
    @NamedQuery(name = "MoveBanco.findByFkCodBanco", query = "SELECT m FROM MoveBanco m WHERE m.moveBancoPK.fkCodBanco = :fkCodBanco"),
    @NamedQuery(name = "MoveBanco.findByDtDataEntrada", query = "SELECT m FROM MoveBanco m WHERE m.moveBancoPK.dtDataEntrada = :dtDataEntrada"),
    @NamedQuery(name = "MoveBanco.findByCodSeqMove", query = "SELECT m FROM MoveBanco m WHERE m.moveBancoPK.codSeqMove = :codSeqMove"),
    @NamedQuery(name = "MoveBanco.findByFlagDebCred", query = "SELECT m FROM MoveBanco m WHERE m.flagDebCred = :flagDebCred"),
    @NamedQuery(name = "MoveBanco.findByFkCodLocal", query = "SELECT m FROM MoveBanco m WHERE m.fkCodLocal = :fkCodLocal"),
    @NamedQuery(name = "MoveBanco.findByDscHistorico", query = "SELECT m FROM MoveBanco m WHERE m.dscHistorico = :dscHistorico"),
    @NamedQuery(name = "MoveBanco.findByVlTransacao", query = "SELECT m FROM MoveBanco m WHERE m.vlTransacao = :vlTransacao"),
    @NamedQuery(name = "MoveBanco.findByFkDscNomeUsu", query = "SELECT m FROM MoveBanco m WHERE m.fkDscNomeUsu = :fkDscNomeUsu")})
public class MoveBanco implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MoveBancoPK moveBancoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "FLAG_DEB_CRED")
    private String flagDebCred;
    @Column(name = "FK_COD_LOCAL")
    private BigInteger fkCodLocal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "DSC_HISTORICO")
    private String dscHistorico;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "VL_TRANSACAO")
    private BigDecimal vlTransacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FK_DSC_NOME_USU")
    private String fkDscNomeUsu;

    public MoveBanco() {
    }

    public MoveBanco(MoveBancoPK moveBancoPK) {
        this.moveBancoPK = moveBancoPK;
    }

    public MoveBanco(MoveBancoPK moveBancoPK, String flagDebCred, String dscHistorico, BigDecimal vlTransacao, String fkDscNomeUsu) {
        this.moveBancoPK = moveBancoPK;
        this.flagDebCred = flagDebCred;
        this.dscHistorico = dscHistorico;
        this.vlTransacao = vlTransacao;
        this.fkDscNomeUsu = fkDscNomeUsu;
    }

    public MoveBanco(long fkCodBanco, Date dtDataEntrada, long codSeqMove) {
        this.moveBancoPK = new MoveBancoPK(fkCodBanco, dtDataEntrada, codSeqMove);
    }

    public MoveBancoPK getMoveBancoPK() {
        return moveBancoPK;
    }

    public void setMoveBancoPK(MoveBancoPK moveBancoPK) {
        this.moveBancoPK = moveBancoPK;
    }

    public String getFlagDebCred() {
        return flagDebCred;
    }

    public void setFlagDebCred(String flagDebCred) {
        this.flagDebCred = flagDebCred;
    }

    public BigInteger getFkCodLocal() {
        return fkCodLocal;
    }

    public void setFkCodLocal(BigInteger fkCodLocal) {
        this.fkCodLocal = fkCodLocal;
    }

    public String getDscHistorico() {
        return dscHistorico;
    }

    public void setDscHistorico(String dscHistorico) {
        this.dscHistorico = dscHistorico;
    }

    public BigDecimal getVlTransacao() {
        return vlTransacao;
    }

    public void setVlTransacao(BigDecimal vlTransacao) {
        this.vlTransacao = vlTransacao;
    }

    public String getFkDscNomeUsu() {
        return fkDscNomeUsu;
    }

    public void setFkDscNomeUsu(String fkDscNomeUsu) {
        this.fkDscNomeUsu = fkDscNomeUsu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moveBancoPK != null ? moveBancoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MoveBanco)) {
            return false;
        }
        MoveBanco other = (MoveBanco) object;
        if ((this.moveBancoPK == null && other.moveBancoPK != null) || (this.moveBancoPK != null && !this.moveBancoPK.equals(other.moveBancoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BDProjeto.MoveBanco[ moveBancoPK=" + moveBancoPK + " ]";
    }
    
}
