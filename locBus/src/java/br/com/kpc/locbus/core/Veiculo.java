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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author César
 */
@Entity
@Table(name = "veiculos")
public class Veiculo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo", nullable = false)
    private Long id;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "linha_id", referencedColumnName = "codigo_linha",
            nullable = false)
    private Linha linha;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "empresa_id", referencedColumnName = "codigo_empresa",
            nullable = false)
    private Empresa empresa;
    
    @OneToMany(mappedBy = "veiculo")
    private List<Posicao> posicao;
    
    @Column(nullable = false, length = 200)
    private String descricao;
    
    @Column(nullable = false)
    private boolean status;
    
    public Veiculo(){
        
    }
    
    public Linha getLinha() {
        return linha;
    }

    public void setLinha(Linha linha) {
        this.linha = linha;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Posicao> getPosicao() {
        return posicao;
    }

    public void setPosicao(List<Posicao> posicao) {
        this.posicao = posicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
        if (!(object instanceof Veiculo)) {
            return false;
        }
        Veiculo other = (Veiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.kpc.locbus.core.Veiculo[ id=" + id + " ]";
    }
    
}
