/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.Dao;

import br.com.kpc.locbus.core.Empresa;
import br.com.kpc.locbus.core.IRepositorioEmpresa;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author César
 */
public class EmpresaDao extends DaoGenerico<Empresa> implements IRepositorioEmpresa{
    
    public EmpresaDao(){
        super(Empresa.class);
    }

    @Override
    protected Long getCodigo(Empresa obj) {
        return obj.getId();
    }
    
    @Override
    public List<Empresa> listaTodas() {
        
        Query consulta = getManager().createQuery("select from Empresa order by Empresa.nome");
        return consulta.getResultList();
        
    }
    
}
