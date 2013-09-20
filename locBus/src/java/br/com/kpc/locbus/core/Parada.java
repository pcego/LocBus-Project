/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.core;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author César
 */
@Entity
@Table(name = "paradas")
//anotation para possibilitar o retorno como
//XML/JSON do objeto
@XmlRootElement
public class Parada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_parada", nullable = false)   
    private Long id;
    
    @Column(nullable = false)
    private double latitude;
    
    @Column(nullable = false)
    private double longitude;
    
    @Column(length = 200)
    private String descricao;
    
    @Column(nullable = false)
    private boolean status;
    
    @Column(nullable = false, length = 200)
    private String rua;
    
    @Column(nullable = false, length = 200)
    private String bairro;
    
    // direção centro bairro "0" 
    // direção bairro centro "1"
    @Column(nullable = false)
    private boolean direcao;
    
    @ManyToMany(mappedBy = "parada", fetch = FetchType.EAGER)
    private List<Linha> linha;

    // construtor padrão
    public Parada() {
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
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

    // anotations utilizadas para evitar o erro "ciclo no gráfico do objeto"
    // para relações bi-direcionais
    @JsonIgnore
    @XmlTransient
    public List<Linha> getLinha() {
        return linha;
    }

    public void setLinha(List<Linha> linha) {
        this.linha = linha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public boolean isDirecao() {
        return direcao;
    }

    public void setDirecao(boolean direcao) {
        this.direcao = direcao;
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
        if (!(object instanceof Parada)) {
            return false;
        }
        Parada other = (Parada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.kpc.locbus.core.Parada[ id=" + id + " ]";
    }
}
