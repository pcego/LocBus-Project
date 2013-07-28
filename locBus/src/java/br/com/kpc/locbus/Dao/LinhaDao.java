/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.Dao;

import br.com.kpc.locbus.core.Empresa;
import br.com.kpc.locbus.core.IRepositorioLinha;
import br.com.kpc.locbus.core.Linha;
import br.com.kpc.locbus.core.Parada;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author César
 */
public class LinhaDao extends DaoGenerico<Linha> implements IRepositorioLinha{
    
    public LinhaDao(){
        super(Linha.class);
    }

    @Override
    protected Long getCodigo(Linha obj) {
        return obj.getId();
    }

    @Override
    public List<Linha> listaTodos() {
        
        Query consulta = getManager().createQuery("select from Linha order by Linha.numeroLinha");
        return consulta.getResultList();
                
    }

    @Override
    public List<Linha> listaPorParada(Parada parada) {
        
        Query consulta = getManager().createQuery("");
        return consulta.getResultList();
    }

    @Override
    public List<Linha> listaLinhasPorEmpresa(Empresa empresa){
        
        Query consulta = getManager().createQuery("");
        return consulta.getResultList();
    }
}
