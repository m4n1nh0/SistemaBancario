/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDProjeto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mariano
 */
@Entity
@Table(name = "banco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banco.findAll", query = "SELECT b FROM Banco b"),
    @NamedQuery(name = "Banco.findByCodBanco", query = "SELECT b FROM Banco b WHERE b.codBanco = :codBanco"),
    @NamedQuery(name = "Banco.findByDscBanco", query = "SELECT b FROM Banco b WHERE b.dscBanco = :dscBanco"),
    @NamedQuery(name = "Banco.findByCodAgencia", query = "SELECT b FROM Banco b WHERE b.codAgencia = :codAgencia"),
    @NamedQuery(name = "Banco.findByCodConta", query = "SELECT b FROM Banco b WHERE b.codConta = :codConta"),
    @NamedQuery(name = "Banco.findByDtDataCad", query = "SELECT b FROM Banco b WHERE b.dtDataCad = :dtDataCad"),
    @NamedQuery(name = "Banco.findByVltSaldoIni", query = "SELECT b FROM Banco b WHERE b.vltSaldoIni = :vltSaldoIni"),
    @NamedQuery(name = "Banco.findByDtDataAtu", query = "SELECT b FROM Banco b WHERE b.dtDataAtu = :dtDataAtu"),
    @NamedQuery(name = "Banco.findByVltSaldoAtu", query = "SELECT b FROM Banco b WHERE b.vltSaldoAtu = :vltSaldoAtu")})
public class Banco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_BANCO")
    private Long codBanco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DSC_BANCO")
    private String dscBanco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "COD_AGENCIA")
    private String codAgencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "COD_CONTA")
    private String codConta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_DATA_CAD")
    @Temporal(TemporalType.DATE)
    private Date dtDataCad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "VLT_SALDO_INI")
    private BigDecimal vltSaldoIni;
    @Column(name = "DT_DATA_ATU")
    @Temporal(TemporalType.DATE)
    private Date dtDataAtu;
    @Column(name = "VLT_SALDO_ATU")
    private BigDecimal vltSaldoAtu;

    public Banco() {
    }

    public Banco(Long codBanco) {
        this.codBanco = codBanco;
    }

    public Banco(Long codBanco, String dscBanco, String codAgencia, String codConta, Date dtDataCad, BigDecimal vltSaldoIni) {
        this.codBanco = codBanco;
        this.dscBanco = dscBanco;
        this.codAgencia = codAgencia;
        this.codConta = codConta;
        this.dtDataCad = dtDataCad;
        this.vltSaldoIni = vltSaldoIni;
    }

    public Long getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(Long codBanco) {
        this.codBanco = codBanco;
    }

    public String getDscBanco() {
        return dscBanco;
    }

    public void setDscBanco(String dscBanco) {
        this.dscBanco = dscBanco;
    }

    public String getCodAgencia() {
        return codAgencia;
    }

    public void setCodAgencia(String codAgencia) {
        this.codAgencia = codAgencia;
    }

    public String getCodConta() {
        return codConta;
    }

    public void setCodConta(String codConta) {
        this.codConta = codConta;
    }

    public Date getDtDataCad() {
        return dtDataCad;
    }

    public void setDtDataCad(Date dtDataCad) {
        this.dtDataCad = dtDataCad;
    }

    public BigDecimal getVltSaldoIni() {
        return vltSaldoIni;
    }

    public void setVltSaldoIni(BigDecimal vltSaldoIni) {
        this.vltSaldoIni = vltSaldoIni;
    }

    public Date getDtDataAtu() {
        return dtDataAtu;
    }

    public void setDtDataAtu(Date dtDataAtu) {
        this.dtDataAtu = dtDataAtu;
    }

    public BigDecimal getVltSaldoAtu() {
        return vltSaldoAtu;
    }

    public void setVltSaldoAtu(BigDecimal vltSaldoAtu) {
        this.vltSaldoAtu = vltSaldoAtu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codBanco != null ? codBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banco)) {
            return false;
        }
        Banco other = (Banco) object;
        if ((this.codBanco == null && other.codBanco != null) || (this.codBanco != null && !this.codBanco.equals(other.codBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BDProjeto.Banco[ codBanco=" + codBanco + " ]";
    }
    
}
