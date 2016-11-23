/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDProjeto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mariano
 */
@Embeddable
public class MoveBancoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FK_COD_BANCO")
    private long fkCodBanco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_DATA_ENTRADA")
    @Temporal(TemporalType.DATE)
    private Date dtDataEntrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_SEQ_MOVE")
    private long codSeqMove;

    public MoveBancoPK() {
    }

    public MoveBancoPK(long fkCodBanco, Date dtDataEntrada, long codSeqMove) {
        this.fkCodBanco = fkCodBanco;
        this.dtDataEntrada = dtDataEntrada;
        this.codSeqMove = codSeqMove;
    }

    public long getFkCodBanco() {
        return fkCodBanco;
    }

    public void setFkCodBanco(long fkCodBanco) {
        this.fkCodBanco = fkCodBanco;
    }

    public Date getDtDataEntrada() {
        return dtDataEntrada;
    }

    public void setDtDataEntrada(Date dtDataEntrada) {
        this.dtDataEntrada = dtDataEntrada;
    }

    public long getCodSeqMove() {
        return codSeqMove;
    }

    public void setCodSeqMove(long codSeqMove) {
        this.codSeqMove = codSeqMove;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fkCodBanco;
        hash += (dtDataEntrada != null ? dtDataEntrada.hashCode() : 0);
        hash += (int) codSeqMove;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MoveBancoPK)) {
            return false;
        }
        MoveBancoPK other = (MoveBancoPK) object;
        if (this.fkCodBanco != other.fkCodBanco) {
            return false;
        }
        if ((this.dtDataEntrada == null && other.dtDataEntrada != null) || (this.dtDataEntrada != null && !this.dtDataEntrada.equals(other.dtDataEntrada))) {
            return false;
        }
        if (this.codSeqMove != other.codSeqMove) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BDProjeto.MoveBancoPK[ fkCodBanco=" + fkCodBanco + ", dtDataEntrada=" + dtDataEntrada + ", codSeqMove=" + codSeqMove + " ]";
    }
    
}
