/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.core;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author César
 */
@Entity
@Table(name = "linhas")
@XmlRootElement
public class Linha implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_linha", nullable = false)
    private Long id;
    
    @Column(nullable = false)
    private int numeroLinha;
    
    @Column(nullable = false, length = 100)
    private String tipoLinha;
    
    @Column(length = 150)
    private String pontoInicial;
    
    @Column(length = 150)
    private String pontoFinal;
    
    @Column(length = 150)
    private String horaInicial;
    
    @Column(length = 150)
    private String horaFinal;
    
    @Column(nullable = false)
    private boolean status;
    
    @OneToMany(mappedBy = "linha", fetch = FetchType.EAGER)
    private List<Veiculo> veiculo;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.EAGER)
    @JoinTable(name = "paradas_linhas", joinColumns = {
        @JoinColumn(name = "linha_id")}, inverseJoinColumns = {
        @JoinColumn(name = "parada_id")})
    private List<Parada> parada;

    public Linha() {
    }

    public int getNumeroLinha() {
        return numeroLinha;
    }

    public void setNumeroLinha(int numeroLinha) {
        this.numeroLinha = numeroLinha;
    }

    public String getTipoLinha() {
        return tipoLinha;
    }

    public void setTipoLinha(String tipoLinha) {
        this.tipoLinha = tipoLinha;
    }

    public String getPontoInicial() {
        return pontoInicial;
    }

    public void setPontoInicial(String pontoInicial) {
        this.pontoInicial = pontoInicial;
    }

    public String getPontoFinal() {
        return pontoFinal;
    }

    public void setPontoFinal(String pontoFinal) {
        this.pontoFinal = pontoFinal;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    @JsonIgnore
    public List<Veiculo> getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(List<Veiculo> veiculo) {
        this.veiculo = veiculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Linha)) {
            return false;
        }
        Linha other = (Linha) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.kpc.locbus.core.Linha[ id=" + id + " ]";
    }
}
