/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.resource;

import br.com.kpc.locbus.Dao.DaoGenerico;
import br.com.kpc.locbus.core.Empresa;
import br.com.kpc.locbus.core.IRepositorioEmpresa;
import br.com.kpc.locbus.servico.ContextoInicial;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.PathParam;

/**
 *
 * @author César
 */
public abstract class EmpresaFacade extends DaoGenerico<Empresa> implements IRepositorioEmpresa {

    public EmpresaFacade() {
        super(Empresa.class);
    }

    public List<Empresa> listaTodos() throws NamingException {

        IRepositorioEmpresa rp;
        List<Empresa> lst = new ArrayList<Empresa>();

        try {
            rp = (IRepositorioEmpresa) ContextoInicial.getContext().lookup("java:global/locBus/EmpresaDao");
            lst = rp.listaTodas();

        } catch (NamingException ex) {
            Logger.getLogger(EmpresaResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return lst;

    }
}
