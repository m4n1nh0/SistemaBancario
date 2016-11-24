/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDProjeto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "local_move")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocalMove.findAll", query = "SELECT l FROM LocalMove l"),
    @NamedQuery(name = "LocalMove.findByCodLocal", query = "SELECT l FROM LocalMove l WHERE l.codLocal = :codLocal"),
    @NamedQuery(name = "LocalMove.findByDscLocal", query = "SELECT l FROM LocalMove l WHERE l.dscLocal = :dscLocal")})
public class LocalMove implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_LOCAL")
    private Long codLocal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DSC_LOCAL")
    private String dscLocal;

    public LocalMove() {
    }

    public LocalMove(Long codLocal) {
        this.codLocal = codLocal;
    }

    public LocalMove(Long codLocal, String dscLocal) {
        this.codLocal = codLocal;
        this.dscLocal = dscLocal;
    }

    public Long getCodLocal() {
        return codLocal;
    }

    public void setCodLocal(Long codLocal) {
        this.codLocal = codLocal;
    }

    public String getDscLocal() {
        return dscLocal;
    }

    public void setDscLocal(String dscLocal) {
        this.dscLocal = dscLocal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codLocal != null ? codLocal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalMove)) {
            return false;
        }
        LocalMove other = (LocalMove) object;
        if ((this.codLocal == null && other.codLocal != null) || (this.codLocal != null && !this.codLocal.equals(other.codLocal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BDProjeto.LocalMove[ codLocal=" + codLocal + " ]";
    }
    
}
