/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.core;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author César
 */
@Entity
@Table(name = "enderecos")
@XmlRootElement
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_endereco", nullable = false)    
    private Long id;
    
    @Column(length = 9)    
    private String cep;
    
    @Column(length = 200, nullable = false)    
    private String rua;
    
    @Column(length = 200, nullable = false)    
    private String bairro;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "parada_id", nullable = false, referencedColumnName = "codigo_parada")
    private Parada parada;
    
    @Column
    private int numero;

    public Endereco() {
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
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.kpc.locbus.core.Endereco[ id=" + id + " ]";
    }
}
